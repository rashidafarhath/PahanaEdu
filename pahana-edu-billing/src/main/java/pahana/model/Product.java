package pahana.model;

public class Product {
		
		private int productId;
		private String productname;
		private double productprice;
		private int productquantity;
		private String productdes;
		
		
		
		public Product(int productId, String name, double price, int quantity, String description) {
			
			this.productId = productId;
			this.productname = name;
			this.productprice = price;
			this.productquantity = quantity;
			this.productdes = description;
			
		}


		public Product(int productId, String name, double price, int quantity) {
			
			this.productId = productId;
			this.productname = name;
			this.productprice = price;
			this.productquantity = quantity;
		}


		public Product(int productId, double price) {
			
			this.productId = productId;
			this.productprice = price;
		}
		public Product(int productId, int quantity) {
			
			this.productId = productId;
			this.productquantity = quantity;
		}
		

		public Product() {
			
		}


		public int getProductId() {
			return productId;
		}


		public void setProductId(int productId) {
			this.productId = productId;
		}


		public String getName() {
			return productname;
		}


		public void setName(String name) {
			this.productname = name;
		}

		public double getPrice() {
			return productprice;
		}


		public void setPrice(double price) 
		{
			this.productprice = price;
		}
		public int getQuantity() {
			return productquantity;
		}


		public void setQuantity(int quantity) 
		{
			this.productquantity = quantity;
		}
		
		public String getDescription() {
			return productdes;
		}


		public void setDescription(String description) {
			this.productdes = description;
		}
	}




