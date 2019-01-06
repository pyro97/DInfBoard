package controller.annuncio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerAnnuncio;
import model.PJO.Annuncio;

@WebServlet("/RicercaAnnuncioServlet")
public class RicercaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RicercaAnnuncioServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		
		ArrayList<Annuncio> bacheca = (ArrayList<Annuncio>) ctx.getAttribute("bacheca");
		if(bacheca==null) {
			bacheca = ManagerAnnuncio.ottieniBacheca();
			if(bacheca==null)
				response.sendRedirect("error.jsp");
			else {
				ctx.setAttribute("bacheca", bacheca);
				response.sendRedirect("ricercaAnnuncio.jsp");
			}
		}
		else {
			response.sendRedirect("ricercaAnnuncio.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
