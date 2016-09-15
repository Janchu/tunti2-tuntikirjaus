package fi.softala.tunti2_tuntikirjaus.dao;

import java.util.List;

import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;

/**
 * 
 * @author  Tommi Ilvonen
 *
 */

public interface TunnitDAO {
	
	public abstract void tallenna (Tunnit tunnit, Kayttaja kayttaja);
	
	
	public abstract List<Kayttaja> haeKaikki();
	
}
