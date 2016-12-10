package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.ConnectionUtils;
import Objects.DatabaseConfig;
import Objects.Dishes_Object;
import Objects.Ingredients;


@WebServlet("/Each_Menu")
public class Each_Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if( request.getSession().getAttribute( "userid" ) == null ) {
            response.sendRedirect( "Login" );
            return;
        } 
		
		
		
		String id = request.getParameter("id");
		int the_Id = Integer.parseInt(id);
		
		
		List<Dishes_Object> dishes = new ArrayList<>();
		List<Ingredients> ingredients = new ArrayList<>();
		
		
Connection c = null;
		
		try {

			c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
			
		
			String sql1 = "select dish.dish_id as 'dish_id', dish.dish_name as 'dish_name', dish.menu_id as 'menu_id', ing.ingredient_id as 'ingredient_id', ing.ingredient_name as 'ingredient_name', ing.price , lin.quantity as 'how many'"+
							"from ingredients ing, link_ingredients_dishes lin, dishes dish" +
					      " where ing.ingredient_id = lin.ing_id and dish.dish_id = lin.dishes_id and dish.menu_id = ? order by dish.dish_id ASC";
								
			
			
			
			
			PreparedStatement pstmt = c.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.execute();
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {

				int dish_id      = rs.getInt("dish_id");
				String menu_Name = rs.getString("dish_name");
				int menu_id      = rs.getInt("menu_id");
				
				int ingredient_id      = rs.getInt("ingredient_id");
				String ingredient_name = rs.getString("ingredient_name");
				int price              = rs.getInt("price");
				
				ingredients.add(new Ingredients(ingredient_id, ingredient_name, price));
				dishes.add(new Dishes_Object(dish_id, menu_Name, menu_id));
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

		request.setAttribute("ingredients", ingredients);
		request.setAttribute("dishes", dishes);
		request.setAttribute("the_Id", the_Id);
		
		
		request.getRequestDispatcher("/WEB-INF/Each_Menu.jsp").forward(request, response);
		
	}
		
		}	

