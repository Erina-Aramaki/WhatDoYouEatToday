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
 * Servlet implementation class UserServlet
 */
@WebServlet("/admin/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
//		Admin admin = (Admin)session.getAttribute("admin");
//		
//		request.setAttribute("name", session.getAttribute("name"));
//		request.setAttribute("loginId", session.getAttribute("loginId"));
//		request.setAttribute("loginPass", session.getAttribute("loginPass"));
//		request.setAttribute("email", session.getAttribute("email"));
		
		Admin admin = (Admin)session.getAttribute("admin");
		request.setAttribute("name", admin.getName());
		request.setAttribute("email", admin.getEmail());
		request.setAttribute("loginId", admin.getLoginId());
		request.setAttribute("loginPass", admin.getLoginPass());
		
		System.out.println("MyPageServlet1：" + admin.getName());
		
		request.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
