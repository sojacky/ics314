package iCalendar;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

public class UserInterface {

	InputValidator inputCheck = new InputValidator();
	Scanner scan = new Scanner(System.in);
	TimeZone timezone;
	ArrayList<String> timezoneIDs;



	public UserInterface()
	{

	}

	public boolean createEventPrompt()
	{
		boolean position = false;
		String decision = "";

		System.out.println("Would you like to create an event? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like to create an event? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			position = true;
		}
		return position;
	}

	public boolean createAnotherEventPrompt()
	{
		boolean position = false;
		String decision = "";

		System.out.println("Would you like to create another event? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like to create another event? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			position = true;
		}
		return position;
	}
	public String titlePrompt()
	{
		System.out.println("Please enter a title for your event");
		String title = scan.nextLine();
		return title;
	}

	public String startDatePrompt()
	{
		System.out.println("Please enter a start date(mm/dd/yyyy)");
		String startDate = scan.nextLine();

		while(!inputCheck.isValidDateString(startDate))
		{
			System.out.print("Invalid start date, ");
			System.out.println("Please enter a start date(mm/dd/yyyy)");
			startDate = scan.nextLine();
		}
		return startDate;
	}

	public String endDatePrompt()
	{
		System.out.println("Please enter an end date(mm/dd/yyyy)");
		String endDate = scan.nextLine();

		while(!inputCheck.isValidDateString(endDate))
		{
			System.out.print("Invalid end date, ");
			System.out.println("Please enter an end date(mm/dd/yyyy)");
			endDate = scan.nextLine();
		}
		return endDate;
	}

	public String startTimePrompt()
	{
		System.out.println("Please enter a start time(hh:mm am/pm)");
		String startTime = scan.nextLine();

		while(!inputCheck.isValidTimeString(startTime))
		{
			System.out.print("Invalid start time, ");
			System.out.println("Please enter a start time(hh:mm am/pm)");
			startTime = scan.nextLine();

		}

		return startTime;
	}

	public String endTimePrompt()
	{
		System.out.println("Please enter an end time(hh:mm am/pm)");
		String endTime = scan.nextLine();

		while(!inputCheck.isValidTimeString(endTime))
		{
			System.out.print("Invalid end time, ");
			System.out.println("Please enter an end time(hh:mm am/pm)");
			endTime = scan.nextLine();

		}

		return endTime;
	}

	public String classificationPrompt()
	{

		System.out.println("For classification, please type: public, private, or NA if you "
				+ "do not wish to specify classification.");
		String classification = scan.nextLine();

		while(!inputCheck.isValidClassification(classification))
		{
			System.out.print("Invalid classification input, ");
			System.out.println("For classification, please type: public, private, confidential, or NA if you "
					+ "do not wish to specify classification.");
			classification = scan.nextLine();

		}
		return classification;
	}

	public boolean classificationEqualsNA(String classification)
	{
		boolean classificationEqualsNA = false;
		if(classification.equalsIgnoreCase("NA"))
		{
			classificationEqualsNA = true;
		}

		return classificationEqualsNA;

	}

	public String locationPrompt()
	{
		System.out.println("Please enter a location");
		String location = scan.nextLine();
		return location;
	}

	public String timeZonePrompt()
	{
		setTimeZoneIDs();
		System.out.println("Please enter a timezone(e.g. =  Pacific/Honolulu)");
		String title = scan.nextLine();	
		boolean correctTimeZone = false;
		while(!correctTimeZone)
		{
			for(int i = 0; i < timezoneIDs.size()-5; i++)
			{
				if(title.equalsIgnoreCase(timezoneIDs.get(i)))
				{
					correctTimeZone = true;
					break;
				}
			}

			if(!correctTimeZone)
			{
				System.out.println("Invalid timezone entry. Your entry must match entry from list");
				System.out.println("Would you like to see a list of timezones? Type yes or no");
				String decision = scan.nextLine();
				while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
				{	
					System.out.println("Invalid entry. Would you like to see a list of timezones? Type yes or no");
					decision = scan.nextLine();
				}

				if(decision.equals("yes"))
				{
					printTimeZoneIDs();
					System.out.println("Please enter a timezone(e.g. =  Pacific/Honolulu)");
					title = scan.nextLine();
				}
				else
				{
					System.out.println("Please enter a timezone(e.g. =  Pacific/Honolulu)");
					title = scan.nextLine();	
					
				}
			}

		}

		return title;
	}



	public String latitudinalPrompt()
	{
		String latitude;
		System.out.println("Please enter a latitudinal cooridinate(+/-)00.000000");
		latitude = scan.nextLine();

		while(!(inputCheck.isValidGeographicPosition(latitude)))
		{
			System.out.print("Invalid input! ");
			System.out.println("Please enter a latitudinal cooridinate(+/-)00.000000");
			latitude = scan.nextLine();

		}

		return latitude;
	}

	public String longitudinalPrompt()
	{
		String longitude;
		System.out.println("Please enter a longitudinal cooridinate(+/-)00.000000");
		longitude = scan.nextLine();

		while(!inputCheck.isValidGeographicPosition(longitude))
		{
			System.out.print("Invalid input! ");
			System.out.println("Please enter a longitudinal cooridinate(+/-)00.000000");
			longitude = scan.nextLine();

		}

		return longitude;

	}

	public String gcdDatePrompt()
	{
		System.out.println("Please enter a date for greatest circle distance of events(mm/dd/yyyy)");
		String date = scan.nextLine();

		while(!inputCheck.isValidDateString(date))
		{
			System.out.print("Invalid date, ");
			System.out.println("Please enter a date for greatest circle distance of events(mm/dd/yyyy)");
			date = scan.nextLine();
		}
		return date;
	}

	public String folderPathPrompt()
	{
		System.out.println("Please enter a path to folder containing .ics files");
		String folderPath = scan.nextLine();
		File file = new File(folderPath);
		while(!file.isDirectory())
		{
			System.out.print("Invalid path, ");
			System.out.println("Please enter a path to folder containing .ics files");
			folderPath = scan.nextLine();
			file = new File(folderPath);
		}
		return folderPath;
	}

	public boolean enterGeographicPosition()
	{
		boolean position = false;
		String decision = "";

		System.out.println("Would you like to enter a geographic position? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like to enter a geographic position? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			position = true;
		}
		return position;
	}

	public boolean enterTimeZone()
	{
		boolean result = false;
		String decision = "";
		System.out.println("Would you like to enter a timezone? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like to enter a timezone? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			result = true;
		}
		return result;

	}

	public boolean enterGreatCircleDistance()
	{
		boolean result = false;
		String decision = "";
		System.out.println("Would you like calculate the great cirlce distance for all events on a given date? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like calculate the great cirlce distance for all events on a given date? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			result = true;
		}
		return result;

	}

	public boolean enterAnotherGreatCircleDistance()
	{
		boolean result = false;
		String decision = "";
		System.out.println("Would you like calculate the great cirlce distance for all events on a given date again? type yes or no");
		decision = scan.nextLine();

		while(!decision.equalsIgnoreCase("no")  && !decision.equalsIgnoreCase("yes"))
		{
			System.out.print("Invalid input. ");	
			System.out.println("Would you like calculate the great cirlce distance for all events on a given date again? type yes or no");
			decision = scan.nextLine();
		}

		if(decision.equals("yes"))
		{
			result = true;
		}
		return result;

	}

	//helper method to initialize the timeZoneIDs array
	private void setTimeZoneIDs()
	{
		String[] timezoneID = TimeZone.getAvailableIDs();
		timezoneIDs = new ArrayList<String>();
		for(int i = 0; i < timezoneID.length; i++ )
		{		
			if(timezoneID[i].contains("/"))
			{
				timezoneIDs.add(timezoneID[i]);			
			}
		}
	}

	private void printTimeZoneIDs()
	{
		for(int i = 0; i < timezoneIDs.size()-5; i=i+5)
		{
			System.out.print(String.format("%-35s%-35s%-35s%-35s%-35s\n" , timezoneIDs.get(i),  timezoneIDs.get(i+1),  timezoneIDs.get(i+2),  timezoneIDs.get(i+3),  timezoneIDs.get(i+4)));		
		}
	}

}
