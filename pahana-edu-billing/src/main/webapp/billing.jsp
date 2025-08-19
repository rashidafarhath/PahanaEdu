<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu Billing</title>
    <link rel="stylesheet" type="text/css" href="css/billing.css" media="all">
    <style>#suggestions {
            border: 1px solid #ccc;
            max-height: 200px;
            overflow-y: auto;
            display: none;
            position: absolute;
            background: white;
            width: 300px;
        }
        #suggestions div {
            padding: 10px;
            cursor: pointer;
        }
        #suggestions div:hover {
            background: #f0f0f0;
        }
                .btnd {
            padding: 6px 12px;
            border: none;
            display: inline-block;
            margin: 0 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            color: white;
        }
        .deletebtn {
            background-color: #dc3545;
        }
        .deletebtn:hover {
            background-color: #c82333;
        }</style>
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

    <div class="container">
        <h2>Billing Page</h2>
        <div>
            <input type="text" id="customerTel" placeholder="Phone" maxlength="9" required>
            <div id="customerStatus"></div>
        </div>
        <div style="position: relative;">
            <input type="text" id="searchProduct" placeholder="Search Product">
            <div id="suggestions"></div>
        </div>
        <div>
            <input type="hidden" id="itemId">
            <input type="text" id="itemName" placeholder="Item Name" readonly>
            <input type="number" id="itemPrice" placeholder="Price" readonly>
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
            
            <button class="btn" onclick="printBill()">Print Bill</button>
            <button class="btn" style="background: red;" onclick="clearBill()">Clear All</button>
        </div>
    </div>

    <script>
        let total = 0;
        const contextPath = '<%= request.getContextPath() %>';

        
        document.getElementById("customerTel").addEventListener("input", function() {
         
            let customerTel = this.value;
            let statusDiv = document.getElementById("customerStatus");
            if (customerTel.length !== 9 || !/^\d{9}$/.test(customerTel)) {
                statusDiv.textContent = "Please enter a valid 9-digit phone number";
                statusDiv.className = "error";
                return;
            }

            fetch(contextPath + `/searchCustomer?customerTel=${encodeURIComponent(customerTel)}`)
                .then(response => response.text())
                .then(message => {
                   
                    statusDiv.textContent = message;
                    statusDiv.className = message === "Customer not found" ? "error" : "";
                })
                .catch(error => console.error("Error checking customer:", error));
        });

        
        document.getElementById("searchProduct").addEventListener("keyup", function() {
           
            let query = this.value.trim();
            if (query.length < 2) {
                document.getElementById("suggestions").style.display = "none";
                return;
            }

            fetch(contextPath + `/searchProduct?query=${encodeURIComponent(query)}`)
                .then(response => response.json())
                .then(data => {
                    
                    let suggestions = document.getElementById("suggestions");
                    suggestions.innerHTML = "";
                    if (data.length === 0) {
                        suggestions.style.display = "none";
                        return;
                    }
                    data.forEach(product => {
                        let div = document.createElement("div");
                        div.textContent = product.productname + " (Price: " + product.productprice.toFixed(2) + ")";
                        div.onclick = function() {
                           
                            document.getElementById("itemId").value = product.productId || "";
                            document.getElementById("itemName").value = product.productname || "";
                            document.getElementById("itemPrice").value = product.productprice || "";
                            suggestions.style.display = "none";
                            document.getElementById("searchProduct").value = "";
                        };
                        suggestions.appendChild(div);
                    });
                    suggestions.style.display = "block";
                })
                .catch(error => {
                    console.error("Error fetching products:", error);
                    document.getElementById("suggestions").style.display = "none";
                });
        });

        function addItem() {
            let id = document.getElementById("itemId").value;
            let name = document.getElementById("itemName").value;
            let price = parseFloat(document.getElementById("itemPrice").value);
            let qty = parseInt(document.getElementById("itemQty").value);

           
            if (!id || !name || isNaN(price) || isNaN(qty) || price <= 0 || qty <= 0) {
                alert("Please click a product from the suggestions and enter a valid quantity!");
                return;
            }

            let subtotal = price * qty;
            total += subtotal;

            let tableBody = document.querySelector("#billTable tbody");
            let row = tableBody.insertRow();
            row.setAttribute("data-id", id);
            row.innerHTML = `
                <td>${name}</td>
                <td>${qty}</td>
                <td>${price.toFixed(2)}</td>
                <td>${subtotal.toFixed(2)}</td>
                <td><button class="btnd deletebtn" onclick="removeItem(this, ${subtotal})">Remove</button></td>
            `;

            document.getElementById("totalAmount").textContent = total.toFixed(2);

            document.getElementById("itemId").value = "";
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
            let customerTel = document.getElementById("customerTel").value;
            if (!customerTel || !/^\d{9}$/.test(customerTel)) {
                alert("Enter a valid 9-digit customer phone number!");
                return;
            }

            let rows = document.querySelectorAll("#billTable tbody tr");
            if (rows.length === 0) {
                alert("No items in bill!");
                return;
            }

            let productIds = [];
            let quantities = [];
            rows.forEach(row => {
                productIds.push(row.getAttribute("data-id"));
                quantities.push(row.cells[1].textContent);
            });

            fetch(contextPath + "/saveBill", {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: `customerTel=${encodeURIComponent(customerTel)}&productIds=${productIds.join("&productIds=")}&quantities=${quantities.join("&quantities=")}`
            }).then(response => response.text())
                .then(message => {
                    
                    if (response.ok) {
                        alert("Bill saved successfully!");
                    } else {
                        alert("Error: " + message);
                    }
                })
                .catch(error => console.error("Error saving bill:", error));
        }

        function printBill() {
            saveBill();
            window.print();
        }
    </script>
</body>
</html>