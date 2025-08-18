package pahana.model;

public class User {
			
	private int cashierId;
    private String cashierName;
    private String cashierUsername;
    private String cashierspassword;
			

			
			
			
			public User(int cashierId, String cashierName, String cashierUsername, String cashierspassword) {
				
				this.cashierId = cashierId;
				this.cashierName = cashierName;
				this.cashierUsername = cashierUsername;
				this.cashierspassword = cashierspassword;
				
			}

			public User(String cashierName, String cashierUsername, String cashierspassword) {
				this.cashierName = cashierName;
				this.cashierUsername = cashierUsername;
				this.cashierspassword = cashierspassword;
			}
			
			public User(int cashierId, String cashierName) {
				
				this.cashierId = cashierId;
				this.cashierName = cashierName;
			}
			
			public User() {
				
			}

			public int getCashierId() {
				return cashierId;
			}

			public void setCashierId(int cashierId) {
				this.cashierId = cashierId;
			}

			public String getCashierName() {
				return cashierName;
			}

			public void setCashierName(String cashierName) {
				this.cashierName = cashierName;
			}

			public String getCashierUsername() {
				return cashierUsername;
			}

			public void setCashierUsername(String cashierUsername) {
				this.cashierUsername = cashierUsername;
			}

			public String getCashierspassword() {
				return cashierspassword;
			}

			public void setCashierspassword(String cashierspassword) {
				this.cashierspassword = cashierspassword;
			}


			

			


			

			
		





}
