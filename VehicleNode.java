package vehicles;

public class VehicleNode {
	
	private Vehicle vehicle ;
	private VehicleNode next ;
	public VehicleNode(VehicleNode next,Vehicle vehicle) {
		this.next=next;
		this.vehicle=vehicle;
	}
	public VehicleNode getNext() {
		return next;
	}
public Vehicle getValue() {
	return vehicle;
}
public void setNext(VehicleNode v) {
	
	next=v;
}
}
