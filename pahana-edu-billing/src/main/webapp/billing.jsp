<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/billing.css" media="all">
</head>
<body>
    <div class="navigationbar">
        <img src="Images/logo.png" class="logo">
        <!--<nav>
            <ul>
                <li><a href="index.html">HOME</a></li>
                <li><a href="#contact">HELP</a></li>
            </ul>
        </nav>-->
    </div>

<div class="container">
    <h2>Billing Page</h2>
    <div>
        <input type="text" id="itemName" placeholder="Item Name">
        <input type="number" id="itemPrice" placeholder="Price">
        <input type="number" id="itemQty" placeholder="Qty" value="1" min="1">
        <button class="btn" onclick="addItem()">Add Item</button>
    </div>

    <table id="billTable">
        <thead>
        <tr>
            <th>Item Name</th>
            <th>Qty</th>
            <th>Price</th>
            <th>Subtotal</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

    <div class="total-section">
        <p><b>Total:</b> Rs. <span id="totalAmount">0.00</span></p>
    </div>

    <div style="text-align: center; margin-top: 20px;">
        <button class="btn" onclick="saveBill()">Save Bill</button>
        <button class="btn" onclick="window.print()">Print Bill</button>
        <button class="btn" style="background: red;" onclick="clearBill()">Clear All</button>
    </div>
</div>

<script>
    let total = 0;

    function addItem() {
        let name = document.getElementById("itemName").value;
        let price = parseFloat(document.getElementById("itemPrice").value);
        let qty = parseInt(document.getElementById("itemQty").value);

        if (!name || isNaN(price) || isNaN(qty) || price <= 0 || qty <= 0) {
            alert("Enter valid item details!");
            return;
        }

        let subtotal = price * qty;
        total += subtotal;

        let tableBody = document.querySelector("#billTable tbody");
        let row = tableBody.insertRow();
        row.innerHTML = `
            <td>${name}</td>
            <td>${qty}</td>
            <td>${price.toFixed(2)}</td>
            <td>${subtotal.toFixed(2)}</td>
            <td><button onclick="removeItem(this, ${subtotal})">X</button></td>
        `;

        document.getElementById("totalAmount").textContent = total.toFixed(2);

        document.getElementById("itemName").value = "";
        document.getElementById("itemPrice").value = "";
        document.getElementById("itemQty").value = 1;
    }

    function removeItem(button, subtotal) {
        total -= subtotal;
        document.getElementById("totalAmount").textContent = total.toFixed(2);
        button.closest("tr").remove();
    }

    function clearBill() {
        document.querySelector("#billTable tbody").innerHTML = "";
        total = 0;
        document.getElementById("totalAmount").textContent = "0.00";
    }

    function saveBill() {
        alert("Bill saved! (Here you can send data to backend)");
        // TODO: Send data to servlet via AJAX/fetch
    }
</script>
</body>
</html>