package com.elevator.simulator.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GeneralUtils {
	
   /**
    * Date format
    * @param date
    * @param addBracket
    * @return
    */
   public static String formatDate(Date date, boolean addBracket) {
		DateFormat format = DateFormat.getDateTimeInstance();
		TimeZone timeZone = Calendar.getInstance().getTimeZone(); 
		if(addBracket) {
			return format.format(date) + " (" + timeZone.getDisplayName(false, TimeZone.SHORT) + ")";
		}else {
			return format.format(date) + " " + timeZone.getDisplayName(false, TimeZone.SHORT) ;
		}
		
	}
   
   /**
    * Date format 
    * @param dateMilliSeconds the milliseconds since January 1, 1970, 00:00:00 GMT 
    * @param addBracket
    * @return
    */
   public static String formatDate(long dateMilliSeconds) {
	  Date date = new Date(dateMilliSeconds);
	  return formatDate(date,true);
	}


}
