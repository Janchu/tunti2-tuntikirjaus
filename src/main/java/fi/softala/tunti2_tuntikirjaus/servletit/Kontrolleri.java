package fi.softala.tunti2_tuntikirjaus.servletit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.tunti2_tuntikirjaus.dao.TunnitDAO;
import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl;

/**
 * 
 * @author Tommi Ilvonen
 * 
 *
 */

public class Kontrolleri extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Tunnit> tunnit = new ArrayList();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		TunnitDAO dao = (TunnitDAO) context.getBean("daoLuokka");
		String Etunimi = request.getParameter("etunimi");
		String Sukunimi = request.getParameter("sukunimi");
		String strTunnit = request.getParameter("tunnit");
		int Tunnit = new Integer(strTunnit);
		String Kuvaus = request.getParameter("kuvaus");
		
		TunnitImpl uusitunti = new TunnitImpl();
		KayttajaImpl kayttaja = new KayttajaImpl();
		

		uusitunti.setKuvaus(Kuvaus);
		uusitunti.setTuntien_maara(Tunnit);
		
		if(Etunimi.equalsIgnoreCase("Niko")) {
			kayttaja.setId(1);
			kayttaja.addTunnit(uusitunti);
		} else if (Etunimi.equalsIgnoreCase("Janne")) {
			kayttaja.setId(2);
			kayttaja.addTunnit(uusitunti);
		} else if (Etunimi.equalsIgnoreCase("Tommi")) {
			kayttaja.setId(3);
			kayttaja.addTunnit(uusitunti);
		} else if (Etunimi.equalsIgnoreCase("Daniel")) {
			kayttaja.setId(4);
			kayttaja.addTunnit(uusitunti);
		} else if (Etunimi.equalsIgnoreCase("Mira")) {
			kayttaja.setId(5);
			kayttaja.addTunnit(uusitunti);
		}else if(Etunimi.equalsIgnoreCase("Testaaja")) {
			kayttaja.setId(6);
			kayttaja.addTunnit(uusitunti);
		}
		
		dao.tallenna(uusitunti);
		doGet(request, response);
		
		
	}

}
