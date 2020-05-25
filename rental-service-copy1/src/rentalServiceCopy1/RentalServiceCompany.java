package rentalServiceCopy1;

import java.util.*;

public class RentalServiceCompany {

	static Scanner scanner = new Scanner(System.in);
	static GettingInput getInput = GettingInput.getInstance();


	public static void displayMenu() {  //display menu to the user
		System.out.println("----------Menu----------");
		System.out.println("Welcome manager , choose what you want to do !\n1.Add new location \n2.Add new apartment\n3.Allocate Price\n4.Book apartment\n5.Quit\nEnter your choice:");
	
	}
	public static void addLocation(ManagerSingleton manager)  {  //add new location in the list
		
		try {
		System.out.print("Enter location : ");
		String Null = scanner.nextLine();   // location is case sensitive
		String location = scanner.nextLine();
		manager.addBranch(location);    // check if the location is already in the list
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getNewApartmentDetails(ManagerSingleton manager) {   // get new apartment details
		String Null = scanner.nextLine();
		String apartmentName = getInput.getApartmentName(scanner);  // apartment name is case sensitive
		String apartmentType = getInput.getApartmentType(scanner);
		String apartmentLocation = getInput.getApartmentLocation(scanner);
		manager.addApartment(apartmentName, apartmentType, apartmentLocation);  // add new apartment details

	}
	
	public static void bookApartment(ManagerSingleton manager) throws Exception {  // book apartment
		String Null = scanner.nextLine();
		String apartmentType = getInput.getApartmentType(scanner);
		System.out.print("Enter start date (dd-mm-yyyy) : ");
		Date startDate = getInput.getDate(scanner);  
		System.out.print("Enter end date (dd-mm-yyyy) : ");
		Date endDate = getInput.getDate(scanner);
		/*
		 * get input from the company to determine which strategy the company wants to use ,to book apartment.
		 */
		if(Validation.isDurationValid(startDate,endDate)) {
			System.out.println("Choose the strategy you want to use to book apartment : \n1.Lowest Price First"); 
			int option = scanner.nextInt();
			switch(option) {
				case 1: 
					Strategies.lowestPriceFirst(apartmentType,startDate, endDate);
					break;
				default :
					System.out.println("Wrong Choice");
			}
		}	
		else
			System.out.println("Invalid Duration");
	}
	
	public static void allocatePrice(ManagerSingleton manager) {  // allocate price based on location and apartment type
		String Null = scanner.nextLine();
		String location = getInput.getApartmentLocation(scanner);
		String apartmentType = getInput.getApartmentType(scanner);
		double price = getInput.getPrice(scanner);
		HashMap<String,Double> typeAndPrice = new HashMap<>();
		
		/*
		 * add the location and the price for each apartment type in the location.
		 */
		if(Enumerations.pricePerLocation.size()==0) {
			typeAndPrice.put(apartmentType,price);
		}
		else {
			
			typeAndPrice = Enumerations.pricePerLocation.get(location);
			if(typeAndPrice == null)
				typeAndPrice = new HashMap<>();
			typeAndPrice.put(apartmentType,price);
		}
		Enumerations.pricePerLocation.put(location,typeAndPrice);
	}
	
	public static void main(String []args) {
		ManagerSingleton manager = Manager.createManager();
		displayMenu();
		try {
			int option = scanner.nextInt();
			do {
				switch(option) {
					case 1 : 
						addLocation(manager);
						break;
						
					case 2 :
						getNewApartmentDetails(manager);
						break;
				
					case 3:
						allocatePrice(manager);
						break;
						
					case 4:
						try {
							bookApartment(manager);
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					default:
						System.out.println("wrong choice");
					}
					displayMenu();
					option = scanner.nextInt();
			}while(option!=5);	
		}
		catch(Exception e) {
			System.out.println("Wrong Input Format.Program Stopped");
		}
	}
}
