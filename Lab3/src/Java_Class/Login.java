package Java_Class;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_Class.User_Obj;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// what is message ... i still have to work on it. 
		String message = request.getParameter("message");
		
		if(message != null){
			request.setAttribute("message", message);
		}
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
	//int the_Password = Integer.parseInt(password);
		
		List<User_Obj> users = (List<User_Obj>) getServletContext().getAttribute("user_List");
		
		boolean foundUser = false;
		
		for(User_Obj user : users){
			if(user.getUser_Name().equals(username) && user.password.equals(password)){
				foundUser=true;
				//store userid and username in session for future lookup
	            request.getSession().setAttribute( "user_Id", user.user_Id);
	            request.getSession().setAttribute("username", user.getUser_Name());
	            request.getSession().setAttribute("isAdmin", user.getIsAdmin());
	            response.sendRedirect("Events");
	            return;
			}
		}
		if(!foundUser){
			//User not found
			response.sendRedirect("Login?message=username%20and%20password%20combination%20not%20found");
		}
	}

}
