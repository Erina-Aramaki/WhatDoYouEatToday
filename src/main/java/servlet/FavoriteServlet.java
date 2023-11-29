package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.FoodDao;
import domain.Food;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/admin/favorite")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FoodDetailServletで設定したsessionからnum、numをgetする→DBから取得するから不要？？
//		HttpSession session = request.getSession();
//		request.setAttribute("num", session.getAttribute("foodNum"));
//		request.setAttribute("foodName", session.getAttribute("foodName"));
		
		
//		DBから取得する　→参照するだけだからcheckFavorite()の引数不要？
//		HttpSession session = request.getSession();
//		String loginId = (String) session.getAttribute("loginId");
//		String name = (String) session.getAttribute("name");

		Food food = new Food();
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			
			//重複を削除
			dao.checkDuplicate();
			
			
			List<Food> foods = dao.checkFavorite();
			request.setAttribute("foods", foods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("num", food.getNum());
		request.setAttribute("foodName", food.getName());
		
		
		request.getRequestDispatcher("/WEB-INF/view/favorite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FoodDetailServletで設定したsessionからnum、foodName、material、sourceをgetする→DBから取得するから不要？？
//		HttpSession session = request.getSession();
//		request.setAttribute("num", session.getAttribute("foodNum"));
//		request.setAttribute("foodName", session.getAttribute("foodName"));
//		request.setAttribute("material", session.getAttribute("material"));
//		request.setAttribute("source", session.getAttribute("source"));
		
//		DBから取得する
		
		String num = request.getParameter("num");
		String foodName = request.getParameter("foodName");
//		String material = request.getParameter("material");
		
		request.setAttribute("num", num);
		request.setAttribute("foodName", foodName);
//		request.setAttribute("material", material);

		System.out.println(foodName);
		
		request.getRequestDispatcher("/WEB-INF/view/foodDetail.jsp").forward(request, response);
	}

}
