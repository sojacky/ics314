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
			System.out.println("Please enter a start date(YYYYMMDD)");
			String startDate = scan.nextLine();
			//prompt user for start time
			System.out.println("Please enter a start time(HHMMSS)");
			String startTime = scan.nextLine();
			bufferedWriter.write(fields.setStartDateString(startDate, startTime));
			bufferedWriter.newLine();

			//prompt user for end date
			System.out.println("Please enter an end date(YYYYMMDD)");
			String endDate = scan.nextLine();

			//prompt user for end time
			System.out.println("Please enter a end time(HHMMSS)");
			String endTime = scan.nextLine();
			bufferedWriter.write(fields.setEndDateString(endDate, endTime));
			bufferedWriter.newLine();


			bufferedWriter.write(fields.setSummaryString(title));
			bufferedWriter.newLine();

			//location
			System.out.println("Please enter a location");
			String location = scan.nextLine();
			bufferedWriter.write(fields.setLocationString(location));
			bufferedWriter.newLine();	

			//classification
			System.out.println("Enter a classification if you would like, else type no");
			String classification = scan.nextLine();
			if(!classification.equals("no"))
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
