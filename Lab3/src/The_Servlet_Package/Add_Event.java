package The_Servlet_Package;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_Class.Category;
import Java_Class.Event_Obj;
import Java_Class.Organization_Obj;
import Java_Class.User_Obj;



/**
 * Servlet implementation class Add_Event
 */
@WebServlet(urlPatterns="/Add_Event")
public class Add_Event extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		
		 
		Category[] categories  = Category.values();
		request.setAttribute("categories", categories);
		
		List<User_Obj> user = (List<User_Obj>) getServletContext().getAttribute("user_List");
		request.setAttribute("user", user);
		
		
		List<Organization_Obj> the_Org = (List<Organization_Obj>) getServletContext().getAttribute("org_List");
		request.setAttribute("the_Org", the_Org);
		
		request.getRequestDispatcher("/WEB-INF/Add_Event.jsp").forward(request, response);
	}




	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//The parameter names matches the name attribute in the HTML input elements
				
		
		String description = request.getParameter("description");
		int attendance = Integer.parseInt(request.getParameter("attendance"));
		String newEventName = request.getParameter("name");
		
		
		// person of contact information 
		String personOfContactNum = request.getParameter("user");
		int num = Integer.parseInt(personOfContactNum);
		List<User_Obj> user = (List<User_Obj>) getServletContext().getAttribute("user_List");
		String personOfContact = user.get(num).getUser_Name();
		
		Category category = Category.valueOf(request.getParameter("category"));
				
		//Retrieve list of Quizzes from application scope
		List<Event_Obj> events = (List<Event_Obj>)getServletContext().getAttribute("events");

			     
			     int newId = getNewId(events);
			     
			     
			     // add just the new user name 
			     Event_Obj new_Event_Form = new Event_Obj(newId, newEventName, description, attendance, personOfContact , category);
			     
			     // create a new user 
			     //new User_Obj(personOfContact, 00000, gender, ispresident)
			     
			     events.add(new_Event_Form);
			     
			     response.sendRedirect("Each_Event?id="+newId);
			     
			     
	}
	
	//Make sure the new id is unique among existing quizzes
		public int getNewId(List<Event_Obj> existingEvents){
			
			int newId = existingEvents.size();
			
			HashSet<Integer> existingIds = new HashSet<>();
			
			for(Event_Obj event : existingEvents){
				 
				existingIds.add(event.id);
			}
			while(existingIds.contains(newId)){
				newId++;
			}
			return newId;
		}

	

	

}
