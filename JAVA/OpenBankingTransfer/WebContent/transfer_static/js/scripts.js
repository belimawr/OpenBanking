
function scroll_to_class(element_class, removed_height) {
	var scroll_to = $(element_class).offset().top - removed_height;
	if($(window).scrollTop() != scroll_to) {
		$('html, body').stop().animate({scrollTop: scroll_to}, 0);
	}
}

function bar_progress(progress_line_object, direction) {
	var number_of_steps = progress_line_object.data('number-of-steps');
	var now_value = progress_line_object.data('now-value');
	var new_value = 0;
	if(direction == 'right') {
		new_value = now_value + ( 100 / number_of_steps );
	}
	else if(direction == 'left') {
		new_value = now_value - ( 100 / number_of_steps );
	}
	progress_line_object.attr('style', 'width: ' + new_value + '%;').data('now-value', new_value);
}

jQuery(document).ready(function() {

    /* Fullscreen background */
    $.backstretch("transfer_static/img/backgrounds/1.jpg");
    
    $('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch("resize");
    });
    $('#top-navbar-1').on('hidden.bs.collapse', function(){
    	$.backstretch("resize");
    });
    
    /* Form */
    $('.f1 fieldset:first').fadeIn('slow');
    
    $('.f1 input[type="text"], .f1 input[type="password"], .f1 textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    
    $('#share').on('click', function() {
    	alert("não pode...")
    	window.location = window.location.hostname+":8080/OpenBankingTransfer"
    });

    $('#dont_share').on('click', function() {
    	window.location = window.location.hostname+":8080/OpenBankingTransfer"
    });

    // next step
    $('.f1 .btn-next_1').on('click', function() {
    	$("#oops").fadeOut()
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');

    	parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});

    	data = {amount: $("#amount").val(), account_number: $("#account_number").val(), comments: $("#comments").val() }
    	$.ajax({
    		  type: "POST",
    		  url: "/OpenBankingTransfer/TransferServlet",
    		  data: JSON.stringify(data),
    		  dataType: "json",
    		  contentType: "application/json",
    		  complete: function (data, textStatus){
    			  var responseJSON = data.responseJSON;
    			  console.log(responseJSON)
    			  if (data.status != 200) {
    				  $("#oops").fadeIn()
    				  $("#message").html("Ocorreu um erro desconhecido ┌( ಠ_ಠ )┘")
    				  message = responseJSON["message"]
    				  detail = responseJSON["errors"][0]["message"]
    				  code = responseJSON["errors"][0]["code"]
    				  $("#message").html(message + " ( ◕ ٥ ◕ )")
    				  $("#errors").html(detail+" - "+code)
    			  } else {
					  $("#confirmation_account_number").html(responseJSON["account_number"]);
					  $("#confirmation_recipient_name").html(responseJSON["recipient_name"]);
					  $("#confirmation_amount").html(responseJSON["amount"]);
    				  parent_fieldset.fadeOut(400, function() {
    					  current_active_step.removeClass('active').addClass('activated').next().addClass('active');
    					  bar_progress(progress_line, 'right');
    					  $(this).next().fadeIn();
    					  scroll_to_class( $('.f1'), 20 );
    				  });
    			  }
    		  }
    	});

    });

    $('.f1 .btn-next_2').on('click', function() {
    	$("#oops").fadeOut()
    	var parent_fieldset = $(this).parents('fieldset');
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');

    	parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});

    	data = {token: $("#token").val()}
    	$.ajax({
    		  type: "POST",
    		  url: "/OpenBankingTransfer/TransferConfirmServlet",
    		  data: JSON.stringify(data),
    		  dataType: "json",
    		  contentType: "application/json",
    		  complete: function (data, textStatus, xhr){
    			  var responseJSON = data.responseJSON;
    			  if (data.status != 200) {
    				  $("#oops").fadeIn()
    				  $("#message").html("Ocorreu um erro desconhecido ┌( ಠ_ಠ )┘")
    				  message = responseJSON["message"]
    				  detail = responseJSON["errors"][0]["message"]
    				  code = responseJSON["errors"][0]["code"]
    				  $("#message").html(message + " ( ◕ ٥ ◕ )")
    				  $("#errors").html(detail+" - "+code)
    			  } else {
					  $("#share_confirmation_code").html(responseJSON["confirmation_code"])
                      $("#share_recipient_name").html(responseJSON["recipient_name"])
                      $("#share_date").html(responseJSON["date"])
                      $("#share_amount").html(responseJSON["amount"])
    				  parent_fieldset.fadeOut(400, function() {
    					  current_active_step.removeClass('active').addClass('activated').next().addClass('active');
    					  bar_progress(progress_line, 'right');
    					  $(this).next().fadeIn();
    					  scroll_to_class( $('.f1'), 20 );
    				  });
    			  }
    		  }
    	});
    });

    // previous step
    $('.f1 .btn-previous').on('click', function() {
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');
    	$(this).parents('fieldset').fadeOut(400, function() {
    		current_active_step.removeClass('active').prev().removeClass('activated').addClass('active');
    		bar_progress(progress_line, 'left');
    		$(this).prev().fadeIn();
			scroll_to_class( $('.f1'), 20 );
    	});
    });

    //validate on all steps
    $('.f1').on('submit', function(e) {
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    });

});
