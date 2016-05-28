<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %> 
<%@page import="model.Test" %>

    
<%@ include file="includes/header.jsp" %>
	
	<h2>Rent cars</h2>
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
							<li class="icon-ac"><strong></strong>${item.getAircon()}</li>
							<li class="icon-seats"><strong></strong>${item.getSeats()}</li>
							<li class="icon-gears"><strong></strong>${item.getGearbox()}</li>
							<li class="icon-doors"><strong></strong>${item.getDoors()}</li>
							<li class="icon-bags"><strong></strong>${item.getLuggage()}</li>
							<li class="icon-age"><strong></strong>${item.getReqAge()}</li>
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
	


	
	
	<h1>
	
	<%= (request.getAttribute("logInResponse") == null) ? "" : request.getAttribute("logInResponse") %>
	</h1>
	
<%@ include file="includes/modals.jsp" %>
<%@ include file="includes/footer.jsp" %>