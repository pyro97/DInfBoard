package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerStudente;
import model.PJO.PasswordUtils;
import model.PJO.Studente;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Studente s = ManagerStudente.login(username,password);
		if(s==null) {
			request.getSession().setAttribute("not-logged",true);
			response.sendRedirect("login.jsp");
		}
		else if(s.isIsSospeso()) {
			request.getSession().setAttribute("sospeso",true);
			response.sendRedirect("login.jsp");
		}
		else {
			request.getSession().setAttribute("auth", true);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("utente", s);
			dispatcher = request.getRequestDispatcher("userArea.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
