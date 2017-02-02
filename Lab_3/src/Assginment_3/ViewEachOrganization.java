package Assginment_3;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Assignment_3.ViewEventOrganization;
import Assignment_3.ViewUser;


@WebServlet("/ViewEachOrganization")
public class ViewEachOrganization extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date = new Date();
		request.setAttribute("date", date);
		
		
		String id = request.getParameter("id");
		int enevt_Id = Integer.parseInt(id);
		
		// (events) the list variable in the (ListEvents) class.
		List<ViewEventOrganization> list = (List<ViewEventOrganization>) getServletContext().getAttribute("org_List");
		// Passing the Quiz object to the jsp View by using request.setAttribute
		ViewEventOrganization org_list = list.get(enevt_Id);
		
		
		List<ViewUser> president_user_List = (List<ViewUser>) getServletContext().getAttribute("president_List");
		
		ViewUser the_president_user_List = president_user_List.get(enevt_Id);
		
		request.setAttribute("the_president_user_List", the_president_user_List);
		
		
		List<ViewUser> secretary_user_List = (List<ViewUser>) getServletContext().getAttribute("secretary_List");
		ViewUser the_secretary_user_List = secretary_user_List.get(enevt_Id);
		request.setAttribute("the_secretary_user_List", the_secretary_user_List);
		
		request.setAttribute("id", id);
		request.setAttribute("org_List", org_list);
		request.getRequestDispatcher("/WEB-INF/ViewEventOrganization.jsp").forward(request, response);
		
		
	}

}
