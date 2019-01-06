package controller.annuncio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.AnnuncioDao;
import model.PJO.Annuncio;
import model.PJO.Sender;
import model.PJO.Studente;

@WebServlet("/EliminaAnnuncioServlet")
public class EliminaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminaAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("ID"));
		AnnuncioDao dao = new AnnuncioDao();
		Annuncio a = dao.get(id);
		ArrayList<Studente> elenco = dao.getPartecipanti(a);
		Sender sender = new Sender();
		String subject = "Valutazione Utente";
		String message = "Stai ricevendo questa mail perchè il corso " + a.getTitolo() + " è terminato, provvedi dunque ad effettuare"
				+ "una valutazione dello studente organizzatore, vai alla pagina della valutazione seguendo questo link : "
				+ "http://localhost:8080/DInfBoard/valutazione.jsp?username="+a.getUsernameOrganizzatore();
		try {
			for(int i=0;i<elenco.size();i++) {
				sender.sendPlainTextEmail(elenco.get(i).getEmail(), subject, message);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		dao.remove(id);
		dao.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
