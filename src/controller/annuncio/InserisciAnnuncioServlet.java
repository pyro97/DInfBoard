package controller.annuncio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		int id=0;

	    /*Utilizzo l'oggetto bacheca inserito nel contesto per ottenere l'id da attribuire al nuovo annuncio da 
	     * inserire all'interno della bacheca DInfBoard
	     */
	    
	    ServletContext ctx = getServletContext();
	    ArrayList<Annuncio> bacheca = (ArrayList<Annuncio>) ctx.getAttribute("bacheca");
		if(bacheca==null) {
			bacheca = ManagerAnnuncio.ottieniBacheca();
			if(bacheca==null)
				response.sendRedirect("error.jsp");
			else {
				ctx.setAttribute("bacheca", bacheca);
				if(bacheca.size()==0)
					id=1;
				else
					id=bacheca.get(bacheca.size()-1).getID()+1; //prendo l'id dell'ultimo annuncio in bacheca e ci aggiungo 1
			}
		}
		else {
			if(bacheca.size()==0)
				id=1;
			else
				id=bacheca.get(bacheca.size()-1).getID()+1; 
		}
		
		/*
		 * Una volta ottenuto l'id creo il nuovo oggetto annuncio e lo inserisco all'interno della bacheca tramite 
		 * il metodo inserisciAnnuncio(a)
		 */
		
		
	    InputStream fileContent = filePart.getInputStream();
	    
	    String path="/home/antonio/eclipse-workspace/DInfBoard/WebContent/img/annunci/"+id + ".png";
	    File outputFile = new File(path);
	    outputFile.createNewFile();
	    FileOutputStream out = new FileOutputStream(outputFile,false);
	    int bt = fileContent.read();
	    while(bt!=-1) {
	    	out.write(bt);
	    	bt = fileContent.read();
	    }
	    
	    String username = (String) request.getSession().getAttribute("username");
	    
	    String path_per_annuncio = "img/annunci/"+id + ".png";
	    
		Annuncio a = new Annuncio(id,titolo,descrizione,path_per_annuncio,0,username,true,preferenza);
		ctx.setAttribute("bacheca", bacheca);
		
		boolean flag = ManagerAnnuncio.inserisciAnnuncio(a);
		if(flag) {
			bacheca.add(a);
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
