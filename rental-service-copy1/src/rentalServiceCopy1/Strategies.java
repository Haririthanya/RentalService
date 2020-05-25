package rentalServiceCopy1;

import java.util.*;

public class Strategies {
	
	static HashMap<String,Double> iterator = new HashMap<String,Double>();
	static TreeMap<Double,String> locationAndPrice = new TreeMap<Double,String>(); 
	private static HashMap<String,HashMap<Date,Date>> typeAnddate = new HashMap<>();
	
	public static boolean findApartments(String apartmentType) {
		/*
		 * function returns true if the price is entered else false.
		 * find the location , and sort it based on the lowest price.Hence TreeMap is used.
		 */
		boolean checkIfApartmentTypeHasPrice = false;
		for(Map.Entry<String,HashMap<String,Double>> pricePerLocationPerDay : Enumerations.pricePerLocation.entrySet()) {
			/*
			 * check if the locations have the required apartment type, if so add it to the treemap.
			 * check if the price has been entered for one location atleast with required apartment type.
			 */
			String location = pricePerLocationPerDay.getKey();
			iterator = pricePerLocationPerDay.getValue();
			if(iterator.containsKey(apartmentType)) {
				checkIfApartmentTypeHasPrice = true;
				locationAndPrice.put(iterator.get(apartmentType),location);	
			}
		}
		return checkIfApartmentTypeHasPrice;
	}

	public static void lowestPriceFirst(String apartmentType, Date startDate, Date endDate) {
		/*
		 * first check if any apartment information is added. 
		 */
		if(Enumerations.apartmentList.size()==0)
			System.out.println("No Apartments added");
		else {
				/*
				 * fetch all the location from which the apartment should be booked.
				 */
			if(!findApartments(apartmentType)) {
				System.out.println("Price for the given apartment type is not entered");
			}
			else {
				HashMap<Date, Date> date = new HashMap<>(); 
				boolean booked = false;
				for(Map.Entry<Double, String> map : locationAndPrice.entrySet()) {
					String getLocation = map.getValue();  // get location sorted by lowest price
					HashMap<String,List<String>> list = new HashMap<>(); 
					list = Enumerations.apartmentList.get(getLocation);   
					List<String> listOfApartments = list.get(apartmentType); //get the list of apartments in the chosen location.
					int i = 0;
					while(i<listOfApartments.size()) {
						if(!BookApartments.isBooked(listOfApartments.get(i),apartmentType,startDate,endDate)) {
							booked = true;
							if(date == null) {
								date = new HashMap<>();   // add the information of the booked apartment to bookedApartment data structure. 
							}	
							date.put(startDate, endDate);
							if(typeAnddate==null)
								typeAnddate = new HashMap<>();
							typeAnddate.put(apartmentType, date);
							Enumerations.bookedApartments.put(listOfApartments.get(i), typeAnddate);
							System.out.println(listOfApartments.get(i)+" from "+getLocation+" is booked.");
							break;
						}
						i++;
					}
					if(booked==true) {
						break;
					}
					date =null;
					typeAnddate = null;
				}
				if(booked==false)
					System.out.println("No Apartments Available");
			}
		}
	}	
}
