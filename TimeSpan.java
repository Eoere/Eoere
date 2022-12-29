package vehicles;

public class TimeSpan {
	private final char timeUnit;
	private final int numUnits;
	public TimeSpan(char timeUnit,int numUnits) {
		this.timeUnit=timeUnit;
		this.numUnits=numUnits;
		
	}
	public char getTimeUnit() {
		return timeUnit;
	}
	public int getNumUNit() {
		return numUnits;
	}
	
	
public String toString() {
	return " " +timeUnit+" "+ numUnits;
}

}
