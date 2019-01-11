package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.StudenteDao;
import model.PJO.Studente;

@WebServlet("/ValutazioneServlet")
public class ValutazioneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    public ValutazioneServlet() {
        super();
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {

    String usernameDaV = (String) request.getSession().getAttribute("utenteDaValutare");
    int val = Integer.parseInt(request.getParameter("valutazione"));

    StudenteDao dao=new StudenteDao();
    Studente s= dao.get(usernameDaV);
    
    int valUtente= s.getValutazione();
    int valFin=0;
    if(valUtente==0)
    	valFin=val;
    else
    	valFin= (val+valUtente) / 2;
    s.setValutazione(valFin);
    dao.update(s);
    dao.close();
    

    response.sendRedirect("index.jsp");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}