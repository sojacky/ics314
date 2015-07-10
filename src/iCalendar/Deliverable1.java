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
			String title = scan.next();
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
			String startDate = scan.next();
			bufferedWriter.write(fields.setStartDateString(startDate));
			bufferedWriter.newLine();
			
			System.out.println("Please enter an end date(YYYY/MM/DD)");
			String endDate = scan.next();
			bufferedWriter.write(fields.setEndDateString(endDate));
			bufferedWriter.newLine();
			

			bufferedWriter.write(fields.setSummaryString(title));
			bufferedWriter.newLine();
			
			System.out.println("Please enter a location");
			String location = scan.next();
			bufferedWriter.write(fields.setLocationString(location));
			bufferedWriter.newLine();		
			
			bufferedWriter.write("END:VEVENT");
			bufferedWriter.newLine();
			bufferedWriter.write("END:VCALENDAR");
			
			
		
			 bufferedWriter.close();
			
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
