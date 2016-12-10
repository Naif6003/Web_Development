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


@WebServlet("/Add_Organization")
public class Add_Organization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getSession().getAttribute( "user_Id" ) == null ) {
            response.sendRedirect( "Login" );
            return;
        }
		
		List<User_Obj> user = (List<User_Obj>) getServletContext().getAttribute("user_List");
		request.setAttribute("user", user);
		
		Category[] categories  = Category.values();
		request.setAttribute("categories", categories);
		
		
		request.getRequestDispatcher("/WEB-INF/Add_Organization.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// getting the infromation from the form 
				String newOrgName = request.getParameter("name");
				String description = request.getParameter("description");
				int attendance = Integer.parseInt(request.getParameter("attendance"));
		
		// person of contact information from matching the id number
				String personOfContactNum = request.getParameter("user");
				int num = Integer.parseInt(personOfContactNum);
				List<User_Obj> user = (List<User_Obj>) getServletContext().getAttribute("user_List");
				String personOfContact = user.get(num).getUser_Name();
		
		// get the secretary 
				String secretaryContactNum = request.getParameter("user1");
				int num1 = Integer.parseInt(personOfContactNum);
				List<User_Obj> user1 = (List<User_Obj>) getServletContext().getAttribute("user_List");
				String secretary = user.get(num).getUser_Name();
				
				
				
		
				Category category = Category.valueOf(request.getParameter("category"));
	
		//Retrieve list of Quizzes from application scope
				List<Organization_Obj> orgs = (List<Organization_Obj>)getServletContext().getAttribute("org_List");
				
		// assigning a new id for the new org
				int newId = getNewId(orgs);
				
				
				Organization_Obj newOrg = new Organization_Obj(newId, newOrgName, category, description, personOfContact, secretary);
				
				
				orgs.add(newOrg);
				
				response.sendRedirect("Events");
				
	}

	
	//Make sure the new id is unique among existing quizzes
			public int getNewId(List<Organization_Obj> existingOrgs){
				
				int newId = existingOrgs.size();
				
				HashSet<Integer> existingIds = new HashSet<>();
				
				for(Organization_Obj org : existingOrgs){
					 
					existingIds.add(org.id);
				}
				while(existingIds.contains(newId)){
					newId++;
				}
				return newId;
			}
	
	
	
	
	
	
	
	
	
	
}