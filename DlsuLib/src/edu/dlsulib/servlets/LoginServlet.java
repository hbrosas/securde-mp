package edu.dlsulib.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.manager.AccountManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter(UserAccount.COLUMN_USERNAME);
		String password = request.getParameter(UserAccount.COLUMN_PASSWORD);		
		int accountId = AccountManager.LoginAccount(user, password);
		if(accountId == 0) {
			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("error");
		} else {			
			System.out.println("Login Successful");
			request.setAttribute("userID", accountId);
			
			String userid = accountId+"";
			
			Cookie usernameCookie = new Cookie("userid", userid);
			usernameCookie.setMaxAge(60*60*24);
			usernameCookie.setHttpOnly(true); 
			response.addCookie(usernameCookie);
			
			// SESSIONS
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			request.getRequestDispatcher("HomeServlet").forward(request, response);
		}
	}

}
