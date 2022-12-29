package vehicles;

public class RentalDetails {
	 private String VehicleType;
	private TimeSpan estimatedRentalPeriod;
	private int estimatedNumMiles;
    private boolean dailyInsur;
    private boolean primeCustomer;
	public RentalDetails(String vehicleType, TimeSpan estimatedRentalPeriod, int estimatedNumMiles, boolean dailyInsur,
			boolean primeCustomer) {
	
		this.VehicleType = vehicleType;
		this.estimatedRentalPeriod = estimatedRentalPeriod;
		this.estimatedNumMiles = estimatedNumMiles;
		this.dailyInsur = dailyInsur;
		this.primeCustomer = primeCustomer;
	}
	public String  getVehicleType() {
		return VehicleType;
	}
	public TimeSpan getEstimatedRentalPeriod() {
		return estimatedRentalPeriod;
	}
	public int getEstimatedNumMiles() {
		return estimatedNumMiles;
	}
	public boolean isDailyInsur() {
		return dailyInsur;
	}
	public boolean isPrimeCustomer() {
		return primeCustomer;
	}
	

}
