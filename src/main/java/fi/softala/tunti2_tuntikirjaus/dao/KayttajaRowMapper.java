package fi.softala.tunti2_tuntikirjaus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja;
import fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl;
/**
 * Servlet implementation class KayttajaRowMapper
 */
public class KayttajaRowMapper implements RowMapper<Kayttaja> {
	

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException    {
	    	Kayttaja k = new KayttajaImpl();
	    	k.setId(rs.getInt("id"));
	    	k.setEtunimi(rs.getString("etunimi"));
	    	k.setSukunimi(rs.getString("sukunimi"));
	    	
	    	return k;

	    }
}
