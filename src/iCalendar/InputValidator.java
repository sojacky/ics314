package iCalendar;
/*This class is implements methods to validate all input from users*/
public class InputValidator {
	
	public InputValidator()
	{
		
	}
	
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

	//helper method to check if string is an integer
	private boolean isInteger(String str)
	{
		System.out.println("str = " + str);
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



