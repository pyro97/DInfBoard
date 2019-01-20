package controller.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.AnnuncioDao;
import model.DAO.StudenteDao;
import model.DAO.implement.ManagerAnnuncio;
import model.PJO.Annuncio;
import model.PJO.Studente;

@WebServlet("/PartecipazioneServlet")
public class PartecipazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PartecipazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_annuncio = Integer.parseInt(request.getParameter("ID_Annuncio"));
		String username = (String) request.getSession().getAttribute("username");
		AnnuncioDao adao = new AnnuncioDao();
		StudenteDao sdao = new StudenteDao();
		Annuncio a = adao.get(id_annuncio);
		Studente s = sdao.get(username);
		adao.close();
		sdao.close();
		boolean flag = ManagerAnnuncio.aggiungiPartecipazione(s, a);
		if(flag) {
			response.sendRedirect("userArea.jsp");
		}
		else {
			request.getSession().setAttribute("notPartecipate", true);
			response.sendRedirect("annuncio.jsp?ID="+id_annuncio);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
