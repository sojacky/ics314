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

			//create a new file if it doesn't exist already


			System.out.println("Please enter a title for your event");
			String title = scan.nextLine();
			filePath = title + ".ics";
			file = new File(filePath);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(filePath);
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

			System.out.println("Please enter a start date(YYYY/MM/DD)");
			String startDate = scan.nextLine();
			System.out.println("Please enter a start time(HHMMSS)");
			String startTime = scan.nextLine();
			bufferedWriter.write(fields.setStartDateString(startDate, startTime));
			bufferedWriter.newLine();

			System.out.println("Please enter an end date(YYYY/MM/DD)");
			String endDate = scan.nextLine();
			System.out.println("Please enter a end time(HHMMSS)");
			String endTime = scan.nextLine();
			bufferedWriter.write(fields.setEndDateString(endDate, endTime));
			bufferedWriter.newLine();


			bufferedWriter.write(fields.setSummaryString(title));
			bufferedWriter.newLine();

			System.out.println("Please enter a location");
			String location = scan.nextLine();
			bufferedWriter.write(fields.setLocationString(location));
			bufferedWriter.newLine();	

			System.out.println("Enter a classification if you would like, else type no");
			String classification = scan.nextLine();
			if(!classification.equals("no"))
			{
				bufferedWriter.write(fields.setClassification(classification));
				bufferedWriter.newLine();	
			}
			
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




		//		System.out.println("BEGIN:VCALENDAR");
		//		System.out.println("VERSION:2.0");
		//		System.out.println("CALSCALE:GREGORIAN");
		//		System.out.println("BEGIN:VEVENT");
		//		System.out.println("UID:1234123412341234");
		//		System.out.println("DTSTAMP:20150708");

		//		System.out.println("DTSTART;VALUE=DATE:20150801");
		//		System.out.println("DTEND;VALUE=DATE:20150802");


		//		System.out.println("SUMMARY:TEST0708");
		//		System.out.println("END:VEVENT");
		//		System.out.println("END:VCALENDAR");

	}

}
