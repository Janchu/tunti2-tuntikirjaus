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
	
	public abstract void tallenna (Tunnit tunnit);
	
	public abstract Kayttaja etsi(String etunimi, String sukunimi, int id);
	
	public abstract List<Kayttaja> haeKaikki();
	
}
