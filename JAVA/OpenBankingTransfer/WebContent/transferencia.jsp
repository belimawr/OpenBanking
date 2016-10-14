<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Kickstarter * Original -> OPen Banking</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/transfer_static/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/transfer_static/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/transfer_static/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/transfer_static/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Transferência entre Contas Original - Open Banking</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<span class="li-text">
								Put some text or
							</span> 
							<a href="#"><strong>links</strong></a> 
							<span class="li-text">
								here, or some icons: 
							</span> 
							<span class="li-social">
								<a href="https://www.facebook.com/pages/Azmindcom/196582707093191" target="_blank"><i class="fa fa-facebook"></i></a> 
								<a href="https://twitter.com/anli_zaimi" target="_blank"><i class="fa fa-twitter"></i></a> 
								<a href="https://plus.google.com/+AnliZaimi_azmind" target="_blank"><i class="fa fa-google-plus"></i></a> 
								<a href="https://github.com/AZMIND" target="_blank"><i class="fa fa-github"></i></a>
							</span>
						</li>
					</ul>
				</div>
			</div>
		</nav>

        <!-- Top content -->
        <div class="top-content">
            <div class="container">
                
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1>Original <strong>Open Banking</strong> </h1>
                        <div class="description">
                       	    <p>
                                Transferência entre Contas Original - Open Banking 
                            </p>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3 form-box">
                    	<form role="form" action="/OpenBankingTransfer/TransferServlet" method="post" class="f1">
                    		<h3>Preencha os campos abaixo</h3>
                    		<p>O horário permitido para transferência é das 6h às 23h</p>
                    		<div class="f1-steps">
                    			<div class="f1-progress">
                    			    <div class="f1-progress-line" data-now-value="16.66" data-number-of-steps="3" style="width: 16.66%;"></div>
                    			</div>
                    			<div class="f1-step active">
                    				<div class="f1-step-icon"><i class="fa fa-user"></i></div>
                    				<p>Destinatário</p>
                    			</div>
                    			<div class="f1-step">
                    				<div class="f1-step-icon"><i class="fa fa-key"></i></div>
                    				<p>Confirmação</p>
                    			</div>
                    		    <div class="f1-step">
                    				<div class="f1-step-icon"><i class="fa fa-twitter"></i></div>
                    				<p>Concluído</p>
                    			</div>
                    		</div>

                    		<fieldset>
                    		    <h4>Para quem deseja transferir ?</h4>
                    			<div class="form-group">
                                    <input type="text" name="account_number" id="account_number" value="${account_number}" placeholder="Número da Conta" class="f1-first-name form-control" >
                                </div>
                                <div class="form-group">
                                    <input type="text" name="amount" id="amount" value="${amount}" placeholder="Valor da Transferência" class="f1-last-name form-control">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="comments" id="comments" value="${comments}" placeholder="Comentários" class="f1-last-name form-control" >
                                </div>
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-next_1">Avançar</button>
                                </div>
                            </fieldset>

                            <fieldset>
                                <h4>Verifique os dados abaixo e confirme:</h4>
								<span>
									Nome Destinatário: 
									<strong id="confirmation_recipient_name"></strong>
								</span>
								<br>
								<span>
									Número da Conta: 
									<strong id="confirmation_account_number"></strong>
								</span>
								<br>
								<span>
									 Valor da Transferência
									 <strong id="confirmation_amount"></strong>
								</span>
								<hr>
                                <div class="form-group">
                                    <input type="password" name="token" id="token" placeholder="Informe seu token para confirmar" class="f1-password form-control">
                                </div>
                                <div class="f1-buttons">
                                    <button type="button" class="btn btn-previous">Voltar</button>
                                    <button type="button" class="btn btn-next_2">Confirmar</button>
                                </div>
                            </fieldset>

                            <fieldset>
                                <h4>Comprovante:</h4>
                                <h4>Sua transferência foi concluída, quer compartilhar o comprovante com a pessoa ?</h4>

                                <span>Número Referência: <strong id="share_confirmation_code"></strong> </span> <br>
                                <span>Favorecido: <strong id="share_recipient_name"></strong> </span> <br>
                                <span>Data Transferência: <strong id="share_date"></strong> </span> <br>
                                <span>Valor: <strong id="share_amount"></strong> </span> <br>

								<hr>

                                <div class="f1-buttons">
								<button type="button" id="dont_share" class="btn btn-previous">Não, obrigado</button>
								<button type="button" id="share" class="btn btn-submit" onclick="share_this()"  >Quero Compartilhar</button>
                                </div>
                            </fieldset>
	                    	<span id="oops" style="font-size:large; color: red; display: none;">
	                    		<span id="message"></span> <br/> <span id="errors"></span>
	                    	</span>
                    	</form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/transfer_static/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/transfer_static/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/transfer_static/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/transfer_static/js/retina-1.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/transfer_static/js/scripts.js"></script>
        <script src="${pageContext.request.contextPath}/transfer_static/js/whats.js"></script>

        <!--[if lt IE 10]>
            <script src="${pageContext.request.contextPath}/transfer_static/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>