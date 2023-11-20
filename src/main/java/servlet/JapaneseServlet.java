package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.JapaneseDao;
import domain.Japanese;

/**
 * Servlet implementation class JapaneseFood
 */
@WebServlet("/admin/japanese")
public class JapaneseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JapaneseDao dao = DaoFactory.createJapaneseDao();
		
		try {
			List<Japanese> japanese = dao.select();
			
			System.out.println("japaneseServlet"+japanese.get(0));
			
			request.setAttribute("japanese", japanese);

			
		request.getRequestDispatcher("/WEB-INF/view/japanese.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
