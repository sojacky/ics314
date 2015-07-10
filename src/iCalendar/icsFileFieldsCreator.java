package iCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class icsFileFieldsCreator {
	Calendar cal;
	

	public icsFileFieldsCreator(){};
	
	
	
	//set the UID 
	public String setUIDString()
	{
		String UID = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		   cal = Calendar.getInstance();
		   String date = dateFormat.format(cal.getTime());
		   UID = "UID:" + date + "@mpsommer";
		
		return UID;
	}
	
	//Set the date stamp
	public String setDateStampString()
	{
		String dtStamp = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		dtStamp = "DTSTAMP:" + dateFormat.format(date);
		return dtStamp;	
	}
	
	
	//Set start date
	public String setStartDateString(String startDate)
	{
		String dtStart = "";

		dtStart = "DTSTART;VALUE=DATE:" + startDate;
		return dtStart;
	}
	
	//Set end date
	public String setEndDateString(String endDate)
	{
		String dtEnd = "";
		dtEnd = "DTEND;VALUE=DATE:" + endDate;
		return dtEnd;
	}

	//set title
	public String setSummaryString(String title)
	{
		String summary = "";
		
		summary = "SUMMARY:" + title;
		
		return summary;
	}
	
	//set location
	public String setLocationString(String location)
	{
		return "LOCATION:" + location;
		
	}
	
	public String hawaiiStandardTimeCreator()
	{
		String timeZoneBlock = 
				"BEGIN:VTIMEZONE\n"+
				"TZID:Pacific/Honolulu\n"+
				"BEGIN:DAYLIGHT\n"+
				"TZOFFSETFROM:-1030\n"+
				"DTSTART:19330430T020000\n"+
				"TZNAME:HDT\n"+
				"TZOFFSETTO:-0930\n"+
				"RDATE:19330430T020000\n"+
				"RDATE:19420209T020000\n"+
				"END:DAYLIGHT\n"+
				"BEGIN:STANDARD\n"+
				"TZOFFSETFROM:-1030\n"+
				"DTSTART:19470608T020000\n"+
				"TZNAME:HST\n"+
				"TZOFFSETTO:-1000\n"+
				"RDATE:19470608T020000\n"+
				"END:STANDARD\n"+
				"END:VTIMEZONE";
				return timeZoneBlock;
	}
	/*
	BEGIN:VTIMEZONE
	TZID:Pacific/Honolulu
	BEGIN:DAYLIGHT
	TZOFFSETFROM:-1030
	DTSTART:19330430T020000
	TZNAME:HDT
	TZOFFSETTO:-0930
	RDATE:19330430T020000
	RDATE:19420209T020000
	END:DAYLIGHT
	BEGIN:STANDARD
	TZOFFSETFROM:-1030
	DTSTART:19470608T020000
	TZNAME:HST
	TZOFFSETTO:-1000
	RDATE:19470608T020000
	END:STANDARD
	END:VTIMEZONE
	
	*/
	
}
