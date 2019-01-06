package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerAdmin;
import model.DAO.implement.ManagerAnnuncio;
import model.PJO.Annuncio;

@WebServlet("/EliminaAnnuncioAdminServlet")
public class EliminaAnnuncioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminaAnnuncioAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= (int) request.getAttribute("idAnnuncio");
		if(ManagerAdmin.eliminaAnnuncioAdmin(id)) {
			
			ServletContext ctx = getServletContext();
			ArrayList<Annuncio> bacheca = ManagerAnnuncio.ottieniBacheca();
			if(bacheca==null)
				response.sendRedirect("error.jsp");
			else {
				ctx.setAttribute("bacheca", bacheca);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminArea.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		else {
			response.sendRedirect("error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
