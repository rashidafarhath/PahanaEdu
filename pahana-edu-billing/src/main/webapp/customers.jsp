<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/mvc.css" media="all">
</head>
<body>
    <div class="navigationbar">
        <img src="Images/logo.png" class="logo">
       <nav>
            <ul>
                <li><a href="#contact">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="wrapper">
            <h1 class="h1">CUSTOMERS</h1>
        <div class="addbtn">
            <a href="addcustomer.jsp"> <input type="submit" value="ADD"> </a>
        </div>
        </div>
        <table>
        <thead>
           <tr>
              <th>Customer ID</th>
              <th>Name</th>
              <th>Address</th>
              <th>Telephone</th>
              <th>Units</th>
              <th>Actions</th>
            </tr>
        </thead>
		<tbody>
		

		<c:forEach var="cus" items="${customerList}">
		<tr>
			<td>${cus.cusId}</td>
			<td>${cus.cusname}</td>
			<td>${cus.cusadd}</td>
			<td>${cus.custel}</td>
			<td>${cus.cusunit}</td>
			
			<td>
			<form action="updateCustomer.jsp" method="post" style="display:inline">
				<input type="hidden" name="customerId" value="${cus.cusId}">
				<input type="hidden" name="customername" value="${cus.cusname}">
				<input type="hidden" name="customeraddress" value="${cus.cusadd}">
				<input type="hidden" name="customerphone" value="${cus.custel}"> 
				<input type="hidden" name="customerunits" value="${cus.cusunit}">
				<input type="submit" value="Update" class="btn updatebtn">
			</form>
			
			<form action="deleteCustomer" method="post" style="display:inline;">
				<input type="hidden" name="customerId" value="${cus.cusId}">
				<button type="submit" class="btn deletebtn">Delete</button>
			</form>
			</td>
		</tr>
		</c:forEach>
		</tbody>
    </table>
    </div>
</body>
</html>