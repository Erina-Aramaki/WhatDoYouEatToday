package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChineseDao;
import dao.DaoFactory;
import domain.Chinese;

/**
 * Servlet implementation class ChineseServlet
 */
@WebServlet("/admin/chinese")
public class ChineseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/chinese.jsp").forward(request, response);
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
			ChineseDao dao = DaoFactory.createChineseDao();
			Chinese stapleChinese = dao.select(strId);
			System.out.println("ChineseServlet：stapleChinese=" + stapleChinese);
			request.setAttribute("stapleChinese", stapleChinese);
			request.getRequestDispatcher("/WEB-INF/view/chineseResult.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("ChineseServlet：失敗");
			e.printStackTrace();
		}
		
		
	}

}
