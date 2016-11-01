package fi.softala.tunti2_tuntikirjaus.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;

/**
 * 
 * @author Tommi Ilvonen
 *
 */

public interface TunnitDAO {

	@PreAuthorize("isAuthenticated()")
	public abstract void tallenna(Tunnit tunnit, String paivamaara);

	@PreAuthorize("isAuthenticated()")
	public abstract List<Kayttaja> haeKaikki();

	@PreAuthorize("isAuthenticated()")
	public abstract List<Tunnit> haeKayttajanTunnit(int kayttaja_id);
	
	@PreAuthorize("isAuthenticated()")
	public abstract Kayttaja haeKayttaja(String kayttajatunnus);

	@PreAuthorize("isAuthenticated()")
	public abstract void poista(int id);

}
