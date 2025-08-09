<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" media="all">
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
                    <form action="login.php" method="POST">
                        <input class="text" type="text" name="Username" placeholder="Username" required=""> 
                        <input class="text" type="password" name="password" placeholder="Password" required=""> 
                    <div class="acctypeclass">
                        <label for="type">Account type</label>
                        <select name="Type" id="type" class="acctypeinclass" required="">
                            <option name="o1" value="cust">Manager</option>
                            <option name="o2" value="admin">Cashier</option>
                        </select>
                    </div>
                        <input type="submit" value="SIGN IN">    
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>