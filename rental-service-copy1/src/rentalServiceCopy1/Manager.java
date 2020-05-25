package rentalServiceCopy1;

import java.util.*;

public class Manager {
	
	static ManagerSingleton manager = ManagerSingleton.getInstance();
	
	public static ManagerSingleton createManager() { 
		return manager;
	}	
}


