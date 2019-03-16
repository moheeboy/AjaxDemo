
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjaxServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		DbConnection conn = new DbConnection();
		System.out.println("-------------------- Backend has been hit ---------------------");
		if(action.equals("login")) {
			System.out.println("in login");
			// get the data			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			// validate the data
			Pattern emailRegEx =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			if((!emailRegEx.matcher(email).matches()) && (password.length()<6 || password.length()>10)) {
				out.print("Error 3");
			}else if(!emailRegEx.matcher(email).matches()) {
				out.print("Error 1");
			}else if(password.length()<6 || password.length()>10) {
				out.print("Error 2");
			}else {
				// data is validated. check for the user in the db
				System.out.println("data has be validated. now checking credentials");
				try {
					if(conn.isValidUser(email, password)) {
						// user is valid user. start the session and return success.
						System.out.println("valid user. now setting session");
						HttpSession session = request.getSession();
						session.setAttribute("jspajax_email", email);
						out.print("Success");
					}else {
						out.print("Error 5");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					out.print("Error 4");
				}
				
			}
			
		}else if(action.equals("register")) {
			// get the data			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			// validate the data
			Pattern emailRegEx =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); 
			if(!emailRegEx.matcher(email).matches()) {
				out.print("Error 3");
			}else if(firstName.length() == 0) {
				out.print("Error 1");
			}else if(lastName.length() == 0) {
				out.print("Error 2");
			}else if(password.length()<6 || password.length()>10) {
				out.print("Error 4");
			}else {
				// data is validated. Enter the data into the db
				try {
					System.out.println("in ajax servlet. before entering into db class.");
					if(conn.registerUser(firstName, lastName, email, password)) {
						// start the session
						System.out.println("registration is done sucessfully");
						HttpSession session = request.getSession();
						session.setAttribute("jspajax_email", email);
						System.out.println("session has been set. before returning sucess.");
						out.print("Success");
					}else {
						System.out.println("in else block");
						out.print("Error 5");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					out.print("Error 5");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
