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

                <li><a href="adminhelp.jsp">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="wrapper">
            <h1 class="h1">USERS</h1>
        <div class="addbtn">
            <a href="adduser.jsp"> <input type="submit" value="ADD"> </a>
        </div>
        </div>
        <% 
		    String successMessage = (String) request.getAttribute("successMessage");
		    if (successMessage != null) { 
		%>
		    <script>
		        alert("<%= successMessage %>");
		    </script>
		<% 
		    } 
		%>
        <table>
        <thead>
           <tr>
              <th>User ID</th>
              <th>Name</th>
              <th>Username</th>
              <th>Password</th>
              <th>Actions</th>
            </tr>
        </thead>
		<tbody>
		

		<c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.cashierId}</td>
        <td>${user.cashierName}</td>
        <td>${user.cashierUsername}</td>
        <td>${user.cashierspassword}</td>
        
        <td>
            <form action="updateuser.jsp" method="post" style="display:inline">
                <input type="hidden" name="userId" value="${user.cashierId}">
                <input type="hidden" name="name" value="${user.cashierName}">
                <input type="hidden" name="username" value="${user.cashierUsername}">
                <input type="hidden" name="password" value="${user.cashierspassword}">
                <input type="submit" value="Update" class="btn updatebtn">
            </form>
            
            <form action="deleteUser" method="post" style="display:inline;">
                <input type="hidden" name="cashierId" value="${user.cashierId}">
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