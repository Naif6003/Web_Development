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
import Java_Class.User_Obj;


@WebServlet("/Edit_Org")
public class Edit_Org extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 if( request.getSession().getAttribute( "user_Id" ) == null ) {
	            response.sendRedirect( "Login" );
	            return;
	        }
		
		
		String id = request.getParameter("id");
		
		int org_Id = Integer.parseInt(id);
		
		List<Organization_Obj> the_Org = (List<Organization_Obj>) getServletContext().getAttribute("org_List");
		
		Category[] categories  = Category.values();
		request.setAttribute("categories", categories);
		
		
		
		boolean foundOrg=false;
		
		for (Organization_Obj organization : the_Org) {
			if ((organization.id) == org_Id) {
				// Passing the Quiz object to the jsp View by using
				// request.setAttribute
				request.setAttribute("organization", organization);
				// Forwarding the request to the view jsp. Quiz.jsp is under
				// WebContent/WEB-INF. In general, put your jsp views in there
				request.getRequestDispatcher("/WEB-INF/Edit_Org.jsp").forward(request, response);
				foundOrg = true;
				break;
			}
		}

		if (!foundOrg) {
			// Redirect to error page with error message
			response.sendRedirect("Error?message=" + URLEncoder.encode("Event does not exist", "UTF-8"));
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// editing the do post for the organizations
		
		
		String description = request.getParameter("description");
		String name = request.getParameter("name");

		
		
		List<Organization_Obj> the_Org = (List<Organization_Obj>)getServletContext().getAttribute("org_List");

	     //id was passed through hidden form input field
	     int newId = Integer.parseInt(request.getParameter("id"));
	     Organization_Obj newOrg = the_Org.get(newId);
	     
	      
	     
	     Organization_Obj theNewOrg = new Organization_Obj(newId, name, newOrg.getOrg_Type(), description, newOrg.getOrg_President() , newOrg.getOrg_Secrtary());
	     
	     
	     boolean foundOrg = false;
			
			for(Organization_Obj OrgToEdit : the_Org){
				if(OrgToEdit.id == theNewOrg.id){
					
					//Editing existing fields
					OrgToEdit.id = theNewOrg.id;
					OrgToEdit.setOrg_Name(name);
					OrgToEdit.setOrg_Description(description);
					response.sendRedirect("Each_Organization?id="+ newId);
					foundOrg = true;
					break;
				}
			}
			
			if(!foundOrg){
				//Redirect to error page with error message
				response.sendRedirect("Error?message="+URLEncoder.encode("Event does not exist", "UTF-8"));
			}

	     
	     
		
	}

}
