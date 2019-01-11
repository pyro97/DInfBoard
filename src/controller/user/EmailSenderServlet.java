package controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.StudenteDao;
import model.PJO.Sender;
import model.PJO.Studente;

@WebServlet("/EmailSenderServlet")
public class EmailSenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailSenderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudenteDao dao = new StudenteDao();
		Sender sender=new Sender();
		String email=request.getParameter("email");
		ArrayList<Studente> user = dao.getAll();
		boolean emailChecked=false;
		
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equals(email))
				emailChecked=true;
		}
		if(emailChecked) {
			String uniqueID=UUID.randomUUID().toString();
			String subject="Password Recovery";
			String message="Hai ricevuto questo messaggio perchè hai effettuato una richiesta per recupero password\n"
					+ "clicca su questo link per andare alla pagina per cambiare password\n"
					+ "http://localhost:8080/DInfBoard/recuperoPassword.jsp?ID="+uniqueID;
			try {
				sender.sendPlainTextEmail(email, subject, message);
				dao.close();
				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}
		else {
			dao.close();
			request.getSession().setAttribute("badEmail", true);
			response.sendRedirect("forgottedPassword.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
