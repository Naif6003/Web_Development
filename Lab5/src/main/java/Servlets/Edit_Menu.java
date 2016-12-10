package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.ConnectionUtils;
import Objects.DatabaseConfig;
import Objects.Menus_Object;


@WebServlet("/Edit_Menu")
public class Edit_Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if( request.getSession().getAttribute( "userid" ) == null ) {
            response.sendRedirect( "Login" );
            return;
        } 
		
		
			Connection c = null;
		
		List<Menus_Object> menus = new ArrayList<>();
		
		try {

			c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
			
			Statement stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from menus");
			
			while (rs.next()) {

				int menu_id = rs.getInt("id");
				String menu_Name = rs.getString("name");
				String menu_Description = rs.getString("description");
				
				menus.add(new Menus_Object(menu_id, menu_Name, menu_Description));
			}
	}catch (SQLException e) {
		// Escalate to Server error
		throw new ServletException(e);
	}
	
		// Always close connections, no matter what happened
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		
		String id = request.getParameter("id");
		int menu_id = Integer.parseInt(id);
		
		System.out.println(menu_id);
		
		Menus_Object menu = menus.get(menu_id - 1);
		
		
		
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("/WEB-INF/Edit_Menu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String description = request.getParameter("description");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int menuId = Integer.parseInt(id);

		Connection c = null;
		
		List<Menus_Object> menus = new ArrayList<>();
		
		try {

			c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
			
			Statement stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from menus");
			
			while (rs.next()) {

				int menu_id = rs.getInt("id");
				String menu_Name = rs.getString("name");
				String menu_Description = rs.getString("description");
				
				menus.add(new Menus_Object(menu_id, menu_Name, menu_Description));
				
			}
			
			Menus_Object menu = menus.get(menuId);
			
			menu.setMenu_name(name);
			menu.setMenu_description(description);
			
			response.sendRedirect("Menus_List");
			
	}catch (SQLException e) {
		// Escalate to Server error
		throw new ServletException(e);
	}
	
		// Always close connections, no matter what happened
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

	

	}

}
