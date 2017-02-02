package Assginment_3;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Assignment_3.ViewUser;

/**
 * Servlet implementation class Users_Info
 */
@WebServlet("/Users_Info")
public class Users_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Date date = new Date();
		request.setAttribute("date", date);
		
		String id = request.getParameter("id");
		int enevt_Id = Integer.parseInt(id);
		
		List<ViewUser> user_List =  (List<ViewUser>) getServletContext().getAttribute("user_List");
		ViewUser the_User_List = user_List.get(enevt_Id);
		
		
		request.setAttribute("the_User_List", the_User_List);
		request.getRequestDispatcher("/WEB-INF/ViewUser.jsp").forward(request, response);
	}

	

}
