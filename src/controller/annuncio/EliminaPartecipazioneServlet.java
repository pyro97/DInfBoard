package controller.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.PJO.Annuncio;
import model.PJO.Studente;

@WebServlet("/EliminaPartecipazioneServlet")
public class EliminaPartecipazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminaPartecipazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id_annuncio = Integer.parseInt(request.getParameter("ID"));
		String username = (String) request.getSession().getAttribute("username");
		
		AnnuncioDao adao = new AnnuncioDao();
		StudenteDao sdao= new StudenteDao();
		
		Annuncio a = adao.get(id_annuncio);
		Studente s = sdao.get(username);
		
		adao.removePartecipazione(s,a);
		
		a.setPartecipanti((a.getPartecipanti()-1));
		adao.update(a);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
