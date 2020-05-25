package rentalServiceCopy1;


import java.util.*;


public class ManagerSingleton {

	volatile static ManagerSingleton instance;
	
	public static ManagerSingleton getInstance() {
		if(instance == null) {
			synchronized (ManagerSingleton.class) {
				if(instance == null)
					instance = new ManagerSingleton();
			}
		} 
		return instance;
	}
	
	public ManagerSingleton getFields() {
		return instance;
	}

	public void addBranch(String locationName) {
		if(Validation.isLocationAvailable(locationName))
			System.out.println("Location already exists");
		else 
			Enumerations.location.add(locationName);
	}
		
	public void addApartment(String apartmentName, String apartmentType, String apartmentLocation) {
		HashMap<String,List<String>> map;
		List<String> list=new LinkedList<>();
		map = Enumerations.apartmentList.get(apartmentLocation);
		if(map==null) {
			map = new HashMap<>();
		    list.add(apartmentName);
		}
		else {
			/*
			 * add the apartment name to existing list of apartment names for an apartment type
			 */
			if(map.containsKey(apartmentType))
				list = map.get(apartmentType);
			list.add(apartmentName);
		}
		map.put(apartmentType,list);
		Enumerations.apartmentList.put(apartmentLocation, map);
	}
}
