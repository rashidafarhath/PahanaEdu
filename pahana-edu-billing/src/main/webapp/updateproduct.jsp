<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/addproduct.css" media="all">
</head>
<body>
    <div class="navigationbar">
        <img src="Images/logo.png" class="logo">
        <nav>
            <ul>
               <!-- <li><a href="index.html">HOME</a></li>-->
                <li><a href="#contact">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="wrapperindex">
            <h1 class="h1index"> UPDATE PRODUCT </h1>
            <div class="maininfo">
                <div class="top">
                    <form action="updateProduct" method="post"> 
                        <input class="text" type="text" name="productId" value="${param.productId}" readonly>
                        <input class="text" type="text" name="name" value="${param.name}"> 
                        <input class="text" type="text" name="price" value="${param.price}"> 
                        <input class="text" type="text" name="quantity" value="${param.quantity}"> 
                        <input class="text" type="text" name="description" value="${param.description}"> 
                        <input type="submit" value="UPDATE PRODUCT">   
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>