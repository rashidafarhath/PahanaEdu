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
              
                <li><a href="#contact">HELP</a></li>
            </ul>
        </nav>
    </div>

    <div class="container">
        <div class="wrapperindex">
            <h1 class="h1index"> ADD PRODUCT </h1>
            <div class="maininfo">
                <div class="top">
                    <form method="post" action="ProductControllerr" onsubmit="return validateForm()"> 
                        <input class="text" type="text" name="productname" placeholder="Name" required=""> 
                        <input class="text" type="text" name="productprice" placeholder="Price" required=""> 
                        <input class="text" type="text" name="productquantity" placeholder="Quantity" required=""> 
                        <input class="text" type="text" name="productdes" placeholder="Description"> 
                        <input type="submit" value="ADD PRODUCT">   
                        
                                           
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>