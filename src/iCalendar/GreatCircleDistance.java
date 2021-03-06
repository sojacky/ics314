package iCalendar;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

// Calculates the Great Circle Distance between two .ics events
public class GreatCircleDistance {
	private String startTime = "";
	private String date = "";
	private String endTime = "";
	private String eventName = "";
	String latitude = "";
	String longitude = "";
	int intDate = 0;
	int intStartTime = 0;
	String comment = "";
	icsFileFieldsCreator fields = new icsFileFieldsCreator();

	public GreatCircleDistance()
	{

	}

	//sets startTime from reading DSTART line of .ics file
	public void setStartTimeFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTSTART;TZID="))
		{
			startTime = currentLine.substring(lastOccurenceOfT(currentLine), currentLine.length());
		}
	}

	public String getStartTimeFromFile()
	{
		return startTime;
	}


	//must complete
	public void setEndTimeFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTEND;TZID="))
		{
			endTime = currentLine.substring(lastOccurenceOfT(currentLine), currentLine.length());
		}
	}

	//must complete
	public String getEndTimeFromFile()
	{
		return endTime;
	}


	public void setDateFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTSTART;TZID="))
		{

			int index = currentLine.indexOf(':');
			date = currentLine.substring(index+1, index +9);
		}
	}

	public String getDateFromFile()
	{
		return date;
	}

	public void setIntegerStartTimeFromFile(String currentLine)
	{

		if(currentLine.startsWith("DTSTART;TZID="))
		{
			intStartTime = Integer.parseInt(currentLine.substring(lastOccurenceOfT(currentLine), currentLine.length()));
		}

	}

	public int getIntegerStartTimeFromFile()
	{
		return intStartTime;
	}

	public void setEventNameFromFile(String currentLine)
	{
		if(currentLine.startsWith("SUMMARY"))
		{

			int index = currentLine.indexOf(':');
			eventName = currentLine.substring(index+1, currentLine.length());
		}
	}

	public String getEventNameFromFile()
	{
		return eventName;
	}

	public void setLatitudeFromFile(String currentLine)
	{
		if(currentLine.startsWith("GEO"))
		{
			int index = currentLine.indexOf(':');
			latitude = currentLine.substring(index + 1, currentLine.indexOf(';'));
		}

	}

	public String getLatitudeFromFile()
	{
		return latitude;
	}

	public void setLongitudeFromFile(String currentLine)
	{
		if(currentLine.startsWith("GEO"))
		{
			int index = currentLine.indexOf(';');
			longitude = currentLine.substring(index + 1, currentLine.length());

		}

	}

	public String getLongitudeFromFile()
	{
		return longitude;
	}


	//helper method to find the time of an event in a file
	private int lastOccurenceOfT(String str)
	{
		int index = 0;

		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'T')
			{
				index = i +1;
			}
		}
		return index;
	}



	// parameters to be used (String event1, String event2, String lat1, String lon1, String lat2, String lon2)
	public boolean CircleDistance(String event1, String event2, String lat1, String lon1, String lat2, String lon2)
	{

		// These are set to test method. Move variables to parameter to use properly
		//		String event1, event2, lat1, lon1, lat2, lon2;
		//		event1 = "Test Day";
		//		event2 = "Family Dinner";
		//		lat1 = "12.123456";
		//		lon1 = "-12.123456";
		//		lat2 = "65.654321";
		//		lon2 = "-65.654321";

		if(!lat1.equals("") && !lat2.equals("") && !lon1.equals("") && !lon2.equals(""))
		{	

		  // Earth's radius in kilometers
		  final int Rkm = 6371;
		  // Earth's radius in miles
		  final int Rmi = 3959;
		  
			// Convert latitude and longitude to radians
			double x1 = Double.parseDouble(lat1);
			double y1 = Double.parseDouble(lon1);
			double x2 = Double.parseDouble(lat2);
			double y2 = Double.parseDouble(lon2);
			double latDistance = Math.toRadians(x2 - x1);
			double lonDistance = Math.toRadians(y2 - y1);
			
			// The central angle between the given points on a sphere
			double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) + (Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2))) * (Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2));
			
			// The distance between two points (along a great circle of the sphere)
			double c = 2 * Math.asin(Math.sqrt(a));

	     // Get distance in kilometers. Rounds kilometers to 2 decimal places
			double kilometers = (double) Math.round((Rkm * c) * 100) / 100;
			
	     // Get distance in statute miles. Rounds miles to 2 decimal places
			double miles = (double) Math.round((Rmi * c) * 100) / 100;

			// Concatenate into one string for easy return
			setComment("COMMENT:" + event1 + " is " + kilometers + " kilometers away from " + event2 + ". " +
					event1 + " is " + miles + " miles away from " + event2 + ".");

			return true;

		}
		else
		{
			return false;
		}
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void commentDisplay(String comment)
	{
		System.out.println(comment);
	}

	public void cannotComputeGCDDisplay(String event1, String event2)
	{
		System.out.println("greatest circle distance cannot be computed between " + event1 + " and " + event2);
	}


}



