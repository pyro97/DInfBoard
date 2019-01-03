package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerAdmin;

@WebServlet("/EliminaAnnuncioAdminServlet")
public class EliminaAnnuncioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminaAnnuncioAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= (int) request.getAttribute("idAnnuncio");
		if(ManagerAdmin.eliminaAnnuncioAdmin(id)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("error.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
