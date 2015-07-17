package iCalendar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Deliverable1 {

	public static void main(String[] args) {


		String filePath = "";		
		File file;
		icsFileFieldsCreator fields = new icsFileFieldsCreator();
		Scanner scan = new Scanner(System.in);
		UserInterface prompt = new UserInterface();
		//InputValidator inputCheck = new InputValidator();

		try {


			System.out.println("Please enter a title for your event");
			String title = scan.nextLine();

			//for name of file
			filePath = title + ".ics";
			file = new File(filePath);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(filePath);

			//Writing input to file
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("BEGIN:VCALENDAR");
			bufferedWriter.newLine();
			bufferedWriter.write("VERSION:2.0");
			bufferedWriter.newLine();
			bufferedWriter.write("CALSCALE:GREGORIAN");
			bufferedWriter.newLine();
			bufferedWriter.write(fields.hawaiiStandardTimeCreator());
			bufferedWriter.newLine();
			bufferedWriter.write("BEGIN:VEVENT");
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setUIDString());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.setDateStampString());
			bufferedWriter.newLine();

			//prompt user for start date
			String startDate = prompt.startDatePrompt();
			
			//prompt user for end date
			String endDate = prompt.endDatePrompt();
			
			//prompt user for start time
			String startTime = prompt.startTimePrompt();	
			
			//write start date and time to file
			bufferedWriter.write(fields.setStartDateString(startDate, startTime));
			bufferedWriter.newLine();



			//prompt user for end time
			String endTime = prompt.endTimePrompt();
		
			//write end date and time to file
			bufferedWriter.write(fields.setEndDateString(endDate, endTime));
			bufferedWriter.newLine();


			bufferedWriter.write(fields.setSummaryString(title));
			bufferedWriter.newLine();

			//location
			String location = prompt.locationPrompt();
			
			//write location to file
			bufferedWriter.write(fields.setLocationString(location));
			bufferedWriter.newLine();	

			//classification
			String classification = prompt.classificationPrompt();
			if(!prompt.classificationEqualsNA(classification))
			{
				bufferedWriter.write(fields.setClassification(classification));
				bufferedWriter.newLine();	
			}

			//geographic position
			System.out.println("Would you like to enter a geographic position? type yes or no");
			String decision = scan.nextLine();
			if(decision.equalsIgnoreCase("yes"))
			{
				System.out.println("Please enter a latitudinal cooridinate(+/-)00.000000");
				String latitude = scan.nextLine();
				System.out.println("Please enter a longitudinal cooridinate(+/-)00.000000");
				String longitude = scan.nextLine();
				bufferedWriter.write(fields.setGeographicPosition(latitude, longitude));
				bufferedWriter.newLine();	
			}

			bufferedWriter.write("END:VEVENT");
			bufferedWriter.newLine();
			bufferedWriter.write("END:VCALENDAR");



			bufferedWriter.close();
			scan.close();

		} catch (IOException e) {
			e.printStackTrace();	
		}

	}

}
