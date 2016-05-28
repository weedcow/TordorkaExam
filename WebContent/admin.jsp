<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@page import="model.Test"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"	%>

<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/header.jsp" %>   
<%  
if(session.getAttribute("user") == null)
{
	response.sendRedirect("Index.jsp");
}else
{
user = (model.Test) session.getAttribute("user");
	if(user.getLevel() != 1)
	{
		System.out.println("Not admin");
		response.sendRedirect("Index.jsp");
	}
}

%>

<div class="adminBtn">
	<div class="row">
		<div class="col-sm-3"><button class="getClick" data-name="new">Add car</button></div>
		<div class="col-sm-3"><a class="getClick" data-name="car" href="/javaScratch55/Controller?action=returnCars"><button>Update cars</button></a></div>
		<div class="col-sm-3"><a class="getClick" data-name="user" href="/javaScratch55/Controller?action=returnUsers"><button>Update users</button></a></div>
		<div class="col-sm-3"><a class="getClick" data-name="return" href="/javaScratch55/Controller?action=returnCarsReturn"><button>Return cars</button></a></div>
	</div>
</div>


<div class="addNewDiv">
<h3>Add new car</h3>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/Controller?action=createCar" method="post">
			<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<label for="brand">Brand</label>
				<input class="form-control" type="text" name="brand" value="" placeholder="Ex: Ford"></input>
				</div>
				
				<div class="form-group">
					<label for="model">Model</label>
					<input class="form-control" type="text" name="model" value="" placeholder="Ex: Mondeo"></input>
				</div>
				<div class="form-group">
					<label for="price">Price</label>
					<input class="form-control" type="text" name="price" value="" placeholder="Ex: 500"></input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="aircon">Aircondition</label>
					<select class="form-control" name="aircon">
						<option value="">Aircondition</option>
						<option value="Yes">Yes</option>
						<option value="No">No</option>	
					</select>
				</div>
				<div class="form-group">
				<label for="seats">Seats</label>
				<select class="form-control" name="seats">
					<option value="">Seats</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>			
				</select>
				</div>
				<div class="form-group">
					<label for="gear">Gear</label>
					<select class="form-control" name="gear">
						<option value="">Gearbox</option>
						<option value="Auto">Auto</option>
						<option value="Manual">Manual</option>	
					</select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="luggage">Luggage</label>
					<select class="form-control" name="luggage">
						<option value="">Luggage</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>			
					</select>
				</div>
				<div class="form-group">
					<label for="age">Age</label>
					<select class="form-control" name="age">
						<option value="">Required age</option>
						<option value="18">18</option>
						<option value="21">21</option>	
					</select>
				</div>
			</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<button type="submit" name="">Create car</i></button>
					</div>
				</div>
			</div>

		</form>
</div>



<div class="updateCarDiv">
<h3>Update Cars</h3>
<div class="table-responsive-force">
<table class="table ">
	<thead>
		<tr>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
			<th>Status</th>
			<th>Owner</th>
			<th>Aircon</th>
			<th>Seats</th>
			<th>Gearbox</th>
			<th>Doors</th>
			<th>Luggage</th>
			<th>ReqAge</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="item" items="${carslistAdmin}">
				
					<tr>
					<form action="${pageContext.request.contextPath}/Controller?action=updateCar" method="post">
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
						<td><input type="hidden" name="deleted" value="${item.getDeleted()}"></td>
						<td><input type="hidden" name="carId" value="${item.getID()}"></td>
						<td><button type="submit" name="">Update</button></td>
						<td><a href="${pageContext.request.contextPath}/Controller?action=deleteCar&carId=${item.getID()}">Delete</a></td>
					</form>
					</tr>
				
			</c:forEach>
	</tbody>
</table>
</div>
</div>






<div class="updateUserDiv">
<h3>User Editing</h3>
<div class="table-responsive-force">
<table class="table">
	<thead>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Email</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Phone</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="item" items="${userlist}">
				
					<tr>
					<form action="${pageContext.request.contextPath}/Controller?action=updateUser" method="post">

						<td><input name="username" value="${item.getUsername()}"></td>
						<td><input name="password" value="${item.getPassword()}"></td>
						<td><input name="email" value="${item.getEmail()}"></td>
						<td><input name="firstName" value="${item.getFirstName()}"></td>
						<td><input name="lastName" value="${item.getLastName()}"></td>
						<td><input name="phone" value="${item.getPhone()}"></td>
						<td><input type="hidden" name="userId" value="${item.getID()}"></td>
						<td><input type="hidden" name="deleted" value="${item.getDeleted()}"></td>
						<td><input type="hidden" name="level" value="${item.getLevel()}"></td>
						<td><button type="submit" name="">Update user</button></td>
						<td><a href="${pageContext.request.contextPath}/Controller?action=deleteUser&userId=${item.getID()}">Delete</a></td>
					</form>
					</tr>
				
			</c:forEach>
	</tbody>
</table>
</div>
</div>

<!--  admin list -->
	<table>	
		<tbody>			
			<c:forEach var="item" items="${carslistAdminReturn}">
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

						<div class="rightBox buyBtn d${item.getOwner()} returnCar">
						 	<a href="/javaScratch55/Controller?action=returnSpecificCar&carId=${item.getID()}"><span>RETURN CAR</span></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>




<span class="pageHidden" style="display: none;">admin</span>

<%@ include file="includes/footer.jsp" %>