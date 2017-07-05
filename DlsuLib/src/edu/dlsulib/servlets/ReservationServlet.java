package edu.dlsulib.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.resolver.CatalogManager;

import edu.dlsulib.beans.BorrowHistory;
import edu.dlsulib.beans.Catalog;
import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.manager.AccountManager;
import edu.dlsulib.manager.BorrowManager;
import edu.dlsulib.manager.CatalogsManager;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
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
		ArrayList<Catalog> reservedCatalogs = new ArrayList<Catalog>();
		int accountid = Integer.parseInt(request.getParameter("accountid"));
		UserAccount account = AccountManager.GetAccountDetails(accountid);
		int role = account.getRoleId();
		
		String borrowids = request.getParameter("borrowedIDs");
		System.out.println(borrowids);
		String[] splited = borrowids.split("\\s+");
		
		for(int i = 0; i < splited.length; i++) {
			int catalogid = Integer.parseInt(splited[i]);
			reservedCatalogs.add(CatalogsManager.GetCatalog(catalogid));
		}
		
		request.setAttribute("reservedCatalogs", reservedCatalogs);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
//	System.out.println(request.getParameter("accountid"));
//	BorrowHistory borrow = new BorrowHistory();
//	
//	// catalogID, statusId, accountID, dateBorrowed, ExpectReturn, Return
//	borrow.setCatalogId(catalogid);
//	borrow.setAccountId(accountid);
//	borrow.setStatusId(0);
//	
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	Date date = new Date();
//	String dateBorrowed = sdf.format(date);
//	Calendar c = Calendar.getInstance();
//	c.setTime(date);
//	if(role == 1) {
//		// STUDENT
//		c.add(Calendar.DATE, 7);
//	} else if(role == 5) {
//		// EMPLOYEE
//		c.add(Calendar.DATE, 30);
//	}
//	date = c.getTime();
//	String dateExpectReturn = sdf.format(date);
//	
//	borrow.setDateBorrowed(dateBorrowed);
//	borrow.setDateExpectReturn(dateExpectReturn);
//	int borrowid = BorrowManager.Borrow(borrow);
//	System.out.println(borrowid);

}
