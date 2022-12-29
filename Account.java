package vehicles;

public class Account {
	private String creditcard_num;
	private String company_name;
	private boolean prime_customer;
	public Account(String creditcard_num,String company_name,boolean prime_customer) {
		this.creditcard_num=creditcard_num;
		this.company_name=company_name;
		this.prime_customer=prime_customer;
	}
	public String getCreditCardNum() {  return creditcard_num;}
	public boolean primeCustomer() { return prime_customer; }
	public String toString() { 
		return creditcard_num+" "+company_name+" "+prime_customer;
	}


}
