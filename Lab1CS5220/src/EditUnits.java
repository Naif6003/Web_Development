

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditUnits")
public class EditUnits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Units> units = (List<Units>)getServletContext().getAttribute("listOfUnits");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Units editThisUnit = units.get(id - 1);
		
		request.setAttribute("editThisUnit", editThisUnit);
		
		request.getRequestDispatcher("/WEB-INF/editUnit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String unit = request.getParameter("unit1");
		int quantity = Integer.getInteger(request.getParameter("quantity"));
		
		
		
	}

}
