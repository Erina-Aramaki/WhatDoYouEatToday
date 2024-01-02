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
			
		
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			
			
			List<Food> foods = dao.checkFavorite(loginId);
			request.setAttribute("foods", foods);
			
			System.out.println("foods=" + foods);
			
			
			//URLバリデーション
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/favorite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

	}

}
