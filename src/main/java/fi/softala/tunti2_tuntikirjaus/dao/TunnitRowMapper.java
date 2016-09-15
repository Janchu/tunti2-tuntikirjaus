package fi.softala.tunti2_tuntikirjaus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.tunti2_tuntikirjaus.luokat.Tunnit;
import fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl;


public class TunnitRowMapper implements RowMapper<Tunnit> {

       
    
    public Tunnit mapRow(ResultSet rs, int rowNum) throws SQLException    {
    	Tunnit t = new TunnitImpl();
    	t.setId(rs.getInt("id"));
    	t.setKuvaus(rs.getString("kuvaus"));
    	t.setPaivamaara(rs.getString("paivamaara"));
    	t.setTuntien_maara(rs.getInt("tuntien_maara"));
    	
    	return t;

    }
    
}
