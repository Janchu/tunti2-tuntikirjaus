package fi.softala.tunti2_tuntikirjaus.luokat;

import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class TunnitImpl implements Tunnit {

	// Muuttujat
	
	private int id;
	private int tuntien_maara;
	private String paivamaara;
	
	@Size(min = 1, max = 255)
	private String kuvaus;
	
	// Tyhj� constructor
	
	public TunnitImpl(){
		this.id = 0;
		this.tuntien_maara = 0;
		this.paivamaara = "";
		this.kuvaus = "";		
		
	}
	
	// Constructor joka vaatii kaikki muuttujat
	
	public TunnitImpl(int id, int tuntien_maara, String paivamaara, String kuvaus){
		this.id = id;
		this.tuntien_maara = tuntien_maara;
		this.paivamaara = paivamaara;
		this.kuvaus = kuvaus;
	}
	
	
	// Constructor joka vaatii kaiken paitsi id:n
	
	public TunnitImpl(int tuntien_maara, String paivamaara, String kuvaus){
		this.id = -1;
		this.tuntien_maara = tuntien_maara;
		this.paivamaara = paivamaara;
		this.kuvaus = kuvaus;
		
	}

	// Getterit ja setterit
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTuntien_maara() {
		return tuntien_maara;
	}

	public void setTuntien_maara(int tuntien_maara) {
		this.tuntien_maara = tuntien_maara;
	}

	public String getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	
	
	
	
	
}
