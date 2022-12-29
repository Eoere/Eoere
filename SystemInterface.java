// Justin Omekwe
package vehicles;

public class SystemInterface {
	
		private static CurrentRates agency_rates;
		private static Vehicles agency_vehicles;
		private static Accounts accounts;
		private static Transactions transactions_history;
		// used to init static variables (in place of a constructor)
		public static void initSystem(CurrentRates r, Vehicles v, Accounts a, Transactions t) {
		agency_rates = r;
		agency_vehicles = v;
		accounts = a;
		transactions_history = t;
		}
//		// Note that methods makeReservation, cancelReservation, addAccount, and updateXXXRates return
//		// an acknowledgement of successful completion of the requested action (e.g. “Vehicle QK3FL4273ME
//		// successfully reserved”). Method processReturnedVehicle returns the final cost for the returned
//		// vehicle (e.g., “Total charge for VIN QK3FL4273ME for 3 days, 233 miles @ 0.15/mile and daily
//		// insurance @ 14.95/day (with 100 miles credit as Prime customer) = $xxx.xx.)
//		// Current Rates Related Methods
	public static String[ ] getCarRates() {
		String[] answer=new String[1];
		answer[0]=agency_rates.getCarRates().toString();
		return answer;
		}
	
public static String[ ] getSUVRates() { String[] answer=new String[1];
answer[0]=agency_rates.getSUVRates().toString();
return answer;}

public static String[ ] getTruckRates() { String[] answer=new String[1];
answer[0]=agency_rates.getTruckRates().toString();
return answer;}

		public static String[ ] updateCarRates(VehicleRates r) { String[] answer=new String[1];
		agency_rates.setCarRates(r);
		answer[0]="Car rates have been set to "+r.toString();
		return answer;}
		
		public static String[ ] updateSUVRates(VehicleRates r) {String[] answer=new String[1];
		agency_rates.setSUVRates(r);
		answer[0]="SUV rates have been set to"+r.toString();
		return answer;}
		
	public static String[ ] updateTruckRates(VehicleRates r) {
		String[] answer=new String[1];
	agency_rates.setTruckRates(r);
	answer[0]="Truck rates have been set to "+r.toString();
	return answer;
	}
	public static String[ ] estimatedRentalCost(RentalDetails details) {
		String[] rentalcost=new String[1];
		int type=-1;
		if(details!=null) {
			
			if(details.getVehicleType().equalsIgnoreCase("Car")) {
			type=0;}
			else if(details.getVehicleType().equalsIgnoreCase("Truck")){
				type=1;
				}
				else if(details.getVehicleType().equalsIgnoreCase("SUV")) {
					type=2;
				}
				rentalcost[0]=" "+ agency_rates.calcEstimatedCost(type, details.getEstimatedRentalPeriod(), details.getEstimatedNumMiles(), details.isDailyInsur(), details.isPrimeCustomer());
				return rentalcost;
		}
		else 
			rentalcost[0]="Not a vehcile type";
			return rentalcost;}
			
		
			
		
	


	public static String[ ] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) {
		String[] costv=new String[1];
		Vehicle v=agency_vehicles.getVehicle(vin);
		Reservation r=v.getReservation();
		
	Account ac	= accounts.getAccount(r.getCreditCard());
	boolean isprime=ac.primeCustomer();
	boolean insurance=r.insur_selected();
	VehicleRates vr=null;
	if(v instanceof Car) {
		vr=agency_rates.getCarRates();}
		else if(v instanceof Truck) {
			vr=agency_rates.getTruckRates();}
		else if(v instanceof SUV ) {
			
		vr=agency_rates.getSUVRates();	
		}
	
	costv[0]=" The final cost is" +agency_rates.calcActualCost(vr, num_days_used, num_miles_driven, insurance, isprime);
	return costv;
	
		
	}
		
		public static String[ ] getAvailCars() {
			int  i=0;
			 while(agency_vehicles.hasNext()){
				
		           Vehicle veh = agency_vehicles.getNext();
		            if(!veh.isReserved()&& veh instanceof Car ) {
		            	
		            	 i++;
		               // System.out.println((veh.toString()));
		            }
		      
		            }
			 String[] vehi=new String[i];
			 int j=0;
			 while(agency_vehicles.hasNext()){
					
		           Vehicle veh = agency_vehicles.getNext();
		            if(!veh.isReserved()&& veh instanceof Car ) {
		            	vehi[j]=veh.toString();
		            	 j++;
		               // System.out.println((veh.toString()));
		            }
		            
			 
			 }
			 return vehi;
		}
		public static String[ ] getAvailSUVs() { 
		
			int  i=0;
			 while(agency_vehicles.hasNext()){
				
		           Vehicle veh = agency_vehicles.getNext();
		            if(!veh.isReserved()&& veh instanceof SUV ) {
		            	
		            	 i++;
		               // System.out.println((veh.toString()));
		            }
		            
		            }
			 String[] vehi=new String[i];
			 int j=0;
			 while(agency_vehicles.hasNext()){
					
		           Vehicle veh = agency_vehicles.getNext();
		            if(!veh.isReserved()&& veh instanceof SUV ) {
		            	vehi[j]=veh.toString();
		            	 j++;
		               
		            	 // System.out.println((veh.toString()));
		            	
		            }
			 }
			 return vehi;
		           		 
		}
		public static String[ ] getAvailTrucks() { 
			String[] vehi=new String[25];
		int  i=0;
		 while(agency_vehicles.hasNext()){
			
	           Vehicle veh = agency_vehicles.getNext();
	            if(!veh.isReserved()&& veh instanceof Truck ) {
	            	vehi[i]=veh.toString();
	            	 i++;
	               // System.out.println((veh.toString()));
	            }
	            
	            }
		 return vehi;
		}
		public static String[ ] getAllVehicles() { 
			String[] allVehicles=new String [25];
			agency_vehicles.reset();
			int i=0;
					
	        while(agency_vehicles.hasNext()) {
	            allVehicles[i]=agency_vehicles.getNext().toString();
	        i++;}
	        return allVehicles;
		}
		
		public static String[ ] makeReservation(ReservationDetails details) { 
			String[] answer= new String[1];
			Vehicle v= agency_vehicles.getVehicle(details.getVIN());
			if(!v.isReserved()) {
				Reservation r=new Reservation(details.getCreditcard_num(),details.getRental_period().toString(),details.InsuranceSelected);
				v.reserve(r);}
			answer[0]="Vehicle "+v.toString()+"has been reserved";
				return answer;
				
			}
			
		
			
		
		public static String[ ] cancelReservation(String vin) { 
			String[] answer=new String[1];
			while(agency_vehicles.hasNext()) {
				Vehicle v=agency_vehicles.getNext();
				if(v.getVIN().equals(vin)) {
					v.cancelReservation();}
				answer[0]="Vehicle "+vin+" is succcesfully reserved";
					return answer;
		
		}
			return answer;
		}
		public static String[ ] getReservation(String vin) { 
			String[] answer=new String[1];
			while(agency_vehicles.hasNext()) {
				Vehicle v=agency_vehicles.getNext();
				if(v.getVIN()==vin) {
					answer[0]=v.toString();
				}
				
			}
			return answer;
		}
		public static String[ ] getAllReservations() { 
			int numv=0;
			while(agency_vehicles.hasNext()) {
				Vehicle veh=agency_vehicles.getNext();
				if(veh.isReserved()) {
					numv++;
				}
			}
			String[] answer=new String[numv];
			int i=0;
				while(agency_vehicles.hasNext()) {
					Vehicle veh=agency_vehicles.getNext();
					if(veh.isReserved()) {
						
						answer[i]=veh.toString();
						i++;
					}
					
				}
				return answer;
				
		}
			
		// Customer Accounts Related Methods
		public static String[ ] addAccount(String creditcard, String company_name, boolean prime_cust) { 
			Account a=new Account ( creditcard,  company_name,  prime_cust);
			accounts.add(a);
			String[] answer=new String[1];
			answer[0]="New Account has been added";
			return answer;
		}
		public static String[ ] getAccount(String creditcard_num) {
			String[] answer=new String[1];
			accounts.reset();
			while(accounts.hasNext()) {
				Account ac=accounts.getNextAccount();
				if(ac.getCreditCardNum().equals(creditcard_num)){
				answer[0]=ac.toString();
			}
		
		}
			return answer;
			}
		public static String[ ] getAllAccounts(){accounts.reset();
		int i=0;
		while(accounts.hasNext()) {
			i++;
		}
		String[] answer=new String[i];
		int j=0;
		while(accounts.hasNext()) {
			answer[j]=accounts.getNextAccount().toString();
		}
		return answer;
		}
	 
		// transactions-related methods
		public static String[ ] getAllTransactions() {
			transactions_history.reset();
		int i=0;
		while(transactions_history.hasNext()) {
		i++;
		}
		String[]answer=new String[i];
		transactions_history.reset();
		while(transactions_history.hasNext())
		{
			answer[0]=transactions_history.getNextTransaction().toString();
		}
			return answer; } }


