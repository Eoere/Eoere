package vehicles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUI implements UserInterface {
	// no constructor needed, calls static methods of the SystemInterface
	// starts a “command loop” that repeatedly: (a) displays a menu of options, (b) gets the selected
	 // option from the user, and (c) executes the corresponding command.
	private boolean quit = false;
	public void start(Scanner input) {
	int selection;
	// command loop
	while(!quit) {
	displayMenu();
	selection = getSelection(input);
	execute(selection, input);
	}
	 }
	 private void execute(int selection, Scanner input) {
	 int veh_type;
	String vin, creditcard_num; String[] display_lines = null;
	RentalDetails rental_details; ReservationDetails reserv_details;
	switch(selection) {
	// display rental rates
	case 1: veh_type = getVehicleType(input);
	switch(veh_type){
	 case 1: display_lines = SystemInterface.getCarRates(); break;
	 case 2: display_lines = SystemInterface.getSUVRates(); break;
	 case 3: display_lines = SystemInterface.getTruckRates(); break;
	}
	displayResults(display_lines);
	break;
	// display available vehicles
	case 2: veh_type = getVehicleType(input);
	switch(veh_type){
	 case 1: display_lines = SystemInterface.getAvailCars(); break;
	 case 2: display_lines = SystemInterface.getAvailSUVs(); break;
	 case 3: display_lines = SystemInterface.getAvailTrucks(); break;
	}
	displayResults(display_lines);
	break;
	// display estimated rental cost
	case 3: rental_details = getRentalDetails(input);
	display_lines = SystemInterface.estimatedRentalCost(rental_details);
	displayResults(display_lines);
	break;
	
	// make a reservation
	case 4: reserv_details = getReservationDetails(input);
	display_lines = SystemInterface.makeReservation(reserv_details);
	displayResults(display_lines);
	break;
	// cancel a reservation
	case 5: vin = getVIN( input);
	display_lines = SystemInterface.cancelReservation( vin);
	displayResults(display_lines);
	break;
	// view corporate account (and company reservations)
	case 6: creditcard_num = getCreditCardNum(input);
	display_lines = SystemInterface.getAccount(creditcard_num);
	displayResults(display_lines);
	break;
	// process returned vehicle
	case 7: creditcard_num = getCreditCardNum(input);
	vin = getVIN(input);
		int num_day_used=getNumdaysUsed(input);
		int num_miles_driven=getNummiles(input);
		display_lines = SystemInterface.processReturnedVehicle(vin,
	 num_day_used,num_miles_driven);
	displayResults(display_lines);
	break;
	// quit program
	case 8: quit = true;
	}}
	private int getNummiles(Scanner input) {
	System.out.println("Enter number of miles drives");
	int numiles=input.nextInt();
		return numiles;
	}
	private int getNumdaysUsed(Scanner input) {
		System.out.println("Enter Number of days Used");
		int numdays=input.nextInt();
		return numdays;
		
		// TODO Auto-generated method stub
	
	}
	private String getCreditCardNum(Scanner input) {
		System.out.println("Enter your creditcard number");
		String credc=input.next();
		return credc;

	}
	// ------- private methods
	private void displayMenu() {
		  System.out.println(); // skip line
	        System.out.println("1 - Display Rental Rates");
	        System.out.println("2 - Display Available Vehicles");
	        System.out.println("3 - Display Estimated Rental Cost");
	        System.out.println("4 - Make a reservation");
	        System.out.println("5 - Cancel a reservation");
	        System.out.println("6 - view corporate account (and company reservations)");
	        System.out.println("7 - process returned vehicle");
	        System.out.println("8 -quit program");
	        }
	
	
	private int getSelection(Scanner input) {    int selection = 0;  // init
    
    boolean valid_input = false;
   
    while(!valid_input){
        try{

            System.out.print("Enter: ");
            selection = input.nextInt();

            if(selection >= 1 && selection <= 8)
                valid_input = true;
            else
                System.out.println("* INVALID SELECTION - PLEASE REENTER *");
        }    
        // catch if non-digit entered (thrown by method nextInt)
        catch(InputMismatchException e){
            System.out.println("* INVALID CHAR ENTERED - PLEASE REENTER *");
            System.out.println(); // skip line
            input.next(); // scan past unread non-digit char
        }
    }
    return selection;       
 }
	
	private String getVIN(Scanner input){
	 {System.out.println("Enter Vin");
	 String vin=input.next();
	 return vin;
	 }
      
        }
	private int getVehicleType(Scanner input)
	 {int vtype=0;
		boolean valid_input=false;
		while(!valid_input) {try {
			System.out.println("Enter Vehicle Input");
			vtype=input.nextInt();
			if(vtype>=1&&vtype<=3) {
				valid_input=true;
			}
		}catch(Exception e) {
			System.out.println("Enter Integer value betwwen 1 and 3");}
		}
		return vtype;
		}
	 
	private RentalDetails getRentalDetails(Scanner input)
	 { System.out.println("Enter Vehicle Type");
	 String vtype=input.next();
	 System.out.println("Enter The TimeUnit in character format");
		 char timeunit=input.next().charAt(0);
		 System.out.println("How long would you keep the car");
		 int numunit=input.nextInt();
		 TimeSpan t=new TimeSpan(timeunit,numunit);
		 System.out.println("Enter estimated Number of miles");
		 int nummiles=input.nextInt();
		 System.out.println("Are you insured Y/N");
		 char insurr=input.next().charAt(0);
		 boolean isdaily=false;
		 if(insurr=='Y') {
			isdaily=true; 
		 }
		 else {isdaily=false;}
		 System.out.println("Are you a prime CustomerY/N");
		 char isprime=input.next().charAt(0);
		 boolean isprime1=false;
		 if(isprime=='Y') {
			 isprime1=true;}
			 else {
				 isprime1=false;
			 }
		 RentalDetails details=new RentalDetails(vtype,t,nummiles,isdaily,isprime1);
		 return details;
		 }
		 
	 
		
	 
//		 private String VehicleType;
//			private TimeSpan estimatedRentalPeriod;
//			private int estimatedNumMiles;
//		    private boolean dailyInsur;
//		    private boolean primeCustomer;}
	 
	private ReservationDetails getReservationDetails(Scanner input) {
		System.out.println("Enter Vehicle Identification Number");
		String vin=input.next();
		System.out.println("Enter Credit Card Number");
		String credc=input.next();
		 System.out.println("Enter The TimeUnit in character format");
			 char timeunit=input.next().charAt(0);
			 System.out.println("How long would you keep the car");
			 int numunit=input.nextInt();
			 TimeSpan t=new TimeSpan(timeunit,numunit);
			 System.out.println("Are you insured Y/N");
			 char insurr=input.next().charAt(0);
			 boolean isdaily=false;
			 if(insurr=='Y') {
				isdaily=true; 
			 }
			 else {isdaily=false;}
			 ReservationDetails Details=new ReservationDetails(vin,credc,t,isdaily);
			 return Details;
			 }
		
	// prompts user to enter required information for making a reservation (VIN of vehicle to reserve,
	// credit card num, rental period, and insurance option), returning the result packaged as a
	// ReservationDetails object (to be passed in method calls to the SystemInterface) { }   
	
	private void displayResults(String[] lines) {
	// displays the array of strings passed, one string per screen line { }
	}}

