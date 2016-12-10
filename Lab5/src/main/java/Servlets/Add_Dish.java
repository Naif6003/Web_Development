//package Servlets;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import Objects.ConnectionUtils;
//import Objects.DatabaseConfig;
//import Objects.Ingredients;
//import Objects.Menus_Object;
//
//@WebServlet("/Add_Dish")
//public class Add_Dish extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		if( request.getSession().getAttribute( "userid" ) == null ) {
//            response.sendRedirect( "Login" );
//            return;
//        }
//		
//		Connection c = null;
//		
//		List<Ingredients> ingredients = new ArrayList<>();
//		
//		try {
//
//			c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
//					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
//			
//			Statement stmt = c.createStatement();
//			
//			ResultSet rs = stmt.executeQuery("select * from ingredients;");
//			
//			while (rs.next()) {
//
//				int ing_id = rs.getInt("ingredient_id");
//				String ing_Name = rs.getString("ingredient_name");
//				Double ing_Price = rs.getDouble("price");
//				
//				ingredients.add(new Ingredients(ing_id, ing_Name, ing_Price));
//			}
//	}catch (SQLException e) {
//		// Escalate to Server error
//		throw new ServletException(e);
//	}
//	
//		// Always close connections, no matter what happened
//				finally {
//					try {
//						if (c != null)
//							c.close();
//					} catch (SQLException e) {
//						throw new ServletException(e);
//					}
//				}
//		
//		request.setAttribute("ingredients", ingredients);
//		
//		request.getRequestDispatcher("/WEB-INF/Add_Dish.jsp").forward(request, response);
//		
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
//		Connection c = null; 
//		
//		String dish_name = request.getParameter("name");
//		String ing_name = request.getParameter("ingredient");
//		
//        try {
//        	
//            String sql = "insert into dishes (dish_id, dish_name, menu_id) values (?, ?, ?)";
//
//    		c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
//					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);  
//    		
//    		PreparedStatement pstmt = c.prepareStatement( sql );
//    		
//    		
//            pstmt.setInt( 1 , dish_name);
//            pstmt.setString( 2, ing_name);
//            pstmt.setString( 3, menu_description);
//
//            pstmt.executeUpdate();
//          }
//         	catch( SQLException e ){
//         		
//            throw new ServletException( e );
//            
//         	}
//        
//        finally{
//        	
//        		try{
//        			
//                if( c != null ) c.close();
//            }
//            
//        		catch( SQLException e ){
//        			
//                throw new ServletException( e );
//            }
//        }
//		
//		//Redirect to different url (from the client), notice how this is different from request forward (server side)
//		response.sendRedirect("Menus_List");
//	}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
//}
