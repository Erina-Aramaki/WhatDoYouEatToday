package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.WesternDao;
import domain.Western;

/**
 * Servlet implementation class WesternServlet
 */
@WebServlet("/admin/western")
public class WesternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/western.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId1 = request.getParameter("1");
		String strId2 = request.getParameter("2");
		String strId3 = request.getParameter("3");
		String strId4 = request.getParameter("4");
		String strId5 = request.getParameter("5");
		
		String strId = null;
		if(strId1 != null) strId = strId1;
		if(strId2 != null) strId = strId2;
		if(strId3 != null) strId = strId3;
		if(strId4 != null) strId = strId4;
		if(strId5 != null) strId = strId5;

		try {
			WesternDao dao = DaoFactory.createWesternDao();
			Western stapleWestern = dao.select(strId);
			System.out.println("WesternServlet：stapleWestern=" + stapleWestern);
			
			request.setAttribute("stapleWestern", stapleWestern);
			request.getRequestDispatcher("/WEB-INF/view/westernResult.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("WesternServlet：失敗");
			e.printStackTrace();
		}
	}

}
