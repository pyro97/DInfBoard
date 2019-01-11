package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerStudente;
import model.PJO.Studente;

@WebServlet("/ModificaProfiloServlet")
public class ModificaProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaProfiloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String preferenza = request.getParameter("preferenza");
		
		Studente s = new Studente(nome,cognome,email,username,password,preferenza);
		if(ManagerStudente.modificaProfilo(s)) {
			request.getSession().setAttribute("studente", s);
			RequestDispatcher dispatcher = request.getRequestDispatcher("userArea.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
