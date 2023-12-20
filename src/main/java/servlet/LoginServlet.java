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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		
		//バリデーション
		//エラーメッセージ
		
		//DAOを使用し、ID,PASSチェック
		Admin admin = null;
		try {
			AdminDao dao = DaoFactory.createAdminDao();
			admin = dao.findByLoginIdAndLoginPass(loginId, loginPass);
			System.out.println("LoginServlet1：" + admin);
			
		} catch (Exception e) {
			System.out.println("LoginServlet2：失敗");
			e.printStackTrace();
		}
		
		if(admin == null) {
			System.out.println("LoginServlet3：adminが空");
			//エラーメッセージ、JSTLで後ほど実装
			
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("admin", admin);
		
		//不要 
		session.setAttribute("name", admin.getName());
		session.setAttribute("loginId", admin.getLoginId());
		session.setAttribute("loginPass", admin.getLoginPass());
		session.setAttribute("email", admin.getEmail());
		
		response.sendRedirect(request.getContextPath() + "/admin/mypage");
		return;
	
	}

}
