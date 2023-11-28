package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodDetailServlet
 */
@WebServlet("/admin/foodDetail")
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strNum = request.getParameter("num");
		System.out.println("strNum=" + strNum);
		int num = (int)Integer.parseInt(strNum);
		System.out.println("num=" + num);	
		request.setAttribute("num", num);
		
		String foodName = request.getParameter("foodName");
		System.out.println("foodName=" + foodName);	
		request.setAttribute("foodName", foodName);
		
		String material = request.getParameter("material");
		System.out.println("material=" + material);	
		request.setAttribute("material", material);
		
		String source = request.getParameter("source");
		System.out.println("source=" + source);	
		request.setAttribute("source", source);
		
		
//		request.getRequestDispatcher("/WEB-INF/view/foodDetail"+ id +".jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/foodDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
