package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/admin/editUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String loginId;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setAttribute("name", session.getAttribute("name"));
		request.setAttribute("email", session.getAttribute("email"));
		request.setAttribute("loginId", session.getAttribute("loginId"));
		request.setAttribute("loginPass", session.getAttribute("loginPass"));
//		Admin admin = (Admin)session.getAttribute("admin");
//		request.setAttribute("name", admin.getName());
//		request.setAttribute("email", admin.getEmail());
//		request.setAttribute("loginId", admin.getLoginId());
//		request.setAttribute("loginPass", admin.getLoginPass());
		
		loginId = (String) session.getAttribute("loginId");
//		loginId = (String) admin.getLoginId();
		request.getRequestDispatcher("/WEB-INF/view/editUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String loginPass = request.getParameter("loginPass");
		String email = request.getParameter("email");
		System.out.println("EditUserServlet：" + name +"," + loginId +"," + loginPass +"," + email);
		
		try {
			AdminDao dao = DaoFactory.createAdminDao();
			dao.update(new Admin(null, loginId, loginPass, email, name));
//			Admin admin = dao.update(new Admin(null, loginId, loginPass, email, name));
			
			HttpSession session = request.getSession();
//			session.setAttribute("admin", admin);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("loginPass", loginPass); //BCrypt.hashpw、BCrypt.checkpwを確認する
			
		} catch (Exception e) {
			System.out.println("EditUserServlet：失敗");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(request, response);
	}

}
