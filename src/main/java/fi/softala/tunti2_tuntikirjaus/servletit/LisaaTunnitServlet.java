package fi.softala.tunti2_tuntikirjaus.servletit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * 
 * @author Tommi Ilvonen
 * 
 *
 */

public class LisaaTunnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Etunimi = request.getParameter("etunimi");
		String Sukunimi = request.getParameter("sukunimi");
		String strTunnit = request.getParameter("tunnit");
		int Tunnit = new Integer(strTunnit);
		String Kuvaus = request.getParameter("kuvaus");
		
	}

}
