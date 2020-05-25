package rentalServiceCopy1;

import java.util.*;
import java.text.*;

public class GettingInput {
static GettingInput getInput = new GettingInput();
	
	public static GettingInput getInstance() {
		return getInput;
	}
	
	public String getApartmentType(Scanner scanner) {
		System.out.print("Enter apartmentType(1BHK/2BHK/STUDIO) : "); 
		String apartmentType = scanner.nextLine();	 // input can also be 1bhk/2BhK/sTuDio
		while(!Validation.isApartmentTypeValid(apartmentType)) {
			System.out.print("Oops! No such apartment type\nEnter apartmentType(1BHK/2BHK/STUDIO) : ");
			apartmentType = scanner.nextLine();
		}
		return apartmentType.toUpperCase();
	}
	
	public String getApartmentName(Scanner scanner) {
		System.out.print("Enter apartment name : ");
		String apartmentName = scanner.nextLine();
		return apartmentName;
	}
	
	public String getApartmentLocation(Scanner scanner) {
		/*
		 * getting the apartment location ,and checking if its present in the list of locations.
		 */
		System.out.print("Enter apartment location : ");
		String location = scanner.nextLine();
		while(!Validation.isLocationAvailable(location)) {
			System.out.print("No such location exists \n Enter apartment location : ");
			location = scanner.nextLine();
		}	
		return location;
	}

	public Date getDate(Scanner scanner) throws Exception{
		/*
		 * getting date as input from the user in dd--mm-yyyy format and validating it.
		 */
		Date date = new Date();
		String DateString[];
		do {
		DateString = scanner.nextLine().split("-");
		}while(!Validation.isDateValid(DateString));
		String dateString = DateString[0]+"-"+DateString[1]+"-"+DateString[2];
		date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);	
		return date;
	}
	
	public double getPrice(Scanner scanner) {
		/*
		 * getting the price for each apartment type and validating the value entered.
		 */
		System.out.print("Enter price : ");
		double price = scanner.nextDouble();
		while(price<=0) {
			System.out.print("Enter valid price : ");
			price = scanner.nextDouble();
		}
		return price;
	}

}
