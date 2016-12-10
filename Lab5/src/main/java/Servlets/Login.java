package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.Users;






@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String message = request.getParameter("message");
		
		
		if(message!=null){
			request.setAttribute("message", message);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<Users> users = (List<Users>) getServletContext().getAttribute("users");
		
		
		
		boolean foundUser = false;
		for(Users user : users){
			if(user.user_Name.equals(username) && user.password.equals(password)){
				foundUser=true;
				//store userid and username in session for future lookup
	            request.getSession().setAttribute( "userid", user.user_Id);
	            request.getSession().setAttribute("username", user.user_Name);
	            request.getSession().setAttribute("isAdmin", user.isAdmin);
	            response.sendRedirect("Menus_List");
	            return;
			}
		}
		if(!foundUser){
			//User not found
			System.out.println("user not found");
			response.sendRedirect("Login?message=username%20and%20password%20combination%20not%20found");
		}
	}
		
		
	}
