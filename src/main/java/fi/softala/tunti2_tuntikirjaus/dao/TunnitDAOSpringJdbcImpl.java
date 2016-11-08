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

	
	// JdbcTemplate-olio, jota k‰ytet‰‰n tietokantayhteyksiin
	@Inject
	private JdbcTemplate jdbcTemplate;

	
	// Luodaan Logger-olio, jota k‰ytet‰‰n System.outin sijaan
	final static Logger logger = LoggerFactory
			.getLogger(TunnitDAOSpringJdbcImpl.class);
	
	// Tallennetaan k‰ytt‰j‰n uudet tunnit tietokantaan
	public void tallenna(Tunnit t, String paivamaara) {
		
		// Asetetaan t-olion p‰iv‰m‰‰r‰ksi String paivamaara
		t.setPaivamaara(paivamaara);
		
		// Mik‰ p‰iv‰m‰‰r‰ olikaan?
		logger.info("Laitettava p‰iv‰m‰‰r‰ on " + paivamaara);
		
		// K‰ytett‰v‰ SQL-string, jota siis k‰ytet‰‰n MariaDB-tietokannan kanssa
		String sql = "insert into Tunnit(tuntien_maara, paivamaara, kuvaus, kayttaja_id) values(?,?,?,?)";
		
		// Parametrit, jotka t‰ytt‰v‰t ylemm‰n SQL-stringin loppup‰‰n kysymysmerkit
		Object[] parametrit = new Object[] { t.getTuntien_maara(),
				t.getPaivamaara(), t.getKuvaus(), t.getKayttajaId() };
		
		// Toteutetaan SQL-komento
		jdbcTemplate.update(sql, parametrit);

	}

	// Haetaan kannasta kaikkien k‰ytt‰jien tunnit
	public List<Kayttaja> haeKaikki() {

		
		// K‰ytett‰v‰ SQL-string
		String sql = "select id, kayttajatunnus, etunimi, sukunimi from Kayttajat WHERE id != 0";
		
		// RowMapper, jota k‰ytet‰‰n kun halutaan palauttaa tietoa tietokannasta eik‰ syˆtt‰‰ sit‰ tietokantaan
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		
		// Luodaan List-olio kayttajat. Sen tiedot saadaan SQL-komennon listauksesta, jotka RowMapper jakaa Javan ymm‰rt‰miin
		// osiin
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql, mapper);

		// Palautetaan luotu olio
		return kayttajat;
	}

	// Haetaan kannasta tietyn k‰ytt‰j‰n tunnit p‰iv‰m‰‰r‰ll‰ j‰rjestettyn‰
	public List<Tunnit> haeKayttajanTunnit(int kayttaja_id) {

		// Listataan k‰ytt‰j‰n ID
		logger.info("K‰ytt‰j‰n ID on: " + kayttaja_id);

		// SQL-string, joka haetaan k‰ytt‰j‰n ID:n mukaan, jonka j‰lkeen tieto j‰rjestet‰‰n p‰iv‰m‰‰r‰ll‰
		String sql = "select id, tuntien_maara, paivamaara, kuvaus from Tunnit where kayttaja_id =(?) order by paivamaara";
		
		// K‰ytetyt parametrit, joka t‰ss‰ tapauksessa on vain k‰ytt‰j‰n ID
		Object[] parametri = new Object[] { kayttaja_id };
		
		// RowMapper, koska tietoa palautetaan tietokannasta eik‰ lis‰t‰ sinne
		RowMapper<Tunnit> mapper = new TunnitRowMapper();

		// Luodaan List-olio kayttajaTunnit. Tieto siis pohjautuu SQL-stringille ja parametrille, jotka RowMapper muuttaa
		// Javassa listattavaan muotoon
		List<Tunnit> kayttajaTunnit = jdbcTemplate
				.query(sql, parametri, mapper);

		// Palautetaan olio
		return kayttajaTunnit;

	}

	// Poistetaan kannasta valitun k‰ytt‰j‰n valitut tunnit
	public void poista(int id) {

		String sql = "delete from Tunnit where id=(?)";
		Object[] parametrit = new Object[] { id };

		jdbcTemplate.update(sql, parametrit);

	}

	
	// Haetaan yksi tietty k‰ytt‰j‰
	public Kayttaja haeKayttaja(String kayttajatunnus) {
		 
		String sql = "select id, kayttajatunnus, etunimi, sukunimi from Kayttajat where kayttajatunnus = (?)";
		Object[] parametri = new Object[] { kayttajatunnus };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();		
		
		// .queryForObjectia k‰ytet‰‰n, kun halutaan vain yhdelle oliolle tietoja
		Kayttaja kayttaja = jdbcTemplate
				.queryForObject(sql, parametri, mapper);
		
		return kayttaja;
	}

	// JdbcTemplaten getteri ja setteri	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
