package The_Servlet_Package;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_Class.Event_Obj;
import Java_Class.Organization_Obj;
import Java_Class.User_Obj;


/**
 * Servlet implementation class ViewEachEvent
 */
@WebServlet(urlPatterns = "/Each_Event")
public class Each_Event extends HttpServlet {
	
	
	public static int a = 3;


	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		 
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		String event_Id = request.getParameter("id");
		int id = Integer.parseInt(event_Id);
		
		// (events) the list variable in the (ListEvents) class.
		List<Event_Obj> events = (List<Event_Obj>)getServletContext().getAttribute("events");
		
		

		boolean foundEvent = false;

		for (Event_Obj event : events) {
			if (event.id == id) {
				
				request.setAttribute("id", id);
				request.setAttribute("event", event);
				request.getRequestDispatcher("/WEB-INF/Event_Details.jsp").forward(request, response);
				foundEvent = true;
				break;
			}
		
		}
		if (!foundEvent) {
			// Redirect to error page with error message
			response.sendRedirect("Error?message=" + URLEncoder.encode("Event does not exist", "UTF-8"));
		}
		
	}

	
}
