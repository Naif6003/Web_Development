package The_Servlet_Package;

import java.io.IOException;
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



@WebServlet("/Each_Organization")
public class Each_Organization extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        } 
		 
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		
		
		String userId = request.getParameter("id");
		int theId = Integer.parseInt(userId);
		
		
		
		List<Event_Obj> events = (List<Event_Obj>) getServletContext().getAttribute("events");
		Event_Obj the_new_Event = events.get(theId);
		
		
		List<Organization_Obj> org = (List<Organization_Obj>) getServletContext().getAttribute("org_List");

		
		List<User_Obj> users = (List<User_Obj>) getServletContext().getAttribute("user_List");
		
		String nameOftheperson = null;
		
		for(int i=0; i<  org.size() ; i++){
		if(org.get(i).getOrg_Type().equals(the_new_Event.organization)){
			
			
			int newId = i;
			Organization_Obj the_org = org.get(newId);
			
			nameOftheperson = the_org.getOrg_President();
			
			request.setAttribute("newId", newId);		
			request.setAttribute("the_org", the_org);
			break;
			
		}
		}
		
		for(int i=0; i< users.size();i++){
			
			if(users.get(i).getUser_Name() == nameOftheperson){
				
				int id = users.get(i).getUser_Id();
				
				request.setAttribute("id", id);
				
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/Organization_Details.jsp").forward(request, response);
		
		
	
		
	}

}
