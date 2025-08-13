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
            <h1 class="h1">PRODUCTS</h1>
        <div class="addbtn">
            <a href="addproduct.jsp"> <input type="submit" value="ADD"> </a>
        </div>
        </div>
         
     <table>
        <thead>
           <tr>
              <th>Product ID</th>
              <th>Name</th>
              <th>Price (LKR)</th>
              <th>Quantity</th>
              <th>Description</th>
              <th>Actions</th>
            </tr>
        </thead>
		<tbody>
		

		<c:forEach var="p" items="${productList}">
		<tr>
			<td>${p.productId}</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td>${p.quantity}</td>
			<td>${p.description}</td>
			
			<td>
			<form action="updateproduct.jsp" method="post" style="display:inline">
				<input type="hidden" name="productId" value="${p.productId}">
				<input type="hidden" name="name" value="${p.name}">
				<input type="hidden" name="price" value="${p.price}">
				<input type="hidden" name="quantity" value="${p.quantity}">
				<input type="hidden" name="description" value="${p.description}">
				<input type="submit" value="Update" class="btn updatebtn">
			</form>
			
			<form action="deleteProduct" method="post" style="display:inline;">
				<input type="hidden" name="productId" value="${p.productId}">
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