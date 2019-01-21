package controller.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.implement.ManagerAdmin;
import model.DAO.implement.ManagerStudente;
import model.PJO.Studente;

@WebServlet("/EliminaAmministratoreServlet")
public class EliminaAmministratoreServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  public EliminaAmministratoreServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String username = request.getParameter("usernameAdmin");
		Studente s=ManagerStudente.getStudente(username);
		s.setIsAdmin(false);
		
		if(ManagerAdmin.eliminaAdmin(s)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminArea.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
