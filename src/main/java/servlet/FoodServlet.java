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
 * Servlet implementation class allFood
 */
@WebServlet("/admin/food")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			FoodDao dao = DaoFactory.createFoodDao();
			List<Food> foods = dao.findAll();
			
//			request.setAttribute("foods", foods);
			HttpSession session = request.getSession();
			session.setAttribute("foods", foods);
			System.out.println("FoodServlet："+ foods);
			
		} catch (Exception e) {
			System.out.println("FoodServlet１：失敗");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/food.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		
	}

}
