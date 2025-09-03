package generic_Utility;

import java.util.Date;
/**
 * This class contains methods of java 
 */
import java.util.Random;

public class JavaUtility {

	/**
	 * This method will return random numbers
	 * 
	 * @param driver
	 * @return
	 */
	public int toCallRandom() {
		Random r = new Random();
		return r.nextInt(1000);
	}

	/**
	 * This method to get final date in our version
	 * @return
	 */
	public String toGetSystemDateAndTime() {
		Date d = new Date();
		String [] date= d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":","-");
		String year = date[5];
		
		String finalDate = day+" "+month+" "+date1+" "+time+" "+year;
		return finalDate;
	}
	
}
