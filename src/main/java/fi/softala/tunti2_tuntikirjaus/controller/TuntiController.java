package fi.softala.tunti2_tuntikirjaus.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	@Inject
	private TunnitDAO tunnitDao;

	final static Logger logger = LoggerFactory.getLogger(TuntiController.class);

	public TunnitDAO getTunnitDao() {
		return tunnitDao;
	}

	public void setTunnitDao(TunnitDAO tunnitDao) {
		this.tunnitDao = tunnitDao;
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao
				.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit(
					(ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat
							.get(i).getId()));
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String kayttajaString = user.getUsername();
		
		Tunnit tunnit = new TunnitImpl();

		model.addAttribute("tunnit", tunnit);
		Kayttaja kayttaja = tunnitDao.haeKayttaja(kayttajaString);

		
		model.addAttribute("kayttaja", kayttaja);
		model.addAttribute("kayttajat", kayttajat);
		return "tunnit";
	}
	 
	@RequestMapping(value = "lista", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "tunnit") @Valid TunnitImpl tunnit,
			BindingResult result) {
		if (result.hasErrors()) {
			logger.info("T‰‰ll‰ oli erhe");
			return "tunnit";
			
		
		} else {


			String pvm = tunnit.getPaivamaara();
			logger.info(tunnit.getPaivamaara() + " <- p‰iv‰m‰‰r‰");
			
						
			logger.info("id: " +tunnit.getKayttajaId());
			
			if (tunnit.getKayttajaId() <= 6 && tunnit.getKayttajaId() >= 1) {

			
			logger.info(tunnit.getPaivamaara() + " <- p‰iv‰m‰‰r‰");
				logger.info(tunnit.getKayttajaId() + ":n tunnit");
				tunnitDao.tallenna(tunnit, pvm);
			
			}
			return "redirect:/tunnit/lista";
		}
	}
	@RequestMapping(value = "/poista", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute(value = "kayttaja") KayttajaImpl kayttaja) {

		Tunnit tunti = new TunnitImpl();

		tunti.setId(kayttaja.getUusitunti().getId());
		
		tunnitDao.poista(tunti.getId());

		return "redirect:/tunnit/lista";
	}

	// K‰ytet‰‰n Spring Securityn loginiin

	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("l‰pi m‰nt");
		model.addAttribute("loggedin", "true");
		
		return "index";
 
	}
 
	// Jos loginissa on virhe....
	
	@RequestMapping(value="/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {		
		
		model.addAttribute("loginerror", "true");
		return "index";
 
	}
 
	// Jos logataan ulos...
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("loggedout", "true");
		return "index";
 
	}
	
	
}
