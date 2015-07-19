package iCalendar;

/*This class contains all methods that write .ics file fields to a .ics file. 
 * It also creates a .ics file.*/

public class ICSFileWriter {
	
	private String fileName = "";
	
	public ICSFileWriter()
	{
		
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName + ".ics";
	}

	public String getFileName()
	{
		return fileName;
	}
	

}
