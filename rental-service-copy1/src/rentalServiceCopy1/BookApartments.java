package rentalServiceCopy1;

import java.util.*;
import java.util.Map;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class BookApartments {
	public static boolean isBooked(String apartmentName, String apartmentType, Date startDate,Date endDate) {
		/*
		 * this function returns false , if the apartment is not booked for the given time slot
		 * and returns true , if its booked for the given time slot
		 */
			if(!Enumerations.bookedApartments.containsKey(apartmentName)) {   
				//if the booked apartment lists doesn't contain the apartment name , its available for booking
				return false;
		}
		else {
			HashMap<String,HashMap<Date,Date>> map = new HashMap<>();
			map = Enumerations.bookedApartments.get(apartmentName);
			/*
			 * check if the particular apartment type in the apartment is booked.
			 */
			if(!map.containsKey(apartmentType)) {
				return false;
			}
			/*
			 * if it is booked, compare the dates.
			 */
			else {
				Date bookedStartDate, bookedEndDate;
				HashMap<Date,Date> dates;
				dates = map.get(apartmentType);
				if(dates==null)
					return false;
				else {
					for(Map.Entry<Date, Date> iterator : dates.entrySet()) {
						bookedStartDate = iterator.getKey();
						bookedEndDate = iterator.getValue();
						if((startDate.before(bookedStartDate) && endDate.before(bookedEndDate)) || (startDate.after(bookedStartDate) && endDate.after(bookedEndDate)))
							return false;
				}
			}
		}
		return true;
	}
}
}
