package controller.annuncio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.DAO.implement.ManagerAnnuncio;
import model.PJO.Annuncio;

@WebServlet("/InserisciAnnuncioServlet")
public class InserisciAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InserisciAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		Part filePart = request.getPart("immagine"); 
		String preferenza = request.getParameter("preferenza");
		
	    InputStream fileContent = filePart.getInputStream();
	    File outputFile = new File("/home/antonio/eclipse-workspace/DInfBoard/WebContent/img/annunci/annuncio");
	    outputFile.createNewFile();
	    FileOutputStream out = new FileOutputStream(outputFile,false);
	    int bt = fileContent.read();
	    while(bt!=-1) {
	    	out.write(bt);
	    	bt = fileContent.read();
	    }
	    String username = (String) request.getSession().getAttribute("username");
		Annuncio a = new Annuncio(titolo,descrizione,"img/annunci/annuncio",0,username,true,preferenza);
		boolean flag = ManagerAnnuncio.inserisciAnnuncio(a);
		if(flag) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
