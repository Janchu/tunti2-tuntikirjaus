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
	
	public abstract void tallenna (Tunnit tunnit, Kayttaja kayttaja, String paivamaara);
	
	
	public abstract List<Kayttaja> haeKaikki();
	
	public abstract List<Tunnit> haeKayttajanTunnit(int kayttaja_id);
	
	public abstract void poista(int id);
	
}
