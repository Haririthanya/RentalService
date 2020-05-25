package rentalServiceCopy1;

import java.util.*;

public class Enumerations {
	/*
	 * All data structures used for storing the information
	 */
	
	/*
	 * bookedApartments -> Apartment name is mapped to apartment type , which is in-turn mapped to the start and end date.
	 * location -> contains the list of all the locations in the city,the company operates
	 * pricePerLocation -> Location is mapped to apartment type which is mapped to its price
	 * apartmentList -> Location is mapped to apartment type ,which is mapped to a list of apartment names which contain that particular apartment type. 
	 */
	
	
	public static TreeMap<String,HashMap<String,HashMap<Date,Date>>> bookedApartments = new TreeMap<>();
	public static List<String> location = new LinkedList<>();
	public static HashMap<String,HashMap<String,Double>> pricePerLocation = new HashMap<>();
	public static TreeMap<String,HashMap<String,List<String>>> apartmentList = new TreeMap<>();
}
