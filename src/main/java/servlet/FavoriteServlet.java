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
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/admin/favorite")
//Post→Getのためこのサーブレットで起動不可
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

//		Food food = new Food();
		
		
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			
			//重複チェック
//			dao.checkDuplicate();
			
			List<Food> foods = dao.checkFavorite(loginId);
			request.setAttribute("foods", foods);
			
			System.out.println("foods=" + foods);
			
			
			//URLバリデーション
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		request.setAttribute("num", food.getNum());
//		request.setAttribute("foodName", food.getName());
		
//		System.out.println("FavoriteServlet_food.getNum()=" + food.getNum());
		
		
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
		

		
//		if(request.getParameter("num") = null) {
//			HttpSession session = request.getSession();
//			String loginId = (String) session.getAttribute("loginId");
//			FoodDao dao = DaoFactory.createFoodDao();
//			List<Food> foods = dao.checkFavorite(loginId);
//			System.out.println(foods.get(1).getId());
//		}
		
		
//		DBから取得する
		System.out.println("FavoriteServlet：request.getParameter(\"num\")=" + request.getParameter("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		String foodName = request.getParameter("foodName");
//		String material = request.getParameter("material");
		
		request.setAttribute("num", num);
		request.setAttribute("foodName", foodName);
//		request.setAttribute("material", material);

		FoodDao dao = DaoFactory.createFoodDao();
		try {
			List<Food> material = dao.material(num, foodName);
			List<Food> howToMake = dao.howToMake(num, foodName, material);
			request.setAttribute("Foods_material", material);
			request.setAttribute("Foods_howToMake", howToMake);
			
			System.out.println("material=" + material);
			System.out.println("howToMake=" + howToMake);
			
			
			//URLバリデーション
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("num=" + num);
		System.out.println("foodName=" + foodName);
		
		
		request.getRequestDispatcher("/WEB-INF/view/foodDetail.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/admin/foodDetail");
//		return;
	}

}
