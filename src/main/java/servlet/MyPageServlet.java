package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/admin/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		request.setAttribute("name", admin.getName());
		System.out.println("MyPageServlet1：" + admin.getName());
		
		request.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(request, response);
	}
}