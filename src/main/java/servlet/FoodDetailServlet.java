package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.FoodDao;
import domain.Food;

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
		
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			List<Food> material = dao.material(num, foodName);
			System.out.println("material=" + material);	
			request.setAttribute("material", material);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		List<Food> howToMake = dao.howToMake(foods);
		
//		String material = request.getParameter("material");
//		System.out.println("material=" + material);	
//		request.setAttribute("material", material);
		
//		String howToMake = request.getParameter("howToMake");
//		System.out.println("howToMake=" + howToMake);	
//		request.setAttribute("howToMake", howToMake);
		
		
		
		
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
		String FoodName = request.getParameter("foodName");
		String material = request.getParameter("material");
		

		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		String name = (String) session.getAttribute("name");

		
		request.setAttribute("foodNum", num);
		request.setAttribute("foodName", FoodName);
		request.setAttribute("material", material);
		
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
