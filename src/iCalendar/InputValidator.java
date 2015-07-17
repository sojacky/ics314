package iCalendar;
/*This class is implements methods to validate all input from users*/
public class InputValidator {
	
	public InputValidator()
	{
		
	}
	
	//method to check that the date input is valid
	public boolean isValidDateString(String date)
	{
		boolean isValidDate = false;
		if(date.length() == 10 && isInteger(date.substring(0,2)) && isInteger(date.substring(3,5)) && 
				isInteger(date.substring(6, date.length())) && 
				date.substring(2,3).equals("/") && date.substring(5,6).equals("/") )
		{
			isValidDate = true;
		}
		
		return isValidDate;
	}
	
	public boolean isValidTimeString(String time)
	{
		boolean isValidTime = false;
		if(time.length() == 4 && isInteger(time))
		{
			isValidTime = true;
		}
		return isValidTime;
		
	}
	
	public boolean isValidClassification(String classification)
	{
		boolean isValidClassification = false;
		if(classification.equalsIgnoreCase("public") || classification.equalsIgnoreCase("private") ||
				classification.equalsIgnoreCase("NA"))
		{
			isValidClassification = true;
		}
		return isValidClassification;
		
	}

	//helper method to check if string is an integer
	private boolean isInteger(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
			
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	
}



