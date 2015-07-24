package iCalendar;

import java.io.File;

public class GCDNode {
	
	private File file;
	private String startTime = "";
	private String date = "";
	private String endTime = "";
	private String eventName = "";
	private String latitude = "";
	private String longitude = "";
	private int intStartTime = 0;
	GreatCircleDistance gcd = new GreatCircleDistance();
	
	
	public GCDNode(File file, String startTime, String date, String endTime, String eventName, String latitude,
			String longitude, int intStartTime)
	{
		this.file = file;
		this.startTime = startTime;
		this.date = date;
		this.endTime = endTime;
		this.eventName = eventName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.intStartTime = intStartTime;
		
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public int getIntStartTime() {
		return intStartTime;
	}


	public void setIntStartTime(int intStartTime) {
		this.intStartTime = intStartTime;
	}
	

	
	
	
	

}
