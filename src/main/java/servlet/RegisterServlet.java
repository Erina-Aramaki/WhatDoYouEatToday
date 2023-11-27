package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(loginId);
		System.out.println(loginPass);
		
		//バリデーション
		
		//DB登録
		try {
			AdminDao dao = DaoFactory.createAdminDao();
			dao.insert(new Admin(null, loginId, loginPass, email, name));
		} catch (Exception e) {
			System.out.println("RegisterServlet：DB登録失敗");
			e.printStackTrace();
		}
		
//		HttpSession session = request.getSession();
//		session.setAttribute("name", name);
//		session.setAttribute("email", email);
//		session.setAttribute("loginId", loginId);
//		session.setAttribute("loginPass", loginPass);
		
		response.sendRedirect(request.getContextPath() + "/login");
		return;
	}

}
