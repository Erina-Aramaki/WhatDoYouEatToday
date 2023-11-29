package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.FoodDao;

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
		
//		String source = request.getParameter("source");
//		System.out.println("source=" + source);	
//		request.setAttribute("source", source);
		
		
		
		
//		request.getRequestDispatcher("/WEB-INF/view/foodDetail"+ id +".jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/foodDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addToFavorite = request.getParameter("addToFavorite");
		String removeFavorite = request.getParameter("removeFavorite");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String paraFoodName = request.getParameter("foodName");
		String material = request.getParameter("material");
//		String source = request.getParameter("source");
		
		
		//DB格納するため、food関連のsessionは不要かも？
		HttpSession session = request.getSession();
//		session.setAttribute("foodNum", num);
//		session.setAttribute("foodName", paraFoodName);
//		session.setAttribute("material", material);
//		session.setAttribute("source", source);
		
		String loginId = (String) session.getAttribute("loginId");
		String name = (String) session.getAttribute("name");
//		int foodNum = (int) session.getAttribute("foodNum");
//		String foodName = (String) session.getAttribute("foodName");
		

		
		request.setAttribute("foodNum", num);
		request.setAttribute("foodName", paraFoodName);
		int foodNum = (int) request.getAttribute("foodNum");
		String foodName = (String) request.getAttribute("foodName");
		
		
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			if(addToFavorite != null) {
				dao.addToFavorite(loginId, name, foodNum, foodName, material);
			}
			//後ほど実装
			if(removeFavorite != null) {
				dao.removeFavorite(loginId, name, foodNum, foodName, material);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		doGet(request, response);
		
	}

}
