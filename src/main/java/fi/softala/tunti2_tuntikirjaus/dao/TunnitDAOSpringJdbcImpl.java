package fi.softala.tunti2_tuntikirjaus.dao;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.tunti2_tuntikirjaus.dao.TunnitRowMapper;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;

/**
 * 
 * @author Mira Erjansola
 * @author Tommi Ilvonen
 * @author Janne J‰ppinen
 * @author Niko Kaartinen
 * @author Daniel Rikkil‰
 * 
 */

@Repository
public class TunnitDAOSpringJdbcImpl implements TunnitDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	final static Logger logger = LoggerFactory
			.getLogger(TunnitDAOSpringJdbcImpl.class);

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Tallennetaan k‰ytt‰j‰n uudet tunnit tietokantaan

	public void tallenna(Tunnit t, String paivamaara) {
		t.setPaivamaara(paivamaara);
		logger.info("Laitettava p‰iv‰m‰‰r‰ on " + paivamaara);
		String sql = "insert into Tunnit(tuntien_maara, paivamaara, kuvaus, kayttaja_id) values(?,?,?,?)";
		Object[] parametrit = new Object[] { t.getTuntien_maara(),
				t.getPaivamaara(), t.getKuvaus(), t.getKayttajaId() };
		jdbcTemplate.update(sql, parametrit);

	}

	// Haetaan kannasta kaikkien k‰ytt‰jien tunnit

	public List<Kayttaja> haeKaikki() {

		String sql = "select id, kayttajatunnus, etunimi, sukunimi from Kayttajat";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql, mapper);

		return kayttajat;
	}

	// Haetaan kannasta tietyn k‰ytt‰j‰n tunnit p‰iv‰m‰‰r‰n mukaan

	public List<Tunnit> haeKayttajanTunnit(int kayttaja_id) {

		logger.info("K‰ytt‰j‰n ID on: " + kayttaja_id);

		String sql = "select id, tuntien_maara, paivamaara, kuvaus from Tunnit where kayttaja_id =(?) order by paivamaara";
		Object[] parametri = new Object[] { kayttaja_id };
		RowMapper<Tunnit> mapper = new TunnitRowMapper();

		List<Tunnit> kayttajaTunnit = jdbcTemplate
				.query(sql, parametri, mapper);

		return kayttajaTunnit;

	}

	// Poistetaan kannasta valitun k‰ytt‰j‰n valitut tunnit

	public void poista(int id) {

		String sql = "delete from Tunnit where id=(?)";
		Object[] parametrit = new Object[] { id };

		jdbcTemplate.update(sql, parametrit);

	}

	public Kayttaja haeKayttaja(String kayttajatunnus) {
		 
		String sql = "select id, kayttajatunnus, etunimi, sukunimi from Kayttajat where kayttajatunnus = (?)";
		Object[] parametri = new Object[] { kayttajatunnus };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		
		Kayttaja kayttaja = jdbcTemplate
				.queryForObject(sql, parametri, mapper);
		
		return kayttaja;
	}

}
