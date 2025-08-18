<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/adduser.css" media="all">
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
            <h1 class="h1index"> ADD USER </h1>
            <div class="maininfo">
                <div class="top">
                    <% if (request.getAttribute("error") != null) { %>
                        <p style="color: red; text-align: center;"><%= request.getAttribute("error") %></p>
                    <% } %>
                    <% if (request.getAttribute("success") != null) { %>
                        <p style="color: green; text-align: center;"><%= request.getAttribute("success") %></p>
                    <% } %>
                    <form method="post" action="UserController" onsubmit="return validateForm()">
                        <input class="text" type="text" name="cashierName" placeholder="Name" required>
                        <input class="text" type="text" name="username" placeholder="Username" required>
                        <input class="text" type="password" id="password" name="password" placeholder="Password" required>
                        <input class="text" type="password" id="confirmPassword" name="confirmPassword" placeholder="Re-enter Password" required>
                        <input type="submit" value="ADD USER">
                    </form>
                    <script>
                        function validateForm() {
                            const password = document.getElementById("password").value;
                            const confirmPassword = document.getElementById("confirmPassword").value;
                            if (password !== confirmPassword) {
                                alert("Passwords do not match!");
                                return false;
                            }
                            return true;
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
</body>
</html>