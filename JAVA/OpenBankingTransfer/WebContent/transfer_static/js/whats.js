function share_this() {
	if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
		date = $("#share_date").html()
		amount = $("#share_amount").html()
		number_account = $("#share_number_acount").html()

		var sText = "Comprovante de transferência realizada em "+date+" no valor de "+amount+" para a conta "+number_account;
		var sMsg = encodeURIComponent(sText);
		var whatsapp_url = "whatsapp://send?text=" + sMsg;
		window.location.href = whatsapp_url;
	} else {
		$("#share_whats").prop("disabled", true);
	}
}
