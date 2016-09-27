package fi.softala.tunti2_tuntikirjaus.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.tunti2_tuntikirjaus.dao.TunnitRowMapper;
import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
/**
 * Servlet implementation class TunnitDAOSPingJdbcImpl
 */
@Repository
public class TunnitDAOSpringJdbcImpl implements TunnitDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void tallenna(Tunnit t, Kayttaja k, String paivamaara) {
		t.setPaivamaara(paivamaara);
		String sql = "insert into Tunnit(tuntien_maara, paivamaara, kuvaus, kayttaja_id) values(?,?,?,?)";
		Object[] parametrit = new Object[] {t.getTuntien_maara(), t.getPaivamaara(), t.getKuvaus(),k.getId()};
		System.out.println(t.getPaivamaara());
	    jdbcTemplate.update(sql , parametrit);
	    
	}

	public List<Kayttaja> haeKaikki() {
		
		String sql = "select id, etunimi, sukunimi from Kayttajat";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql,mapper);

		return kayttajat;
	}
	
	public List<Tunnit>haeKayttajanTunnit(int kayttaja_id){
		
		String sql = "select id, tuntien_maara, paivamaara, kuvaus from Tunnit where kayttaja_id =(?)";
		Object[] parametri = new Object[]{kayttaja_id};
		RowMapper<Tunnit> mapper = new TunnitRowMapper();
		
		List<Tunnit> kayttajaTunnit = jdbcTemplate.query(sql, parametri, mapper);
		
		return kayttajaTunnit;
		
	}
	
	public void poista(int id) {		
		String sql = "delete from Tunnit where id=(?)";
		Object[] parametrit = new Object[] {id};

	    jdbcTemplate.update(sql , parametrit);
	    
	}
	
	
}
