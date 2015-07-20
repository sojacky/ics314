package iCalendar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Deliverable1 {

	public static void main(String[] args) {

		File file;
		icsFileFieldsCreator fields = new icsFileFieldsCreator();
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
		boolean position = false;

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
			bufferedWriter.write(fields.hawaiiStandardTimeCreator());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getBeginEventType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setUIDString());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setDateStampString());
			bufferedWriter.newLine();

			//write start date and time to file
			bufferedWriter.write(fields.setStartDateString(startDate, startTime));
			bufferedWriter.newLine();

			//write end date and time to file
			bufferedWriter.write(fields.setEndDateString(endDate, endTime));
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

			bufferedWriter.write(fields.getEndEventType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getEndCalendarType());
			bufferedWriter.close();
			scan.close();

		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}
