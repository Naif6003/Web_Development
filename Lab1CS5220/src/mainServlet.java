

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mainServlet")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
	ServletContext appContext = getServletContext();
	
	Units unit11 = new Units(1, 1, "Meter", 3.28084, "foot");
	Units unit12 = new Units(2, 1, "Kilogram", 2.20462,"meter");
	
	List<Units> listOfUnits = new ArrayList<Units>();
	listOfUnits.add(unit11);
	listOfUnits.add(unit12);

	
	appContext.setAttribute("listOfUnits",listOfUnits);
	
	
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<Units> theUnits = (List<Units>)getServletContext().getAttribute("listOfUnits");
		
			
			request.setAttribute("theUnits", theUnits);
			request.setAttribute("id", theUnits.size());
		
			request.getRequestDispatcher("/WEB-INF/theJSP.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		int quantity1 = 1;
		String unit1 = request.getParameter("unit1");
		double quantity2 = Double.parseDouble(request.getParameter("quantity2"));
		String unit2 = request.getParameter("unit2");
		
		int theId = Integer.parseInt(id);
		
		
		List<Units> units = (List<Units>) getServletContext().getAttribute("listOfUnits");
		
		Units newUnit = new Units(theId + 1,quantity1,unit1,quantity2,unit2);
		
		units.add(newUnit);
		response.sendRedirect("mainServlet");
	}

}
