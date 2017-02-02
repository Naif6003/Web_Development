package Assignment_3;

import java.util.Calendar;
import java.util.Date;

public class ViewEvent{


	String event_Name;
	String event_Description;
	Calendar start_Date;
	Calendar end_Date;
	int event_Attendance;
	ViewEventOrganization list_of_Members;
	
	
	
	public ViewEvent(String event_Name, String event_Description,
			int event_Attendance, ViewEventOrganization list_of_Members) {
		super();
		this.event_Name = event_Name;
		this.event_Description = event_Description;
		this.event_Attendance = event_Attendance;
		this.list_of_Members = list_of_Members;
	}

public ViewEvent(){
		
		
	}
	
	public Calendar getStart_Date() {
		return start_Date;
	}
	
	
	public void setStart_Date(Object start_Date) {
		this.start_Date = (Calendar)start_Date;
	}


	public Calendar getEnd_Date() {
		return end_Date;
	}


	public void setEnd_Date(Calendar end_Date) {
		this.end_Date = end_Date;
	}
	
	public String getEvent_Name() {
		return event_Name;
	}
	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}
	public String getEvent_Description() {
		return event_Description;
	}
	public void setEvent_Description(String event_Description) {
		this.event_Description = event_Description;
	}
	
	public int getEvent_Attendance() {
		return event_Attendance;
	}
	public void setEvent_Attendance(int event_Attendance) {
		this.event_Attendance = event_Attendance;
	}
	public ViewEventOrganization getList_of_Members() {
		return list_of_Members;
	}
	public void setList_of_Members(ViewEventOrganization list_of_Members) {
		this.list_of_Members = list_of_Members;
	}
	
	
	
}

