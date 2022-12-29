package vehicles;

public class TruckRates extends VehicleRates {

	public TruckRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
			double daily_insur_rate) {
		super(daily_rate,  weekly_rate,  monthly_rate, mileage_chrg,
			daily_insur_rate);
		
	}
	public String toString( ) {
		return "daily rate;" +super.getDaily_rate() + "Weekly rate "+super.getWeekly_rate()+"Monthly rate: "+super.getMonthly_rate()+" mileage charge: "+super.getMileage_chrg()+ " daily insurance "+super.getDaily_insur_rate();
		
	}

}
