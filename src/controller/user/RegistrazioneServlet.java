package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.StudenteDao;
import model.DAO.implement.StudenteDaoImplement;
import model.PJO.Studente;

import javax.crypto.*;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		int id = 1;
		Studente s = new Studente(id,nome,cognome,email,username,password);
		StudenteDao sdao = new StudenteDaoImplement();
		boolean result = sdao.registrazione(s);
		if(result) {
			request.getSession().setAttribute("username", s.getUsername());
			response.sendRedirect("success.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
