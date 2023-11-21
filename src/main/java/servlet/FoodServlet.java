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
			request.setAttribute("foods", foods);
			System.out.println("FoodServlet："+ foods);
			
		} catch (Exception e) {
			System.out.println("FoodServlet１：失敗");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/Food.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String strId = request.getParameter("num");
			System.out.println("strId=" + strId);
			int id = (int)Integer.parseInt(strId);
			System.out.println("id=" + id);
			
			request.getRequestDispatcher("/WEB-INF/view/foodDetail"+ id +".jsp").forward(request, response);
		
	}

}
