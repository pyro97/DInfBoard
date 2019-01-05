package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PJO.PasswordUtils;
import model.PJO.Studente;
import model.DAO.*;
import model.DAO.implement.ManagerStudente;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int preferenza = Integer.parseInt(request.getParameter("preferenza"));
		
		Studente s = new Studente(nome,cognome,email,username,password,preferenza);
		if(ManagerStudente.registrazione(s)) {
			request.getSession().setAttribute("auth", true);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("utente", s);
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.getSession().setAttribute("missed-registration", true);
			response.sendRedirect("error.jsp");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
