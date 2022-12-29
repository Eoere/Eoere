package vehicles;

public abstract class VehicleRates {
	private double daily_rate;
	
	
	private double weekly_rate; 
	private double monthly_rate;
	private double mileage_chrg;
   private  double daily_insur_rate;
	public VehicleRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
			double daily_insur_rate) {
		
		this.daily_rate = daily_rate;
		this.weekly_rate = weekly_rate;
		this.monthly_rate = monthly_rate;
		this.mileage_chrg = mileage_chrg;
		this.daily_insur_rate = daily_insur_rate;
	}
	public double getDaily_rate() {
		return daily_rate;
	}
	public double getWeekly_rate() {
		return weekly_rate;
	}
	public double getMonthly_rate() {
		return monthly_rate;
	}
	public double getMileage_chrg() {
		return mileage_chrg;
	}
	public double getDaily_insur_rate() {
		return daily_insur_rate;
	}
}	
		

