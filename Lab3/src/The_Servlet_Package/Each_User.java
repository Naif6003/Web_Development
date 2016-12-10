package The_Servlet_Package;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
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
 * Servlet implementation class Users_Info
 */
@WebServlet("/Each_User")
public class Each_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);
		
		List<Event_Obj> events = (List<Event_Obj>) getServletContext().getAttribute("events");
		Event_Obj the_new_Event = events.get(id);
		
		List<User_Obj> users = (List<User_Obj>) getServletContext().getAttribute("user_List");
		
		User_Obj the_User = users.get(id);
	
			
			request.setAttribute("id", id);		
			request.setAttribute("the_User", the_User);
			request.getRequestDispatcher("/WEB-INF/User_Details.jsp").forward(request, response);
		
		
		
	}

}
