package iCalendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Deliverable1 {

	public static void main(String[] args) {

		File file;
		icsFileFieldsCreator fields = new icsFileFieldsCreator();
		GreatCircleDistance gcd = new GreatCircleDistance();
		Scanner scan = new Scanner(System.in);
		UserInterface prompt = new UserInterface();
		String title = "";
		String startDate = "";
		String endDate = "";
		String startTime = "";
		String endTime = "";
		String location = "";
		String classification = "";
		String latitude = "";
		String longitude = "";
		String timeZone = "Pacific/Honolulu";
		boolean position = false;
		String gcdDate = "";
		String folderPath = "";

		/*
		 * All THE USER INTERFACE PROMPTS
		 */

		//prompt user for title and set fileName
		title = prompt.titlePrompt();

		//prompt user for start date
		startDate = prompt.startDatePrompt();

		//prompt user for end date
		endDate = prompt.endDatePrompt();

		//prompt user for start time
		startTime = prompt.startTimePrompt();	

		//prompt user for end time
		endTime = prompt.endTimePrompt();

		//prompt user for time zone
		if(prompt.enterTimeZone())
		{
			timeZone = prompt.timeZonePrompt(); 
		}

		//location
		location = prompt.locationPrompt();

		//classification
		classification = prompt.classificationPrompt();

		//geographic position
		position = prompt.enterGeographicPosition();
		if(position)
		{
			latitude = prompt.latitudinalPrompt();
			longitude = prompt.longitudinalPrompt();
		}

		//prompt for calculating great circle distance
		if(prompt.enterGreatCircleDistance())
		{
			folderPath = prompt.folderPathPrompt();
			gcdDate = prompt.gcdDatePrompt();
			gcdDate = fields.dateFormatter(gcdDate);

		}






		/*
		 * WRITE ALL FIELDS TO FILE
		 */

		try {
			fields.setFileName(title);
			file = new File(fields.getFileName());
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(fields.getFileName());

			//Writing input to file
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(fields.getBeginCalendarType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getVersion());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getCalScale());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setTZIDString(timeZone));
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getBeginEventType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setUIDString());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setDateStampString());
			bufferedWriter.newLine();

			//write start date and time to file
			bufferedWriter.write(fields.setStartDateString(startDate, startTime, timeZone));
			bufferedWriter.newLine();

			//write end date and time to file
			bufferedWriter.write(fields.setEndDateString(endDate, endTime, timeZone));
			bufferedWriter.newLine();

			//write summary field
			bufferedWriter.write(fields.setSummaryString(title));
			bufferedWriter.newLine();

			//write location to file
			bufferedWriter.write(fields.setLocationString(location));
			bufferedWriter.newLine();	

			//classification
			if(!prompt.classificationEqualsNA(classification))
			{
				bufferedWriter.write(fields.setClassification(classification));
				bufferedWriter.newLine();	
			}

			//geographic position
			if(position)
			{
				bufferedWriter.write(fields.setGeographicPosition(latitude, longitude));
				bufferedWriter.newLine();
			}

			//To be determined. Needs list of events before knowing where to add this.
			bufferedWriter.write(fields.setComments());
			bufferedWriter.newLine();

			bufferedWriter.write(fields.getEndEventType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getEndCalendarType());
			bufferedWriter.close();
			scan.close();

		} catch (IOException e) 
		{
			e.printStackTrace();	
		}

		/*
		 * Read From file
		 */

		//path to folders where .ics files are located
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
/*
		//loop to find all .ics files in a folder
		for (int i = 0; i < listOfFiles.length; i++)
		{
			File fileFromList = listOfFiles[i];
			if (fileFromList.isFile() && fileFromList.getName().endsWith(".ics")) 
			{

				
				//read files
				try(BufferedReader reader = new BufferedReader(new FileReader(fileFromList)))
				{
					String currentLine;

					while ((currentLine = reader.readLine()) != null) 
					{

						//find the startTime and date
						gcd.setDateFromFile(currentLine);
						gcd.setStartTimeFromFile(currentLine);
						gcd.setEndTimeFromFile(currentLine);
						gcd.setEventNameFromFile(currentLine);
					}
					System.out.println("date = " +gcd.getDateFromFile());
					System.out.println("startTime = " + gcd.getStartTimeFromFile());
					System.out.println("endTime = " + gcd.getEndTimeFromFile());
					System.out.println("Event name =" + gcd.getEventNameFromFile());
				} 
				catch (FileNotFoundException e) 
				{

					e.printStackTrace();
				} 
				catch (IOException e)
				{

					e.printStackTrace();
				}
				 
			} 

		}	
*/
	}
}
