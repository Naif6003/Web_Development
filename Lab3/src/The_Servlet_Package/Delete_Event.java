package The_Servlet_Package;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_Class.Event_Obj;

@WebServlet(urlPatterns="/Delete_Event")
public class Delete_Event extends HttpServlet {
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
		
		List<Event_Obj> events = (List<Event_Obj>) getServletContext().getAttribute("events");
		
		for (Event_Obj event : events) {
			if (event.id == event_Id) {
				//Delete quiz from list
				events.remove(event);
				response.sendRedirect("Events");
				break;
			}
		}
	}

}
