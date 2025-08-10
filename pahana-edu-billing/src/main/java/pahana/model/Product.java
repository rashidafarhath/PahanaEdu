package pahana.model;

public class Product {
		
		private int productId;
		private String name;
		private double price;
		private int quantity;
		private String description;
		
		
		
		public Product(int productId, String name, double price, int quantity, String description) {
			
			this.productId = productId;
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			this.description = description;
			
		}


		public Product(int productId, String name, double price, int quantity) {
			
			this.productId = productId;
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}


		public Product(int productId, double price) {
			
			this.productId = productId;
			this.price = price;
		}
		public Product(int productId, int quantity) {
			
			this.productId = productId;
			this.quantity = quantity;
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
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}


		public void setPrice(double price) 
		{
			this.price = price;
		}
		public double getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) 
		{
			this.quantity = quantity;
		}
		
		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
	}




