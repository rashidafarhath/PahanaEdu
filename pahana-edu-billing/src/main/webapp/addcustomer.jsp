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
            <h1 class="h1index"> ADD CUSTOMER </h1>
            <div class="maininfo">
                <div class="top">
                    <form method="post" action="CustomerControllerr" > 
                        <input class="text" type="text" name="customername" placeholder="Name" required=""> 
                        <input class="text" type="text" name="customeraddress" placeholder="Address" required=""> 
                        <input class="text" type="text" name="customerphone" placeholder="Phone" required=""> 
                        <input class="text" type="text" name="customerunits" placeholder="Units Consumed" required=""> 
                        <input type="submit" value="ADD CUSTOMER">    
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>