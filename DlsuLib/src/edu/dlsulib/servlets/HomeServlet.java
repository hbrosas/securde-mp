package edu.dlsulib.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dlsulib.beans.*;
import edu.dlsulib.manager.*;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		ArrayList<Catalog> allCatalog = CatalogManager.GetAllCatalogs();
		request.setAttribute("allCatalog", allCatalog);
		
		int accountId = Integer.parseInt(request.getSession().getAttribute("userid").toString());
		UserAccount account = AccountManager.GetAccountDetails(accountId);
		UserProfile profile = ProfileManager.GetProfile(account.getUserId());
		request.setAttribute("account", account);
		request.setAttribute("profile", profile);
		
		// Get Role
		switch(account.getRoleId()) {
		case 1: // student
				request.getRequestDispatcher("list_catalog.jsp").forward(request, response);
				break;
		case 2: // Library Manager
				// dispatch
				break;
		case 3: // Library Staff
				// dispatch
				break;
		case 4: // Administrator
				// dispatch
				break;
		case 5: // Employee
				// dispatch
				break;
		}
	}

}
