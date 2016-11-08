package fi.softala.tunti2_tuntikirjaus.controller;


import java.util.ArrayList;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.tunti2_tuntikirjaus.dao.TunnitDAO;
import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl;

@Controller
@RequestMapping(value = "/tunnit")
public class TuntiController {

	// TunnitDAO:n paikallinen tunnitDao-olio	
	@Inject
	private TunnitDAO tunnitDao;
	
	// Logger, jota k‰ytet‰‰n System.outin sijaan
	final static Logger logger = LoggerFactory.getLogger(TuntiController.class);

	// Tuntien listaaminen	
	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		
		// Haetaan kaikki k‰ytt‰j‰t
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao
				.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit(
					(ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat
							.get(i).getId()));
		}
		
		// Haetaan k‰ytt‰j‰n tiedot, jotka Spring Security asetti sessioon, User-olioon
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		// Laitetaan k‰ytt‰j‰n k‰ytt‰j‰nimi Stringiin, joka haetaan aiemmin luodusta User-oliosta
		String kayttajaString = user.getUsername();		
		
		// Luodaan Tunnit-luokalle pohjautuva olio, tunnit
		Tunnit tunnit = new TunnitImpl();
		
		// Vied‰‰n juuri luotu tunnit-olio modeliin, eli paikkaan josta tunnit.jsp voi sit‰ k‰ytt‰‰
		model.addAttribute("tunnit", tunnit);
		
		// Luodaan Kayttaja-luokasta olio kayttaja, joka pohjautuu tunnitDao:ssa olevalle metodille joka hakee yhden k‰ytt‰j‰n
		// K‰ytt‰j‰n tiedot haetaan k‰ytt‰j‰n k‰ytt‰j‰tunnuksen mukaan
		Kayttaja kayttaja = tunnitDao.haeKayttaja(kayttajaString);

		// Vied‰‰n luotu k‰ytt‰j‰olio modeliin
		model.addAttribute("kayttaja", kayttaja);
		
		// Vied‰‰n aivan aluksi luotu kaikki k‰ytt‰j‰t hakenut ArrayList modeliin myˆs
		model.addAttribute("kayttajat", kayttajat);
		
		// Palautetaan tunnit.jsp
		return "tunnit";
	}
	
	// Tuntien lis‰‰minen tietokantaan	 
	@RequestMapping(value = "lista", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "tunnit") @Valid TunnitImpl tunnit,
			BindingResult result) {
		
		
		// Haetaan k‰ytt‰j‰n syˆtt‰m‰ tuntim‰‰r‰
		String strTunnit = tunnit.getTuntien_maara();
		// Erotellaan tunnit ja minuuti toisistaan
		String[] parts = strTunnit.split(":");
		String part2 = parts[1];
		//Tehd‰‰n minuuttien muuttujasta Integer
		int verrattava = new Integer(part2);
		
		// Verrataan minuuttien syˆtt‰m‰‰ aikaa ja pyˆristet‰‰n luku 15 minuutin tarkkuudella
		// Muokataan Stringin mukana tullut : -> .
		if (verrattava < 15 ) {
			strTunnit = strTunnit.replaceAll(":.*", ".00");
		} else if (verrattava >=15 && verrattava < 30) {
			strTunnit = strTunnit.replaceAll(":.*", ".25");
		} else if (verrattava >=30 && verrattava < 45 ) {
			strTunnit = strTunnit.replaceAll(":.*", ".50");
		} else if (verrattava >=45) {
			strTunnit = strTunnit.replaceAll(":.*", ".75");
		}
		// Tallennetaan tunnit olioon
		tunnit.setTuntien_maara(strTunnit);
		
	
	
		// Jos luodussa tuloslistauksessa on virheit‰...
		if (result.hasErrors()) {
			logger.info("T‰‰ll‰ oli erhe");
			
			
			// Palautetaan kontrolleri
			return "tunnit";
			
		// Muuten...
		} else {

			// Luodaan p‰iv‰m‰‰r‰-string listalta tulleesta tunnit-oliosta
			String pvm = tunnit.getPaivamaara();
			
			if (pvm.equalsIgnoreCase("0000-00-00")) {
				String korjattuPvm = "";
				tunnit.setPaivamaara(korjattuPvm);
			}
			
			// N‰ytt‰‰, mik‰ kyseinen p‰iv‰m‰‰r‰ on
			logger.info(tunnit.getPaivamaara() + " <- p‰iv‰m‰‰r‰");
			
			// N‰ytt‰‰ k‰ytt‰j‰n id-luvun
			logger.info("id: " +tunnit.getKayttajaId());
			System.out.println(tunnit.getTuntien_maara());
			
			// Jos k‰ytt‰j‰n id on 6 tai alle ja 1 tai yli...
			if (tunnit.getKayttajaId() <= 6 && tunnit.getKayttajaId() >= 1) {
			
			// Kuka k‰ytt‰j‰ taas oli kyseess‰? Turha sin‰ns‰, koska t‰m‰ on jo k‰yty ylemp‰n‰
				logger.info(tunnit.getKayttajaId() + ":n tunnit");
				
				// Tallennetaan k‰ytt‰j‰n uudet tunnit tietokantaan k‰ytt‰en tunnitDao-olion metodia tallenna
				// Sinne syˆtet‰‰n tunnit ja pvm erikseen - ei en‰‰ tarvitsisi, koska tunnit-oliossa on
				// pvm valmiiksi!
				tunnitDao.tallenna(tunnit, pvm);
			
			}
			
			// Uudelleen ohjataan kontrollerin osaan, joka viittaa "listan" gettiin
			return "redirect:/tunnit/lista";
		}
	}
	
	// Tuntien tietokannasta poisto	
	@RequestMapping(value = "/poista", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute(value = "kayttaja") KayttajaImpl kayttaja) {

		// Luodaan j‰lleen Tunnit-olio, joka on vain yksi tunti
		Tunnit tunti = new TunnitImpl();

		// Asetetaan juuri luodun olion id listaussivulta tulleen kayttaja-olion sis‰ll‰ olleen oman tunti-olion vastaavaksi
		tunti.setId(kayttaja.getUusitunti().getId());
		
		// Tehd‰‰n poisto kyseisen olion pohjalta. Sin‰ns‰ turha vaihe, koska yht‰ hyvin olisi voitu l‰hett‰‰
		// k‰ytt‰j‰n uusiTunti-olion id suoraan
		tunnitDao.poista(tunti.getId());

		// Ohjataan j‰lleen uudelleen kontrollerin osaan, joka viittaa "listan" gettiin
		return "redirect:/tunnit/lista";
	}

	// K‰ytet‰‰n Spring Securitylla toteutettuun sis‰‰n kirjautumiseen
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login(Model model) {
		
		// Jos k‰ytt‰j‰ on "kirjautunut sis‰‰n", asetetaan modeliin attribuutti "loggedin" muotoon "true"		
		model.addAttribute("loggedin", "true");
		
		// Palautetaan index.jsp		
		return "index";
 
	}
 
	// Jos kirjautumisessa on virhe....	
	@RequestMapping(value="/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {		
		
		// Jos sis‰‰n kirjautuminen ep‰onnistui, laitetaan modeliin attribuutti loginerror, joka on "true"		
		model.addAttribute("loginerror", "true");
		
		// Palautetaan index.jsp
		return "index";
 
	}
 
	// Jos kirjaudutaan ulos...	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		// Jos j‰rjestelm‰st‰ kirjauduttiin onnistuneesti ulos, laitetaan modeliin attribuuttin "loggedout", joka on muodossa true		
		model.addAttribute("loggedout", "true");
		
		// Palautetaan index.jsp
		return "index";
 
	}
	
	// TunnitDAO:sta luodun paikallisen olion getteri ja setteri	
	public TunnitDAO getTunnitDao() {
		return tunnitDao;
	}

	public void setTunnitDao(TunnitDAO tunnitDao) {
		this.tunnitDao = tunnitDao;
	}
	
	
}
