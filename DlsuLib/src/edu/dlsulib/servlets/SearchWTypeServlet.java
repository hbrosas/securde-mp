package edu.dlsulib.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dlsulib.beans.Catalog;
import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.beans.UserProfile;
import edu.dlsulib.manager.AccountManager;
import edu.dlsulib.manager.CatalogsManager;
import edu.dlsulib.manager.ProfileManager;

/**
 * Servlet implementation class SearchWTypeServlet
 */
@WebServlet("/SearchWTypeServlet")
public class SearchWTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String by = request.getParameter("by");
		String keyword = request.getParameter("keyword");
		int type = Integer.parseInt(request.getParameter("type"));
		
		ArrayList<Catalog> searchCatalogs = CatalogsManager.SearchCatalog(keyword, by, type);
		request.setAttribute("allCatalog", searchCatalogs);
		
		int accountId = -1;
		String x = "";
		Enumeration<String> attributes = request.getAttributeNames();
		
		while(attributes.hasMoreElements()) {
			if(attributes.nextElement().equalsIgnoreCase("userid"))
				accountId = Integer.parseInt(request.getSession().getAttribute("userid").toString());
			else if(attributes.nextElement().equalsIgnoreCase("imsuchacutie0029"))
				accountId = Integer.parseInt(request.getSession().getAttribute("imsuchacutie0029").toString());
		}
		
		if(accountId == -1) {
			// guest
			UserAccount account = new UserAccount();
			account.setRoleId(6);
		} else {
			UserAccount account = AccountManager.GetAccountDetails(accountId);
			UserProfile profile = ProfileManager.GetProfile(account.getUserId());
			request.setAttribute("account", account);
			request.setAttribute("profile", profile);
		}
		
		request.getRequestDispatcher("list_catalog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
