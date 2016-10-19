package edu.avans.library.domain;

import java.util.Date;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class SetDate {
    private String timestamp;
    private String date;
    private String year;
    private String day;
    private String month;
    private String time;
    private String hour;
    private String minutes;
    private String seconds;
    
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FIVE = 5;
    
    /**
    * SetDate
    * SetDate creates datestamp 
    * @param settimestamp
    */
    
    public SetDate(String settimestamp) {
        timestamp= settimestamp;
    }
        
    /**
    * timestamp toString
    * timestamp toString gives back a timestamp 
     * @return 
    */
    @Override
    public String toString() {
        Date currentDate = new Date();
    
        date = currentDate.toString();
        String [] splitdate = date.split(" ");
        year = splitdate[FIVE];
        day = splitdate[TWO];
        month = splitdate[1];
        time = splitdate[THREE];
        String [] splittime = time.split(":");
        hour = splittime[0];
        minutes = splittime[1];
        seconds = splittime[TWO];
    
        if (month.contains("Jan")) {
            month = "01";
        } else if (month.contains("Feb")) {
            month = "02";
        } else if (month.contains("Mrt")) {
            month = "03";
        } else if (month.contains("Apr")) {
            month = "04";
        } else if (month.contains("May")) {
            month = "05";
        } else if (month.contains("Jun")) {
            month = "06";
        } else if (month.contains("Jul")) {
            month = "07";
        } else if (month.contains("Aug")) {
            month = "08";
        } else if (month.contains("Sep")) {
            month = "09";
        } else if (month.contains("Oct")) {
            month = "10";
        } else if (month.contains("Nov")) {
            month = "11";
        } else {
            month = "12";
        }
        // BUILD TIME STAMP
        timestamp = year+month+day+"_"+hour+minutes+seconds;

        return timestamp; 
    }
}
