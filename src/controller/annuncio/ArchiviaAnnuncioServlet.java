package controller.annuncio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.AnnuncioDao;
import model.PJO.Annuncio;
import model.PJO.Sender;
import model.PJO.Studente;
import model.DAO.implement.*;

@WebServlet("/ArchiviaAnnuncioServlet")
public class ArchiviaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArchiviaAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("ID"));
		AnnuncioDao dao = new AnnuncioDao();
		Annuncio a = dao.get(id);
		ManagerAnnuncio.annuncioNonVisibile(a);
		
		ArrayList<Studente> elenco = dao.getPartecipanti(a);
		String subject = "Corso iniziato !";
		String message = "Stai ricevendo questa mail perchè il corso " + a.getTitolo() + " è appena cominciato. Lo staff ti augura buon lavoro !";
		try {
			for(int i=0;i<elenco.size();i++) {
				Sender.sendPlainTextEmail(elenco.get(i).getEmail(), subject, message);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ServletContext ctx = getServletContext();
		
		ArrayList<Annuncio> bacheca = ManagerAnnuncio.ottieniBacheca();
		if(bacheca==null)
			response.sendRedirect("error.jsp");
		else {
			ctx.setAttribute("bacheca", bacheca);
		}
		response.sendRedirect("userArea.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
