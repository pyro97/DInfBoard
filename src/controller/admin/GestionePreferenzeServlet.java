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


/**
 * Servlet implementation class GestionePreferenzeServlet
 */
@WebServlet("/GestionePreferenzeServlet")
public class GestionePreferenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionePreferenzeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
