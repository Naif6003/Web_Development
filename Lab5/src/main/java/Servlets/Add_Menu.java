package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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


@WebServlet(urlPatterns="/Add_Menu" )
public class Add_Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static int count = 0;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if( request.getSession().getAttribute( "userid" ) == null ) {
            response.sendRedirect( "Login" );
            return;
        }
		
		
		request.getRequestDispatcher("/WEB-INF/AddMenu.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection c = null; 
		
		String menu_name = request.getParameter("name");
		String menu_description = request.getParameter("description");
		
        try {
        	
          //  String sql = "insert into menus (id, name, description) values (?, ?, ?)";

        	String sql = "insert into menus ( name, description) values ( ?, ?)";
        	
    		c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);  
    		
    		PreparedStatement pstmt = c.prepareStatement( sql );
    		
    		
    		getMenu();
    		
          //  pstmt.setInt( 1 , count + 1);
            pstmt.setString( 1, menu_name);
            pstmt.setString( 2, menu_description);

            pstmt.executeUpdate();
          }
         	catch( SQLException e ){
         		
            throw new ServletException( e );
            
         	}
        
        finally{
        	
        		try{
        			
                if( c != null ) c.close();
            }
            
        		catch( SQLException e ){
        			
                throw new ServletException( e );
            }
        }
		
		//Redirect to different url (from the client), notice how this is different from request forward (server side)
		response.sendRedirect("Menus_List");
	}
	
	
	
	public static List<Menus_Object> getMenu(){
		
		Connection c = null;
		
		List<Menus_Object> menus = new ArrayList<>();
		
		try{
			
			
			c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
			
			
		Statement stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from menus");
		
		
		
		while (rs.next()) {
			
			int menu_id = rs.getInt("id");
			String menu_Name = rs.getString("name");
			String menu_Description = rs.getString("description");
			
			menus.add(new Menus_Object(menu_id, menu_Name, menu_Description));
			
		}}catch (Exception e) {
			System.out.println("didn't get menu from DB");
		}
		
		count = menus.size();
		
		
		return menus;
	}
	
	
	
}
