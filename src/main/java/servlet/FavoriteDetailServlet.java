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
 * Servlet implementation class FavoriteDetailServlet
 */
@WebServlet("/admin/favoriteDetail")
//使わないため消す
public class FavoriteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doPost→doGetに引っ越し
		String addToFavorite = request.getParameter("addToFavorite");
		String removeFavorite = request.getParameter("removeFavorite");
		
		//URLのnum(get送信)から取得
		int num = Integer.parseInt(request.getParameter("num"));
		String FoodName = request.getParameter("foodName");
		System.out.println("favoriteDetailServlet:doPost_num=" + num);
		System.out.println("favoriteDetailServlet:doPost_foodName=" + FoodName);
		

		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		String name = (String) session.getAttribute("name");
		System.out.println("favoriteDetailServlet:doPost_loginId=" + loginId);
		System.out.println("favoriteDetailServlet:doPost_name=" + name);

		
		request.setAttribute("foodNum", num);
		request.setAttribute("foodName", FoodName);
		
		int foodNum = (int) request.getAttribute("foodNum");
		String foodName = (String) request.getAttribute("foodName");
		
		
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			if(addToFavorite != null) {
				dao.addToFavorite(loginId, name, foodNum, foodName);
				System.out.println("favoriteDetailServlet:addToFavorite実行");
			}
			//後ほど実装
			if(removeFavorite != null) {
				dao.removeFavorite(loginId, foodNum);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/favoriteDetail.jsp").forward(request, response);
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet→doPostに引っ越し
		String strNum = request.getParameter("num");
		System.out.println("favoriteDetailServlet:doGet_strNum=" + strNum);
		int num = (int)Integer.parseInt(strNum);
		System.out.println("favoriteDetailServlet:doGet_num=" + num);	
		request.setAttribute("num", num);
		
		String foodName = request.getParameter("foodName");
		System.out.println("favoriteDetailServlet:doGet_foodName=" + foodName);	
		request.setAttribute("foodName", foodName);
		
		try {
			FoodDao dao = DaoFactory.createFoodDao();
			List<Food> material = dao.material(num, foodName);
			List<Food> howToMake = dao.howToMake(num, foodName, material);
			System.out.println("favoriteDetailServlet:doGet_material=" + material);	
			System.out.println("favoriteDetailServlet:doGet_howToMake=" + howToMake);	
			request.setAttribute("Foods_material", material);
			request.setAttribute("Foods_howToMake", howToMake);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/favoriteDetail.jsp").forward(request, response);
		
	}

}
