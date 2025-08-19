<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/adminhome.css" media="all">
</head>
<body>
    <div class="navigationbar">
        <img src="Images/logo.png" class="logo">
        <nav>
            <ul>
                
                <li><a href="help.jsp">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div>
        <div class="container">  
        <c:if test="${not empty message}">
                <p style="color: ${message.contains('success') ? 'green' : 'red'};">${message}</p>
            </c:if>
            <div class="row">
                <div class="col">
                    <h1>PAHANA EDU</h1>
                    <P id="p1">Books and Stationaries</P>
                    <p>GOOD DAY SIR! </P>  
                </div>
                <div class="colc">
                <form action="viewUser" method="post" style="display:inline;">
                    <button type="submit" style="all:unset; cursor:pointer;" >
                    <div class="card card1">
                        <h5>USERS</h5>
                    </div>
                    </button> 
                    </form>
                    
                    <form action="viewCustomer" method="post" style="display:inline;">
    				<button type="submit" style="all:unset; cursor:pointer;"> 
                    <div class="card card2">
                        <h5>CUSTOMERS</h5>
                    </div> 
                    </button>
				    </form>
                    <br>
                    
                    
                    <form action="viewProduct" method="post" style="display:inline;">
    				<button type="submit" style="all:unset; cursor:pointer;">
        			<div class="card card3">
            		<h5>PRODUCTS</h5>
        			</div>
    				</button>
				    </form>
                    
                    
                    <form action="" method="post" style="display:inline;">
                    <button type="submit" style="all:unset; cursor:pointer;">
                        <div class="card card4">
                        <h5>BILLING</h5>
                    </div>  </button></form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>