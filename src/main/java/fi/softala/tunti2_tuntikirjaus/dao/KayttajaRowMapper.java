package fi.softala.tunti2_tuntikirjaus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl;

/**
 * 
 * @author Mira Erjansola
 * @author Tommi Ilvonen
 * @author Janne Jäppinen
 * @author Niko Kaartinen
 * @author Daniel Rikkilä
 * 
 */

public class KayttajaRowMapper implements RowMapper<Kayttaja> {

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// Luodaan Kayttaja-olio k
		Kayttaja k = new KayttajaImpl();
		
		// Asetetaan olion ID:ksi tietokannasta saatu tieto "id", joka on int
		k.setId(rs.getInt("id"));
		
		// Etunimeksi tietokannasta saatu tieto "etunimi", joka on String
		k.setEtunimi(rs.getString("etunimi"));
		
		// Sukunimeksi "sukunimi"
		k.setSukunimi(rs.getString("sukunimi"));
		
		// Kayttajatunnukseksi "kayttajatunnus"
		k.setKayttajatunnus(rs.getString("kayttajatunnus"));
		
		// Palautetaan olio
		return k;

	}
}
