<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/addproduct.css" media="all">
</head>
<body>
    <div class="navigationbar">
        <img src="Images/logo.png" class="logo">
    </div>

    <div class="container">
        <div class="wrapperindex">
            <h1 class="h1index"> SIGN IN </h1>
            <div class="maininfo">
                <div class="top">
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
          <form action="login" method="post">
               <input class="text" type="text" name="Username" placeholder="Username" required=""> 
               <input class="text" type="password" name="password" placeholder="Password" required=""> 
               <input type="submit" value="SIGN IN">    
          </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>