package Assginment_3;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Assignment_3.ViewEvent;
import Assignment_3.ViewUser;

/**
 * Servlet implementation class ViewEachEvent
 */
@WebServlet(urlPatterns = "/ViewEachEvent")
public class ViewEachEvent extends HttpServlet {
	
	
	public static int a = 3;


	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		String id = request.getParameter("id");

		int event_Id = Integer.parseInt(id);

		// (events) the list variable in the (ListEvents) class.
		List<ViewEvent> events = (List<ViewEvent>) getServletContext().getAttribute("events");
		// Passing the Quiz object to the jsp View by using request.setAttribute
		ViewEvent event = events.get(event_Id);
		
		List<ViewUser> user_List = (List<ViewUser>)getServletContext().getAttribute("president_List");
		ViewUser the_user_List = user_List.get(event_Id);
		request.setAttribute("the_user_List", the_user_List);

		
		
		
		request.setAttribute("id", id);
		request.setAttribute("event", event);
		request.getRequestDispatcher("/WEB-INF/ViewEvent.jsp").forward(request, response);
	}

	
}
