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
	public String setStartDateString(String startDate, String startTime)
	{
		String dtStart = "";
		dtStart = "DTSTART;TZID=Pacific/Honolulu:" + startDate + "T" + startTime;
		return dtStart;
	}

	//Set end date
	public String setEndDateString(String endDate, String endTime)
	{
		String dtEnd = "";
		dtEnd = "DTEND;TZID=Pacific/Honolulu:" + endDate + "T" + endTime;
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
	
	//set classification
	public String setClassification(String classification)
	{
		String result = "ClASS:" + classification;
		return result;
	
	}
	
	
	public String setGeographicPosition(String latitude, String longitude)
	{
		return "GEO:" + latitude + ";" + longitude;
 	}
	
	


}

//DTSTART;TZID=Pacific/Honolulu:20150518T150000
//DTEND;TZID=Pacific/Honolulu:20150518T160000
