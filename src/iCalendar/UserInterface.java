package iCalendar;

import java.util.Scanner;

public class UserInterface {
	
	InputValidator inputCheck = new InputValidator();
	Scanner scan = new Scanner(System.in);
	
	public UserInterface()
	{
		
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
		System.out.println("Please enter a start time(hhmm)");
		String startTime = scan.nextLine();
		
		while(!inputCheck.isValidTimeString(startTime))
		{
			System.out.print("Invalid start time, ");
			System.out.println("Please enter a start time(hhmm)");
		    startTime = scan.nextLine();
			
		}
		
		return startTime;
	}
	
	public String endTimePrompt()
	{
		System.out.println("Please enter an end time(hhmm)");
		String endTime = scan.nextLine();
		
		while(!inputCheck.isValidTimeString(endTime))
		{
			System.out.print("Invalid end time, ");
			System.out.println("Please enter an end time(hhmm)");
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
			System.out.println("For classification, please type: public, private, or NA if you "
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
	
	
}
