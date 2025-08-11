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
        
         <table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
    </tr>
    <c:forEach var="product1" items="${products}">
        <tr>
            <td>${product1.id}</td>
            <td>${product1.name}</td>
            <td>${product1.price}</td>
            <td>${product1.quantity}</td>
            <td>${product1.desc}</td>

        </tr>
    </c:forEach>
</table>
    </div>
</body>
</html>