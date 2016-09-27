package fi.softala.tunti2_tuntikirjaus.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.tunti2_tuntikirjaus.dao.TunnitDAO;
import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl;

@Controller
@RequestMapping (value="/tunnit")
public class TuntiController {

	@Inject
	private TunnitDAO tunnitDao;

	public TunnitDAO getTunnitDao() {
		return tunnitDao;
	}

	public void setTunnitDao(TunnitDAO tunnitDao) {
		this.tunnitDao = tunnitDao;
	}
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model){
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit((ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat.get(i).getId()));
		}
		
		Kayttaja kayttaja = new KayttajaImpl();
		
		model.addAttribute("kayttajat", kayttajat);
		model.addAttribute("kayttaja", kayttaja);
		return "index";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.GET)
	public String getLista(Model model){
		ArrayList<Kayttaja> kayttajat = (ArrayList<Kayttaja>) tunnitDao.haeKaikki();
		for (int i = 0; i < kayttajat.size(); i++) {
			kayttajat.get(i).setTunnit((ArrayList<Tunnit>) tunnitDao.haeKayttajanTunnit(kayttajat.get(i).getId()));
		}
		Kayttaja kayttaja = new KayttajaImpl();
		
		model.addAttribute("kayttaja", kayttaja);
		model.addAttribute("kayttajat", kayttajat);		
		return "listaatunnit";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.POST)
	public String delete( @ModelAttribute(value="kayttaja") KayttajaImpl kayttaja){
		
		System.out.println("HAI");
		Tunnit tunti = new TunnitImpl();
		
		tunti.setId(kayttaja.getUusitunti().getId());
		
		tunnitDao.poista(tunti.getId());
		
		
		return "lista";		
	}
	
	
	
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kayttaja") KayttajaImpl kayttaja){
		
		Date pvm = new Date();
		SimpleDateFormat simppeli = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String paivamaara = simppeli.format(pvm);
		
		if(kayttaja.getEtunimi().equalsIgnoreCase("Niko"))kayttaja.setId(1);
		if(kayttaja.getEtunimi().equalsIgnoreCase("Janne"))kayttaja.setId(2);
		if(kayttaja.getEtunimi().equalsIgnoreCase("Tommi"))kayttaja.setId(3);
		if(kayttaja.getEtunimi().equalsIgnoreCase("Daniel"))kayttaja.setId(4);
		if(kayttaja.getEtunimi().equalsIgnoreCase("Mira"))kayttaja.setId(5);
		if(kayttaja.getEtunimi().equalsIgnoreCase("Testaaja"))kayttaja.setId(6);
		
		
		if(kayttaja.getId() > 6 || kayttaja.getId() < 1){}else{
		
		tunnitDao.tallenna(kayttaja.getUusitunti(), kayttaja, paivamaara);
		}
		
		return "index";		
	}
	
	
	
}
