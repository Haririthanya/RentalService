package rentalServiceCopy1;

import java.util.Date;


public class Validation {
	
	public static boolean isLocationAvailable(String location) {
		if(Enumerations.location.contains(location)) 
			return true;
		return false;
	}

	public static boolean isApartmentTypeValid (String apartmentType) { 
		if(apartmentType.equalsIgnoreCase("1BHK")|| apartmentType.equalsIgnoreCase("2BHK")||apartmentType.equalsIgnoreCase("STUDIO"))
			return true;
		return false;
	}
	
	public static boolean isDateValid(String date[]) {
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		if((month>0&&month<13)&&(day>0&&day<=31)&&(year>0))
			return true;
		else {
			System.out.println("Invalid date.\nEnter valid date");
			return false;
		}	
	}
	
	public static boolean isDurationValid(Date startDate, Date endDate) {
		/*
		 * start date must be before end date
		 */
		if(startDate.before(endDate))
			return true;
		else
			return false;
	}
}

