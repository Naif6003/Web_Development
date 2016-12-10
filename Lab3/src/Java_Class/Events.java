package Java_Class;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns="/Events", loadOnStartup = 1 )
public class Events extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
	ServletContext appContext = getServletContext();
	
	
	
	User_Obj user_1 = new User_Obj(0,"Naif", 305080742 , "M" , true , true);
	User_Obj user_2 = new User_Obj(1,"Michael", 333444555 , "M" , true , false);
	User_Obj user_3 = new User_Obj(2,"Ann", 663399884 , "F" ,false , true);
	User_Obj user_4 = new User_Obj(3,"Rose", 050505054 , "F", false, false);
	
	List<User_Obj> user_List = new ArrayList<User_Obj>();
	user_List.add(user_1);
	user_List.add(user_2);
	user_List.add(user_3);
	user_List.add(user_4);
	
	user_1.setPassword("1");
	user_2.setPassword("2");
	user_3.setPassword("3");
	user_4.setPassword("4");
	
	
	appContext.setAttribute("user_List", user_List);
	
	
	Category category = null;
	
	Organization_Obj event_Org_1 = new Organization_Obj(0 , "CSULA Athlete Org", category.SPORT , "This organization is based on doing some sports activities and make everyone feels good" , user_1.getUser_Name() , user_3.getUser_Name());
	Organization_Obj event_Org_2 = new Organization_Obj(1 , "The Artist Guild" , category.ART,"This organization is giving students the ability to understand the science behind art" , user_2.getUser_Name(), user_4.getUser_Name());
	Organization_Obj event_Org_3 = new Organization_Obj(2 , "We know Org" ,category.SCIENCE, "This organization is for smart people. You will learn various of great science knowledge.",user_1.getUser_Name(), user_4.getUser_Name());
	Organization_Obj event_Org_4 = new Organization_Obj(3 , "The Woohoo Org" ,category.ENTERTAINMENT, "This organization is based on having fun. You will enjoy your time for sure." ,user_2.getUser_Name() , user_3.getUser_Name());
	
	List<Organization_Obj> org_List = new ArrayList<Organization_Obj>();
	org_List.add(event_Org_1);
	org_List.add(event_Org_2);
	org_List.add(event_Org_3);
	org_List.add(event_Org_4);
	
	
	appContext.setAttribute("org_List", org_List);
	
	
	
	Event_Obj event_1 = new Event_Obj( 0 ,"Soccer",
			"In this event, students would form two teams and play soccer on the university's soccer field.", 20, user_1.getUser_Name(), category.SPORT);
	
	Event_Obj event_2 = new Event_Obj( 1 ,"Drawing", 
			"In this event, student will learn how to draw shapes around the university's main walk",  10, user_2.getUser_Name() , category.ART);
	Event_Obj event_3 = new Event_Obj( 2 ,"Computer", 
			"We Rocks. In this event, student will be sharing knowladge about computer science field.",  15, user_3.getUser_Name(), category.SCIENCE);
	Event_Obj event_4 = new Event_Obj( 3, "Gameing", 
			"Student will paly all the time. All games are allowed in here. Enjoy",  13, user_4.getUser_Name(),category.ENTERTAINMENT);
	

	List<Event_Obj> events = new ArrayList<Event_Obj>();
	events.add(event_1);
	events.add(event_2);
	events.add(event_3);
	events.add(event_4);
	
	
	appContext.setAttribute("events", events);	
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		 
		List<Event_Obj> theEvents = (List<Event_Obj>)getServletContext().getAttribute("events");
		
		Date date = new Date();
		request.setAttribute("date", date);
				
		
		request.setAttribute("theEvents", theEvents);
		request.getRequestDispatcher("/WEB-INF/All_Events.jsp").forward(request, response);;
			
	}


	

}
