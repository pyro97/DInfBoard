package controller.user;

import model.*;
import model.DAO.StudenteDao;
import model.PJO.Studente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudenteDao dao=new StudenteDao();
		String username = (String) request.getSession().getAttribute("username");
		Studente s = dao.get(username);
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		if(password1.equals(password2)) {
			s.setPassword(password1);
			dao.update(s);
			dao.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("passwordChanged.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.getSession().setAttribute("missmatch", true);
			response.sendRedirect("recuperoPassword.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
