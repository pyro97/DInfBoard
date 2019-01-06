package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.PreferenzaDao;
import model.PJO.Preferenza;


@WebServlet("/GestionePreferenzeServlet")
public class GestionePreferenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestionePreferenzeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		String nome= request.getParameter("nome");

		String preferenza=(String) request.getSession().getAttribute("pref");

		
		if(preferenza.equalsIgnoreCase("elimina")) {
			PreferenzaDao p=new PreferenzaDao();
			p.remove(id);
		}
		else if(preferenza.equalsIgnoreCase("aggiungi")) {
			PreferenzaDao p=new PreferenzaDao();
			Preferenza nuova=new Preferenza(id,nome);
			p.add(nuova);
		}
		else if(preferenza.equalsIgnoreCase("modifica")) {
			PreferenzaDao p=new PreferenzaDao();
			Preferenza modificata=new Preferenza(id,nome);
			p.update(modificata);
		}
		
		request.getSession().setAttribute("pref"," ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminArea.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
