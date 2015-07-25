package iCalendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Deliverable1 {

	public static void main(String[] args) {

		File file;
		icsFileFieldsCreator fields = new icsFileFieldsCreator();
		//to be used in comparator class for accessing methods
		GreatCircleDistance gcd1 = new GreatCircleDistance();
		UserInterface prompt = new UserInterface();
		Comparator<GCDNode> comparator = new FileStartTimeComparator();
		//for displaying the event names and times
		PriorityQueue<iCalendar.GCDNode> pq1 = new PriorityQueue<GCDNode>(10, comparator);
		//for calculating greatest circle distance
		PriorityQueue<iCalendar.GCDNode> pq2 = new PriorityQueue<GCDNode>(10, comparator);
		//for removing events from queue without geographic positions
		PriorityQueue<iCalendar.GCDNode> pq3 = new PriorityQueue<GCDNode>(10, comparator);
		


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
//			bufferedWriter.write(fields.setComments());
			bufferedWriter.newLine();

			bufferedWriter.write(fields.getEndEventType());
			bufferedWriter.newLine();
			bufferedWriter.write(fields.getEndCalendarType());
			bufferedWriter.close();
			

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


		//loop to find all .ics files in a folder
		for (int i = 0; i < listOfFiles.length; i++)
		{
			File fileFromList = listOfFiles[i];
			GreatCircleDistance gcd = new GreatCircleDistance();
			if (fileFromList.isFile() && fileFromList.getName().endsWith(".ics")) 
			{
				//read files
				try(BufferedReader reader = new BufferedReader(new FileReader(fileFromList)))
				{
					String currentLine;
					while ((currentLine = reader.readLine()) != null) 
					{	

						//Set required fields for each file for GCD
						gcd.setDateFromFile(currentLine);
						gcd.setStartTimeFromFile(currentLine);
						gcd.setEndTimeFromFile(currentLine);
						gcd.setEventNameFromFile(currentLine);
						gcd.setLatitudeFromFile(currentLine);
						gcd.setLongitudeFromFile(currentLine);
						gcd.setIntegerStartTimeFromFile(currentLine);
					}

					//add files that equal given day to priorityQueue based on start date
					if(gcd.getDateFromFile().equals(gcdDate))
					{
						//put all required fields for GCD into a node and store node according to start time
						GCDNode gcdNode = new GCDNode(fileFromList,gcd.getStartTimeFromFile(), gcd.getDateFromFile(), gcd.getEndTimeFromFile(),
								gcd.getEventNameFromFile(), gcd.getLatitudeFromFile(), gcd.getLongitudeFromFile(), gcd.getIntegerStartTimeFromFile());

						//pq1 is for printing contents, pq2 is for calculating gcd
						pq1.add(gcdNode);
						pq2.add(gcdNode);
					}
				} 
				catch (FileNotFoundException e) 
				{
					System.out.println("The path is incorrect");
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					System.out.println("The path is incorrect");
					e.printStackTrace();
				}
			}
		}	

		//printing contents of queue
		int queueSize = pq1.size();
		for(int j = 0; j < queueSize; j++ )
		{
			System.out.println(pq1.peek().getEventName() + " occurs from " + pq1.peek().getStartTime() + " to " + pq1.poll().getEndTime() );
		}
		System.out.println();

		//remove elements with no geographic positions
		for(int j = 0; j < queueSize; j++ )
		{
			GCDNode event = pq2.poll();
			if(!event.getLatitude().equals("") && !event.getLongitude().equals(""))
			{		
				pq3.add(event);
			}
			else
			{
				System.out.println("Cannot include " + event.getEventName() + " in greatest circle distance");
			}
		}
		System.out.println();
		
		//calculate circle distance
		queueSize = pq3.size();
		for(int j = 0; j < queueSize-1; j++ )
		{
			GCDNode event1 = pq3.poll();
			GCDNode event2 = pq3.peek();
			System.out.println(gcd1.CircleDistance(event1.getEventName(), event2.getEventName() , event1.getLatitude(), event1.getLongitude(), 
					event2.getLatitude(), event2.getLongitude()));
		}
	}
}

class FileStartTimeComparator implements Comparator<GCDNode> {

	@Override
	public int compare(GCDNode gcd1, GCDNode gcd2) {

		if(gcd1.getIntStartTime() < gcd2.getIntStartTime())
		{
			return -1;
		}

		if(gcd1.getIntStartTime() > gcd2.getIntStartTime())
		{
			return 1;
		}

		return 0;
	}
}
