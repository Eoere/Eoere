package vehicles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerUI implements UserInterface {
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
	 private int getSelection(Scanner input) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void execute(int selection, Scanner input) {
	 int veh_type; VehicleRates vrate;Account acct;
	String vin, creditcard_num; String[] display_lines;
	RentalDetails rental_details; ReservationDetails reserv_details;
	switch(selection) {
	case 1:
		veh_type=getVehicleType(input);
		vrate=getRates(input);
	switch(veh_type) {
	case 1: display_lines=SystemInterface.updateCarRates(vrate
			);
	break;
	case 2:display_lines=SystemInterface.updateSUVRates(vrate);
	break;
	case 3:display_lines=SystemInterface.updateTruckRates(vrate);
	break;
	
	}
	break;
	case 2:display_lines=SystemInterface.getAllVehicles();
	break;
	case 3:
		System.out.println("Enter creditcard number ");
		String credc=input.next();
		String companyname=input.next();
		System.out.println("Do you have insurance");
		char insur=input.next().charAt(0);
		 boolean isinsur=false;
		 if(insur=='Y') {
			isinsur=true; 
		 }
		 else {isinsur=false;}
		
		 
	display_lines=SystemInterface.addAccount(credc, companyname, isinsur);
	break;
	case 4:display_lines=SystemInterface.getAllReservations();
	case 5:display_lines=SystemInterface.getAllAccounts();
	break;
	case 6:
		display_lines=SystemInterface.getAllTransactions();
		break;
		
	case 7:quit=true;
	break;}

}


private int getSelection1(Scanner input) {    int selection = 0;  // init
    
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
    return selection;    }  
 
	 private void displayMenu() {
		  System.out.println(); // skip line
	        System.out.println("1 - Update Rates");
	        System.out.println("2 - Get all Vehicles ");
	        System.out.println("3 - Add Account");
	        System.out.println("4 - View Reservations");	        
	        System.out.println("5 - View All Accounts");
	        System.out.println("6 - View Transactions");
	        System.out.println("7 -quit program");
	        }
	
	private VehicleRates getRates(Scanner input) {
		System.out.println("Enter Daily rate");
		int dailyr=input.nextInt();
		System.out.println("Enter weekly Rate");
		int wrate=input.nextInt();
		System.out.println("Enter monthly Rate");
		int mrate=input.nextInt();
		System.out.println("Enter mileage charge");
		int mcharge=input.nextInt();
		System.out.println("Enter insurance rates ");
		int irate=input.nextInt();
		VehicleRates r;
		r= new CarRates(dailyr,wrate,mrate,mcharge,irate);
		return r;
		
		
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
}