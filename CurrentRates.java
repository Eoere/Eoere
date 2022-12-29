package vehicles;

public class CurrentRates {
	private VehicleRates[ ]  rates = new VehicleRates[3];
	public CurrentRates() {
		rates[0]=new CarRates(22.95, 159.95, 514.95, 0.15, 14.95);
		rates[1]=new SUVRates(29.95, 189.95, 679.95, 0.15, 14.95);
		rates[2]=new TruckRates(35.95, 224.95, 787.95, 0.26, 21.95);
	}
	public VehicleRates getCarRates() {
		return rates[0];
	}
	public VehicleRates getSUVRates() {
		return rates[1];
	}
	public VehicleRates getTruckRates() {
		return rates[2];
		
	}
	public void setCarRates(VehicleRates v) {
		rates[0]=v;
	}
	public void setSUVRates(VehicleRates v) {
		rates[1]=v;
	}
	public void setTruckRates(VehicleRates v) {
		rates[2]=v;
	}
	public double calcEstimatedCost(int VehicleType, TimeSpan estimatedRentalPeriod, int estimatedNumMiles, 
            boolean dailyInsur, boolean primeCustomer)
{
double estimatedCost = 0;

estimatedCost = estimatedNumMiles * this.rates[VehicleType].getMileage_chrg();

if(dailyInsur)
{
estimatedCost += estimatedRentalPeriod.getNumUNit() * this.rates[VehicleType].getDaily_insur_rate();
}

if(estimatedRentalPeriod.getNumUNit() < 7)
{
estimatedCost += estimatedRentalPeriod.getNumUNit() * this.rates[VehicleType].getDaily_rate();
}
else if(estimatedRentalPeriod.getNumUNit() >=7 && estimatedRentalPeriod.getNumUNit() < 30)
{
estimatedCost +=  (((double) estimatedRentalPeriod.getNumUNit())/7 ) * this.rates[VehicleType].getWeekly_rate();
}
else
{
estimatedCost +=  (((double) estimatedRentalPeriod.getNumUNit())/30 ) * this.rates[VehicleType].getMonthly_rate();
}

//giving 10% discount to the prime customer
if(primeCustomer)
{
estimatedCost = estimatedCost * 0.9;
}
return estimatedCost;
}

public double calcActualCost(VehicleRates rates, int numDaysUsed, int numMilesDriven, 
boolean dailyInsur, boolean primeCustomer)
{
double actualCost = 0;

actualCost = numMilesDriven * rates.getMileage_chrg();

if(dailyInsur)
{
actualCost += numDaysUsed * rates.getDaily_insur_rate();
}

if(numDaysUsed < 7)
{
actualCost += numDaysUsed * rates.getDaily_rate();
}
else if(numDaysUsed >=7 && numDaysUsed < 30)
{
actualCost +=  (((double) numDaysUsed)/7 ) * rates.getWeekly_rate();
}
else
{
actualCost +=  (((double) numDaysUsed)/30 ) * rates.getMonthly_rate();
}

//giving 10% discount to the prime customer
if(primeCustomer)
{
actualCost = actualCost * 0.9;
}

return actualCost;
}


	
	}


