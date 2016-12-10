package The_Servlet_Package;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_Class.Category;
import Java_Class.Event_Obj;
import Java_Class.Organization_Obj;


@WebServlet(urlPatterns="/Edit_Events")
public class Edit_Events extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private boolean isUserAdmin(HttpServletRequest request){
		return (Boolean) request.getSession().getAttribute("isAdmin");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		 
		 
		 if(!isUserAdmin(request)){
	        	response.sendRedirect("Error?message=Unauthorized");
	        	return;
	        }
		
		String id = request.getParameter("id");
		
		int event_Id = Integer.parseInt(id);
		
		List<Event_Obj> the_Event = (List<Event_Obj>) getServletContext().getAttribute("events");
		
		Category[] categories  = Category.values();
		request.setAttribute("categories", categories);
		
		// pass the organization list to show the list of orgs for the check list
		List<Organization_Obj> the_Org = (List<Organization_Obj>) getServletContext().getAttribute("org_List");
		request.setAttribute("the_Org", the_Org);
		
		
		boolean foundEvent=false;
		
		for (Event_Obj event : the_Event) {
			if (event.id == event_Id) {
				
				request.setAttribute("event", event);
				
				request.getRequestDispatcher("/WEB-INF/Edit_Events.jsp").forward(request, response);
				foundEvent = true;
				break;
			}
		}

		if (!foundEvent) {
			// Redirect to error page with error message
			response.sendRedirect("Error?message=" + URLEncoder.encode("Event does not exist", "UTF-8"));
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String description = request.getParameter("description");
		int attendance = Integer.parseInt(request.getParameter("attendance"));
		String name = request.getParameter("name");
		//String president = req.getParameter("president");
		Category category = Category.valueOf(request.getParameter("category"));
		
		
		List<Event_Obj> events = (List<Event_Obj>)getServletContext().getAttribute("events");
		
	     //id was passed through hidden form input field
	     int newId = Integer.parseInt(request.getParameter("id"));
	     
	  // person of contact information 
			String personOfContact = request.getParameter("personOfContact");
//			String cinNum = request.getParameter("cin");
//			int personCIN = Integer.parseInt("cinNum");
			String gender = request.getParameter("gender");
			String isPresident = request.getParameter("isPresident");
			boolean ispresident = Boolean.parseBoolean("isPresident");
	    
	     
	     //Created quiz Object from submitted form data
		Event_Obj newEventObj = new Event_Obj(newId, name, description, attendance, personOfContact, category);
	     
		
		boolean foundEvent = false;
		
		for(Event_Obj eventToEdit : events){
			if(eventToEdit.id == newEventObj.id){
				
				//Editing existing fields
				eventToEdit.id = newEventObj.id;
				eventToEdit.event_Name = newEventObj.event_Name;
				eventToEdit.event_Description = newEventObj.event_Description;
				eventToEdit.event_Attendance = newEventObj.event_Attendance;
				eventToEdit.organization = newEventObj.organization;
				response.sendRedirect("Each_Event?id="+newId);
				foundEvent = true;
				break;
			}
		}
		
		if(!foundEvent){
			//Redirect to error page with error message
			response.sendRedirect("Error?message="+URLEncoder.encode("Event does not exist", "UTF-8"));
		}

		
		
		
	}

}
