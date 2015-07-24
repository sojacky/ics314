package iCalendar;

import java.util.Scanner;

public class UserInterface {

	InputValidator inputCheck = new InputValidator();
	Scanner scan = new Scanner(System.in);

	public UserInterface()
	{

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
		System.out.println("Please enter a timezone(e.g. =  Pacific/Honolulu)");
		String title = scan.nextLine();
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


}
