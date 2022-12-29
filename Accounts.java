package vehicles;

import java.util.ArrayList;

import vehicles.Exceptions.CreditCardNotFoundException;

public class Accounts {
	private ArrayList<Account>Accounts;
	private int current;
	private int top;
	public Accounts() {
		Accounts=new ArrayList<Account>(0);
		current=0;
		top=Accounts.size();
	}
	public void add(Account acct) { 
		Accounts.add( acct);
		top++;
	}
	public Account getAccount(String creditcard_num) throws AccountNotFoundException {
		boolean found=false;
	
		for(int i=0;1<Accounts.size();i++) {
			Account temp=Accounts.get(i);
			if(temp.getCreditCardNum().equals(creditcard_num)) {
				found=true;
				return temp;
			}
		}
		if(!found) {throw new AccountNotFoundException();}
		return null;
	}
	//public int findfirstnull() {
	//	int j;
		//for(int i=0;i<Accounts.size();i++) {
			
		
			//if(Accounts.get(i)==null) {
				//j=i;
				
			//}
		//}
	//}
	public boolean hasNext() {
		if(current>=Accounts.size()) {
			return false;}
			else
				return true;
				
		}
	public Account getNextAccount() {
		return Accounts.get(current++);
	}
	
	

	public void reset() {
		current=0;
	}
	

}
