<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
            <h1 class="h1index"> UPDATE CUSTOMER </h1>
            <div class="maininfo">
                <div class="top">
                    <form action="updateCustomer" method="post"> 
                        <input class="text" type="text" name="customerId" value="${param.customerId}" readonly>
                        <input class="text" type="text" name="customername" value="${param.customername}"> 
                        <input class="text" type="text" name="customeraddress" value="${param.customeraddress}"> 
                        <input class="text" type="text" name="customerphone" value="${param.customerphone}"> 
                        <input class="text" type="text" name="customerunits" value="${param.customerunits}" readonly> 
                        <input type="submit" value="UPDATE CUSTOMER">   
                        
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>