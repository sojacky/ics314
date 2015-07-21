package iCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class icsFileFieldsCreator {
	Calendar cal;
	private String fileName = "";
	private String beginCalendarType = "BEGIN:VCALENDAR";
	private String version = "VERSION:2.0";
	private String calScale = "CALSCALE:GREGORIAN";
	private String beginEventType = "BEGIN:VEVENT";
	private String endCalendarType = "END:VCALENDAR";
	private String endEventType = "END:VEVENT";


	public icsFileFieldsCreator(){};

	//set the UID 
	public String setUIDString()
	{
		String UID = "";
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS");
		cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		UID = "UID:" + date + "@mpsommer";
		return UID;
	}

	//Set the date stamp
	public String setDateStampString()
	{
		String dtStamp = "";
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
		Date date = new Date();
		dtStamp = "DTSTAMP:" + dateFormat.format(date);
		return dtStamp;	
	}


	//Set start date
	public String setStartDateString(String startDate, String startTime)
	{
		String dtStart = "";
		startTime = toMilitaryTime(startTime);
		dtStart = "DTSTART;TZID=Pacific/Honolulu:" + dateFormatter(startDate) + "T" + startTime + "00";//two zeroes at end are for seconds
		return dtStart;
	}

	//Set end date
	public String setEndDateString(String endDate, String endTime)
	{
		String dtEnd = "";
		endTime = toMilitaryTime(endTime);
		dtEnd = "DTEND;TZID=Pacific/Honolulu:" + dateFormatter(endDate) + "T" + endTime + "00";//two zeroes at end are for seconds
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

	//set time zone
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
		String result = "CLASS:" + classification;
		return result;

	}

	//set geographic position
	public String setGeographicPosition(String latitude, String longitude)
	{
		return "GEO:" + latitude + ";" + longitude;
	}


	public void setFileName(String fileName)
	{
		this.fileName = fileName + ".ics";
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setBeginCalendarType(String calendarType)
	{
		beginCalendarType = "BEGIN:" + calendarType;
	}

	public String getBeginCalendarType()
	{
		return beginCalendarType;
	}

	public void setVersion(String version)
	{
		this.version = "VERSION:" + version;
	}

	public String getVersion()
	{
		return version;
	}

	public void setCalScale(String calScale)
	{
		this.calScale = "CALSCALE:" + calScale;
	}

	public String getCalScale()
	{
		return calScale;
	}

	public void setBeginEventType(String beginEventType)
	{
		this.beginEventType = "BEGIN:" + beginEventType;
	}

	public String getBeginEventType()
	{
		return beginEventType;
	}

	public void setEndCalendarType(String calendarType)
	{
		endCalendarType = "END:" + calendarType;
	}

	public String getEndCalendarType()
	{
		return endCalendarType;
	}

	public void setEndEventType(String eventType)
	{
		endEventType = "END:" + eventType;
	}

	public String getEndEventType()
	{
		return endEventType;
	}

	private String dateFormatter(String date)
	{
		return date.substring(6, date.length()) + date.substring(0,2) + date.substring(3,5);
	}

	//converts standard time to military time
	private String toMilitaryTime(String time)
	{
		if(time.substring(6, 8).equalsIgnoreCase("am"))
		{
			time = time.substring(0, 2) + time.substring(3, 5);
		}
		else
		{
			int timeInteger = Integer.parseInt(time.substring(0, 2));
			timeInteger = timeInteger + 12;
			time = Integer.toString(timeInteger) + time.substring(3, 5); 
			
		}

		return time;

	}

}


