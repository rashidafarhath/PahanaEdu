package pahana.model;

public class Customer {
	private int cusId;
	private String cusname;
	private String cusadd;
	private int custel;
	private int cusunit;
	
	public Customer(int custId, String custname, String custadd, int custtel, int custunits) {
		
		this.cusId = custId;
		this.cusname = custname;
		this.cusadd = custadd;
		this.custel = custtel;
		this.cusunit = custunits;
		
	}
	public Customer() {
		
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCusadd() {
		return cusadd;
	}
	public void setCusadd(String cusadd) {
		this.cusadd = cusadd;
	}
	public int getCustel() {
		return custel;
	}
	public void setCustel(int custel) {
		this.custel = custel;
	}
	public int getCusunit() {
		return cusunit;
	}
	public void setCusunit(int cusunit) {
		this.cusunit = cusunit;
	}
	
	
}
