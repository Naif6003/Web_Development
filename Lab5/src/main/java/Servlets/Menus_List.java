package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.ConnectionUtils;
import Objects.DatabaseConfig;
import Objects.Menus_Object;
import Objects.Users;


@WebServlet(urlPatterns="/Menus_List" , loadOnStartup = 1)
public class Menus_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
		
		
		
	ServletContext appContext = getServletContext();
		
		//load driver
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					
				} catch (ClassNotFoundException e) {
					
					throw new ServletException(e);
					
				}
				
				
				
				List<Users> users = new ArrayList<>();
				
				Users user1 = new Users(1, "1", "Naif", true);
				Users user2 = new Users(2, "2", "David", false);
				Users user3 = new Users(3, "3", "Yousp", true);
				
				users.add(user1);
				users.add(user2);
				users.add(user3);
				
				
				appContext.setAttribute("users", users);
					
					
					
					
		
	}
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

				request.setAttribute("menus", menus);
				request.getRequestDispatcher("/WEB-INF/Menus_List.jsp").forward(request, response);
		
	}
	

}
