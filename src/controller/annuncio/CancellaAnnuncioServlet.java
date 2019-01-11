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
import model.DAO.implement.ManagerAnnuncio;
import model.PJO.Annuncio;

@WebServlet("/CancellaAnnuncioServlet")
public class CancellaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancellaAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("ID"));
		AnnuncioDao dao = new AnnuncioDao();
		dao.remove(id);
		
		ServletContext ctx = getServletContext();
		ArrayList<Annuncio> bacheca = ManagerAnnuncio.ottieniBacheca();
		if(bacheca==null)
			response.sendRedirect("error.jsp");
		else {
			ctx.setAttribute("bacheca", bacheca);
		}
		response.sendRedirect("userArea.jsp");
		dao.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
