package fi.softala.tunti2_tuntikirjaus.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import javax.validation.Valid;

import org.slf4j.*;
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

	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao
				.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit(
					(ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat
							.get(i).getId()));
		}

		Tunnit tunnit = new TunnitImpl();

		model.addAttribute("tunnit", tunnit);
		return "syotatunnit";
	}

	@RequestMapping(value = "lista", method = RequestMethod.GET)
	public String getLista(Model model) {
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao
				.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit(
					(ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat
							.get(i).getId()));
		}
		Kayttaja kayttaja = new KayttajaImpl();

		model.addAttribute("kayttaja", kayttaja);
		model.addAttribute("kayttajat", kayttajat);
		return "listaatunnit";
	}

	@RequestMapping(value = "lista", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute(value = "kayttaja") KayttajaImpl kayttaja) {

		Tunnit tunti = new TunnitImpl();

		tunti.setId(kayttaja.getUusitunti().getId());

		System.out.println(tunti.getId());
		tunnitDao.poista(tunti.getId());

		return "redirect:/tunnit/lista";
	}

	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "tunnit") @Valid TunnitImpl tunnit,
			BindingResult result) {

		if (result.hasErrors()) {
			return "syotatunnit";
		} else {

			Date pvm = new Date();
			SimpleDateFormat simppeli = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String paivamaara = simppeli.format(pvm);

			

			if (tunnit.getKayttajaId() > 6 || tunnit.getKayttajaId() < 1) {
			} else {
				logger.info(tunnit.getKayttajaId() + ":n tunnit");
				tunnitDao.tallenna(tunnit, paivamaara);
			}

			return "redirect:/tunnit/uusi";
		}
	}

}
