<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"	%>

<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%  
if(session.getAttribute("user") == null)
{
	response.sendRedirect("Index.jsp");
}




%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1><% %></h1>

<form action="${pageContext.request.contextPath}/Controller?action=createCar" method="post">
	<input type="text" name="brand" value="" placeholder="Brand"></input>
	<input type="text" name="model" value="" placeholder="model"></input>
	<input type="text" name="price" value="" placeholder="Price"></input>
	<select name="aircon">
		<option value="">Aircondition</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>	
	</select>
	<select name="seats">
		<option value="">Seats</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>			
	</select>
	<select name="gear">
		<option value="">Gearbox</option>
		<option value="Auto">Auto</option>
		<option value="Manual">Manual</option>	
	</select>
	<input type="text" name="luggage" value="" placeholder="Luggage"></input>
	<select name="age">
		<option value="">Required age</option>
		<option value="18">18</option>
		<option value="21">21</option>	
	</select>
	<button class="loginBtn" type="submit" name="">Create <i class="fa fa-lock"></i></button>
</form>

<h2>Update Cars</h2>
<a href="/javaScratch55/Controller?action=returnCars">Print Cars</a>
<table>
	<thead>
		<tr>
			<td>carId</td>
			<td>Brand</td>
			<td>Model</td>
			<td>Price</td>
			<td>Status</td>
			<td>Owner</td>
			<td>Aircon</td>
			<td>Seats</td>
			<td>Gearbox</td>
			<td>Doors</td>
			<td>Luggage</td>
			<td>ReqAge</td>
			<td>Deleted</td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="item" items="${carslistAdmin}">
				
					<tr>
					<form action="${pageContext.request.contextPath}/Controller?action=updateCar" method="post">
						<td><input name="carId" value="${item.getID()}"></td>
						<td><input name="brand" value="${item.getBrand()}"></td>
						<td><input name="model" value="${item.getModel()}"></td>
						<td><input name="price" value="${item.getPrice()}"></td>
						<td><input name="status" value="${item.getStatus()}"></td>
						<td><input name="owner" value="${item.getOwner()}"></td>
						<td><input name="aircon" value="${item.getAircon()}"></td>
						<td><input name="seats" value="${item.getSeats()}"></td>
						<td><input name="gear" value="${item.getGearbox()}"></td>
						<td><input name="doors" value="${item.getDoors()}"></td>
						<td><input name="luggage" value="${item.getLuggage()}"></td>
						<td><input name="age" value="${item.getReqAge()}"></td>
						<td><input name="deleted" value="${item.getDeleted()}"></td>
						<td><button class="loginBtn" type="submit" name="">Update<i class="fa fa-lock"></i></button></td>
						<td><a href="${pageContext.request.contextPath}/Controller?action=deleteCar&carId=${item.getID()}">Delete</a></td>
					</form>
					</tr>
				
			</c:forEach>
	</tbody>
</table>

<h1>User Editing</h1>

<a href="/javaScratch55/Controller?action=returnUsers">Print Cars</a>
<table>
	<thead>
		<tr>
			<td>userId</td>
			<td>username</td>
			<td>password</td>
			<td>email</td>
			<td>first name</td>
			<td>last name</td>
			<td>phone</td>
			<td>level</td>
			<td>deleted</td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="item" items="${userlist}">
				
					<tr>
					<form action="${pageContext.request.contextPath}/Controller?action=updateUser" method="post">
						<td><input name="userId" value="${item.getID()}"></td>
						<td><input name="username" value="${item.getUsername()}"></td>
						<td><input name="password" value="${item.getPassword()}"></td>
						<td><input name="email" value="${item.getEmail()}"></td>
						<td><input name="firstName" value="${item.getFirstName()}"></td>
						<td><input name="lastName" value="${item.getLastName()}"></td>
						<td><input name="phone" value="${item.getPhone()}"></td>
						<td><input name="level" value="${item.getLevel()}"></td>
						<td><input name="deleted" value="${item.getDeleted()}"></td>
						<td><button class="loginBtn" type="submit" name="">Update<i class="fa fa-lock"></i></button></td>
						<td><a href="${pageContext.request.contextPath}/Controller?action=deleteUser&userId=${item.getID()}">Delete</a></td>
					</form>
					</tr>
				
			</c:forEach>
	</tbody>
</table>


</body>
</html>