package fi.softala.tunti2_tuntikirjaus.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;

/**
 * 
 * @author Mira Erjansola
 * @author Tommi Ilvonen
 *
 */

public interface TunnitDAO {

	// @PreAuthorizella varmistetaan, ett‰ k‰ytt‰j‰ joka yritt‰‰ k‰ytt‰‰ t‰t‰ koodin osaa oikeasti saa k‰ytt‰‰ sit‰
	
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
