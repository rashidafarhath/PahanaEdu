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
                <li><a href="adminhelp.jsp">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="wrapperindex">
            <h1 class="h1index"> UPDATE USER </h1>
            <div class="maininfo">
                <div class="top">
                    <form action="updateUser" method="post"> 
                        <input class="text" type="text" name="cashierId" value="${param.userId}" readonly>
                        <input class="text" type="text" name="cashierName" value="${param.name}" required=""> 
                        <input class="text" type="text" name="cashierUsername" value="${param.username}" required=""> 
                        <input class="text" type="text" name="cashierPassword" value="${param.password}" required=""> 
                        <input type="submit" value="UPDATE USER">   
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>