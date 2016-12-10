package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.Menus_Object;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if( request.getSession().getAttribute( "userid" ) == null ) {
            response.sendRedirect( "Login" );
            return;
        }
		
		String id = request.getParameter("id");
		int menuId = Integer.parseInt(id);
		
		List<Menus_Object> menus = (List<Menus_Object>) getServletContext().getAttribute("menus");
		
		
		for (Menus_Object menu : menus) {
			if (menu.getMenu_id() == menuId) {
				//Delete quiz from list
				menus.remove(menu);
				response.sendRedirect("Menus_List");
				break;
			}
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
