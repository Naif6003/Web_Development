package Java_Class;

public class Event_Obj{

	public int id ;
	public String event_Name;
	public String event_Description;
	public int event_Attendance;
	public String personOfContact;
	


	

	

	public Event_Obj(int id, String event_Name, String event_Description, int event_Attendance, String personOfContact,
			Category organization) {
		
		this.id = id;
		this.event_Name = event_Name;
		this.event_Description = event_Description;
		this.event_Attendance = event_Attendance;
		this.personOfContact = personOfContact;
		this.organization = organization;
	}


	public Event_Obj(int newId, String name, String description, int attendance, User_Obj user_Obj, Category category) {
		
		
		
		
	}


	public String getPersonOfContact() {
		return personOfContact;
	}


	public void setPersonOfContact(String personOfContact) {
		this.personOfContact = personOfContact;
	}


	public Category getOrganization() {
		return organization;
	}


	public void setOrganization(Category organization) {
		this.organization = organization;
	}
	public Category organization;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	public Category getorganization() {
		return organization;
	}
	public void setorganization(Category organization) {
		this.organization = organization;
	}
	
	
	
}

