package fi.softala.tunti2_tuntikirjaus.luokat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tunnit")
public class TunnitImpl implements Tunnit {

	// Muuttujat
	
	private int id;
	
	@NotNull
	@DecimalMax("99999.99")
	private double tuntien_maara;
	
	private String paivamaara;
	
	@Size(min = 1, max = 1000)
	private String kuvaus;
	
	// Tyhjä constructor
	
	public TunnitImpl(){
		this.id = 0;
		this.tuntien_maara = 0.00;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTuntien_maara() {
		return tuntien_maara;
	}

	public void setTuntien_maara(double tuntien_maara) {
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

	// Getterit ja setterit
	

	
}
