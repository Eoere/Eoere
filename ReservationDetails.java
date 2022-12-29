package vehicles;

public class ReservationDetails {
	private String VIN;
	private String creditcard_num;
	private TimeSpan rental_period;
	boolean InsuranceSelected;
	public ReservationDetails(String vIN, String creditcard_num, TimeSpan rental_period, boolean insuranceSelected) {
		
		this.VIN = vIN;
		this.creditcard_num = creditcard_num;
		this.rental_period = rental_period;
		InsuranceSelected = insuranceSelected;
	}
	public String getVIN() {
		return VIN;
	}
	public String getCreditcard_num() {
		return creditcard_num;
	}
	public TimeSpan getRental_period() {
		return rental_period;
	}
	public boolean isInsuranceSelected() {
		return InsuranceSelected;
	}


}
