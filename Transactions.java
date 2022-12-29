package vehicles;

import java.util.ArrayList;

public class Transactions {
	private ArrayList<Transaction>Transactions;
	private int current;
	public Transactions() {
		Transactions=new ArrayList<Transaction>(0);
		
	}
	public void add(Transaction e) {
	Transactions.add(e);
	}
	public boolean hasNext() {
	if(current>=Transactions.size()) {
		return false;}
		else
			return true;
		
	}
	public Transaction getNextTransaction() {
		return Transactions.get(current++);
	}
	public void reset() {
		current=0;
	}

}
