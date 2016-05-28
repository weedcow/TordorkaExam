<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="model.Test"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Cars</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

	<link href='https://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700' rel='stylesheet' type='text/css'>

</head>

<body>
	<div id="wrapper">
		<div id="top">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<a href="Index.jsp"><img id="logo" src="images/logo2.png" /></a>
				</div>
				<div class="col-sm-8">
					<div class="loginHolder">
					<%
					Test user = new Test();
					if(session.getAttribute("user")  != null)
					{
						
						user = (model.Test) session.getAttribute("user");
						out.print("<span class='username'>Hello, <b>"+user.getFirstName()+"</b></span>");
						if(user.getLevel()  == 1) {
							out.print(" - <a href='admin.jsp'>Admin page</a>");
						}
						out.print(" - <a href='/javaScratch55/Controller?action=logout'>Logout</a>");
						
					} else {
						out.print("<button class='loginBtn' type='button' class='btn btn-primary btn-lg' data-toggle='modal' data-target='#myLogin'>Login <i class='fa fa-lock'></i></button><button class='loginBtn create' type='button' class='btn btn-primary btn-lg' data-toggle='modal' data-target='#myCreate'>Create user <i class='fa fa-plus'></i></button>");
					}
				 %>
						
					</div>

					
				</div>
			</div>
		</div>
	</div>


	<div id="content">
		<div id="banner">
		<div class="container">
				<div class="row">
		<div class="col-sm-8"></div>
			<div class="col-sm-4">
						<div class="weatherBox">
							<div class="render">
							<h3>Loading location</h3>
								<style type='text/css'>@-webkit-keyframes uil-default-anim { 0% { opacity: 1} 100% {opacity: 0} }@keyframes uil-default-anim { 0% { opacity: 1} 100% {opacity: 0} }.uil-default-css > div:nth-of-type(1){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.5s;animation-delay: -0.5s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(2){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.4166666666666667s;animation-delay: -0.4166666666666667s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(3){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.33333333333333337s;animation-delay: -0.33333333333333337s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(4){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.25s;animation-delay: -0.25s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(5){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.16666666666666669s;animation-delay: -0.16666666666666669s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(6){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: -0.08333333333333331s;animation-delay: -0.08333333333333331s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(7){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0s;animation-delay: 0s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(8){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0.08333333333333337s;animation-delay: 0.08333333333333337s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(9){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0.16666666666666663s;animation-delay: 0.16666666666666663s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(10){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0.25s;animation-delay: 0.25s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(11){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0.33333333333333337s;animation-delay: 0.33333333333333337s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}.uil-default-css > div:nth-of-type(12){-webkit-animation: uil-default-anim 1s linear infinite;animation: uil-default-anim 1s linear infinite;-webkit-animation-delay: 0.41666666666666663s;animation-delay: 0.41666666666666663s;}.uil-default-css { position: relative;background:none;width:200px;height:200px;}</style><div class='uil-default-css' style='transform:scale(0.29); margin: auto; margin-top: -35px;'><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(0deg) translate(0,-60px);transform:rotate(0deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(30deg) translate(0,-60px);transform:rotate(30deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(60deg) translate(0,-60px);transform:rotate(60deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(90deg) translate(0,-60px);transform:rotate(90deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(120deg) translate(0,-60px);transform:rotate(120deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(150deg) translate(0,-60px);transform:rotate(150deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(180deg) translate(0,-60px);transform:rotate(180deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(210deg) translate(0,-60px);transform:rotate(210deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(240deg) translate(0,-60px);transform:rotate(240deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(270deg) translate(0,-60px);transform:rotate(270deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(300deg) translate(0,-60px);transform:rotate(300deg) translate(0,-60px);border-radius:10px;position:absolute;'></div><div style='top:80px;left:93px;width:14px;height:40px;background:#fff;-webkit-transform:rotate(330deg) translate(0,-60px);transform:rotate(330deg) translate(0,-60px);border-radius:10px;position:absolute;'></div></div>
							</div>
							<div class="weatherTop">
								<div class="row">
									<div class="col-sm-6">
									<p class="weatherDay"><span>Monday</span></p>
									</div>
									<div class="col-sm-6">
										<p class="weatherDate"><span>May 22</span></p>
									</div>
								</div>
								
							</div>
							<div class="weatherBody">
								<div class="row">
									<div class="col-sm-6">
										<p class="weatherCity"><span>Copenhagen</span></p>
										<p class="weatherTemp"><span>20</span>&ordm;</p>
										<p class="weatherHigh"><i class="fa fa-arrow-up" aria-hidden="true"></i> <span>25</span>&ordm;</p>
										<p class="weatherLow"><i class="fa fa-arrow-down" aria-hidden="true"></i> <span>12</span>&ordm;</p>
										
									</div>
									<div class="col-sm-6">
										
										<img class="weatherIcon" src="" />
										<p class="weatherDesc"><span>Clo</span></p>
										<p class="weatherClouds"><i class="fa fa-cloud" aria-hidden="true"></i> <span>70</span>%</p>
										<p class="weatherWind"><i class="fa fa-flag" aria-hidden="true"></i> <span>2</span> m/s</p>
										<p class="weatherDirection"><i class="fa fa-compass" aria-hidden="true"></i> <span>SW</span></p>
									</div>
								</div>
															<div class="row">
								<div class="col-sm-12">
									<form class="changeWeatherForm">
										<div class="form-group">
											<select class="form-control" name='dropdown' onchange='loadCity(this)'>
												<option>Choose a city</option>
												<option value="copenhagen">Copenhagen</option>
												<option value="newyork">New York</option>
												<option value="london">London</option>
												<option value="sidney">Sidney</option>
											</select>
										</div>
									</form>
								</div>
							</div>
							</div>

						</div>
			
			</div>
		</div>
		</div>

		</div>
		<div class="container">
		
		