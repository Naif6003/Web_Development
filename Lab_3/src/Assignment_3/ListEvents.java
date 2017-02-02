package Assignment_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEvent
 */
@WebServlet(urlPatterns="/ListEvents", loadOnStartup = 1 )
public class ListEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
	ServletContext appContext = getServletContext();
	

	
	Calendar start_Date = Calendar.getInstance();
	start_Date.set(2016, 5, 10);
	
	Calendar end_Date = Calendar.getInstance();
	end_Date.set(2016, 5, 15);
	
	
	
	
	
	ViewUser user_1 = new ViewUser("Naif", 305080742 , 'M');
	ViewUser user_2 = new ViewUser("Michael", 305080742 , 'M');
	ViewUser user_3 = new ViewUser("Ann", 305080742 , 'F');
	ViewUser user_4 = new ViewUser("Rose", 305080742 , 'F');
	
	List<ViewUser> user_List = new ArrayList<ViewUser>();
	user_List.add(user_1);
	user_List.add(user_2);
	user_List.add(user_3);
	user_List.add(user_4);
	
	appContext.setAttribute("user_List", user_List);
	
	
	
	ViewUser president_1 = new ViewUser("The President #1", 000000 , 'M');
	ViewUser president_2 = new ViewUser("The President #2", 000000 , 'F');
	ViewUser president_3 = new ViewUser("The President #3", 000000 , 'F');
	ViewUser president_4 = new ViewUser("The President #4", 000000 , 'M');
	
	List<ViewUser> president_List = new ArrayList<ViewUser>();
	president_List.add(president_1);
	president_List.add(president_2);
	president_List.add(president_3);
	president_List.add(president_4);
	
	
	appContext.setAttribute("president_List", president_List);
	
	
	ViewUser secretary_1 = new ViewUser("Secretary #1", 000000 , 'M');
	ViewUser secretary_2 = new ViewUser("Secretary #2", 000000 , 'F');
	ViewUser secretary_3 = new ViewUser("Secretary #3", 000000 , 'F');
	ViewUser secretary_4 = new ViewUser("Secretary #4", 000000 , 'M');
	
	List<ViewUser> secretary_List = new ArrayList<ViewUser>();
	secretary_List.add(secretary_1);
	secretary_List.add(secretary_2);
	secretary_List.add(secretary_3);
	secretary_List.add(secretary_4);
	
	
	appContext.setAttribute("secretary_List", secretary_List);
	
	
	
	ViewEventOrganization event_Org_1 = new ViewEventOrganization("Sport", president_1,secretary_3);
	ViewEventOrganization event_Org_2 = new ViewEventOrganization("Art", president_2, secretary_2);
	ViewEventOrganization event_Org_3 = new ViewEventOrganization("Science", president_3, secretary_4);
	ViewEventOrganization event_Org_4 = new ViewEventOrganization("Sport", president_4 , secretary_1);
	
	List<ViewEventOrganization> org_List = new ArrayList<ViewEventOrganization>();
	org_List.add(event_Org_1);
	org_List.add(event_Org_2);
	org_List.add(event_Org_3);
	org_List.add(event_Org_4);
	
	
	appContext.setAttribute("org_List", org_List);
	
	
	ViewEvent event_1 = new ViewEvent("Soccer", "Playing soccer", 20, event_Org_1);
	ViewEvent event_2 = new ViewEvent("Art", "Drawing something",  20, event_Org_2);
	ViewEvent event_3 = new ViewEvent("Computer", "We Rocks",  20, event_Org_3);
	ViewEvent event_4 = new ViewEvent("Gameing", "Enjoy your time",  20, event_Org_4);
	

	List<ViewEvent> events = new ArrayList<ViewEvent>();
	events.add(event_1);
	events.add(event_2);
	events.add(event_3);
	events.add(event_4);
	
	
	appContext.setAttribute("events", events);	
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<ViewEvent> theEvents = (List<ViewEvent>)getServletContext().getAttribute("events");
		
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		
		
		
		request.setAttribute("theEvents", theEvents);
		request.getRequestDispatcher("/WEB-INF/ListEvents.jsp").forward(request, response);;
			
	}


	

}
