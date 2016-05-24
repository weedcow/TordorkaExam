<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %> 
<%@page import="model.Test" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
					<img id="logo" src="images/logo.png" />
				</div>
				<div class="col-sm-8">
					<div class="loginHolder">
						<!--   <button class="loginBtn">Login <i class="fa fa-lock"></i></button>-->
											<button class="loginBtn" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myLogin">
					  Login <i class="fa fa-lock"></i>
					</button>
					<button class="loginBtn create" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myCreate">
					  Create user <i class="fa fa-plus"></i>
					</button>
					</div>

					
				</div>
			</div>
		</div>
	</div>
	<div id="banner">

	</div>

	<div id="content">
		<div class="container">
			<div class="frontText">
				<h1>Rent a car today!</h1>
				<p>Lorem ipsum dolor sit amet, cursus volutpat volutpat tempor urna bibendum, ultrices arcu in. </p>
				<p>Lorem ipsum dolor sit amet, cursus volutpat volutpat tempor urna bibendum. </p>
			</div>
			
	<a href="/javaScratch55/Controller?action=cookieSearch">Search Cookies</a>
	<a href="/javaScratch55/Controller?action=getUsernames">Print SQL Names</a>
	
	<table>	
		<tbody>			
			<c:forEach var="item" items="${usernamelist}">
				<tr>
					<td>${item.getID()}</td>
					<td>${item.getUsername()}</td>
					<td>${item.getPassword()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	<div class="seeCars">
		<a id="showCars" href="/javaScratch55/Controller?action=getCars">Show all cars</a>
	</div>
	<a href="/javaScratch55/Controller?action=returnCars">Return Cars (Admin)</a>
	
	
	<table>	
		<tbody>			
			<c:forEach var="item" items="${carslist}">
<%-- 				<tr>
					<td>${item.getID()}</td>
					<td>${item.getBrand()}</td>
					<td>${item.getModel()}</td>
					<td>${item.getPrice()}</td>
					<td>${item.getUser().getUsername()}</td>
					<td class="buyBtn d${item.getOwner()}"><a href="/javaScratch55/Controller?action=buyCar&carId=${item.getID()}">Køb!</a></td>
				</tr> --%>
				
				<div class="box clearfix">
				<div class="row">
					<div class="col-sm-5">
						<div class="carImg">
							<img src="images/car1.png" />
						</div>
					</div>
					<div class="col-sm-3 boxPadding">
						<p>Car type: Sedan, Hatchback...</p>
						<h3>${item.getBrand()} ${item.getModel()}</h3>
						<p class="renting"><span class="bold">${item.getUser().getUsername()}</span> is currently renting this car.</p>
					</div>
					<div class="col-sm-4 boxPadding">
						<ul class="carSpecs">
							<li class="icon-ac"><strong></strong>Air Condition</li>
							<li class="icon-seats"><strong></strong>Seats</li>
							<li class="icon-gears"><strong></strong>Gearbox</li>
							<li class="icon-doors"><strong></strong>Doors</li>
							<li class="icon-bags"><strong></strong>Luggage</li>
							<li class="icon-age"><strong></strong>Req. Age</li>
						</ul>
						
					</div>
				</div>
					<div class="lowerBox">
						<div class="leftBox">
							Price per day: ${item.getPrice()} $
						</div>

						<div class="rightBox buyBtn d${item.getOwner()} lalala">
						 	<a href="/javaScratch55/Controller?action=buyCar&carId=${item.getID()}"><span>BOOK CAR</span></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
	


	<!--  admin list -->
	<table>	
		<tbody>			
			<c:forEach var="item" items="${carslistAdmin}">
<%-- 				<tr>
					<td>${item.getID()}</td>
					<td>${item.getBrand()}</td>
					<td>${item.getModel()}</td>
					<td>${item.getPrice()}</td>
					<td>${item.getUser().getUsername()}</td>
					<td class="buyBtn d${item.getOwner()}"><a href="/javaScratch55/Controller?action=buyCar&carId=${item.getID()}">Køb!</a></td>
				</tr> --%>
				
				<div class="box clearfix">
				<div class="row">
					<div class="col-sm-5">
						<div class="carImg">
							<img src="images/car1.png" />
						</div>
					</div>
					<div class="col-sm-3 boxPadding">
						<p>Car type: Sedan, Hatchback...</p>
						<h3>${item.getBrand()} ${item.getModel()}</h3>
						<p class="renting"><span class="bold">${item.getUser().getUsername()}</span> is currently renting this car.</p>
					</div>
					<div class="col-sm-4 boxPadding">
						<ul class="carSpecs">
							<li class="icon-ac"><strong></strong>Air Condition</li>
							<li class="icon-seats"><strong></strong>Seats</li>
							<li class="icon-gears"><strong></strong>Gearbox</li>
							<li class="icon-doors"><strong></strong>Doors</li>
							<li class="icon-bags"><strong></strong>Luggage</li>
							<li class="icon-age"><strong></strong>Req. Age</li>
						</ul>
						
					</div>
				</div>
					<div class="lowerBox">
						<div class="leftBox">
							Price per day: ${item.getPrice()} $
						</div>

						<div class="rightBox buyBtn d${item.getOwner()} returnCar">
						 	<a href="/javaScratch55/Controller?action=returnSpecificCar&carId=${item.getID()}"><span>RETURN CAR</span></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>
	
	<%= (request.getAttribute("logInResponse") == null) ? "" : request.getAttribute("logInResponse") %>
	</h1>
	

		</div>
	</div>

	<div id="footer">
		<div class="container">
		Rent a Car Aps - Copyright 2016 ©
		</div>
	</div>

</div>




<!-- Modal LOGIN -->
<div class="modal fade" id="myLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/Controller?action=logIn" method="post">
			<input type="text" name="username" value="" placeholder="Username"></input>
			<input type="password" name="password" value="" placeholder="Password"></input>
			<button class="loginBtn" type="submit" name="">Login <i class="fa fa-lock"></i></button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal CREATE -->
<div class="modal fade" id="myCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Create user</h4>
      </div>
      <div class="modal-body">
 		<form action="${pageContext.request.contextPath}/Controller?action=createUser" method="post">
			<input type="text" name="username" value="" placeholder="Username"></input>
			<input type="password" name="password" value="" placeholder="Password"></input>
			<button class="loginBtn" type="submit" name="">Create <i class="fa fa-lock"></i></button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script>
$( document ).ready(function() {
	
	
	
	if ($(".buyBtn").hasClass("d0")) {
		  $(".d0").find("span").text("BOOK CAR");
		  $(".d0").removeClass("lalala")
	} 
	
	$(".lalala").find("span").text("NOT AVAILABLE");
	
	$(".lalala").find("a").click(function( event ) {
		  event.preventDefault();
			console.log("Prevented default")
		});
});
</script>


</body>
</html>