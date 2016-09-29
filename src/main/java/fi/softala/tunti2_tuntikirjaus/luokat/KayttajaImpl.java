package fi.softala.tunti2_tuntikirjaus.luokat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "kayttaja")
public class KayttajaImpl implements Kayttaja {
	
	// Muuttujat
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@Size(min = 1, max = 255)
	private String kayttajatunnus;
	
	@Size(min = 1, max = 255)
	@Email
	private String sahkoposti;
	
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[^a-zA-ZäöÄÖ]")
	private String etunimi;
	
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[^a-zA-ZäöÄÖ]")
	private String sukunimi;
	
	@Size(min = 1, max = 255)
	private String salasana;
	
	private ArrayList<Tunnit> tunnit;
	
	private Tunnit uusitunti;
	
	// Tyhjä constructor
	

	public KayttajaImpl(){
		this.id = -1;
		this.kayttajatunnus = "";
		this.sahkoposti = "";
		this.etunimi = "";
		this.sukunimi = "";
		this.salasana = "";		
		this.tunnit = new ArrayList<Tunnit>();
		this.uusitunti = new TunnitImpl();
	}
	
	// Constructor joka vaatii kaikki muuttujat
	
	public KayttajaImpl(int id, String kayttajatunnus, String sahkoposti, String etunimi, String sukunimi, String salasana, ArrayList<Tunnit> tunnit){
		
		this.id = id;
		this.kayttajatunnus = kayttajatunnus;
		this.sahkoposti = sahkoposti;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
		this.tunnit = tunnit;		
	}
	
	// Constructor id:lle ja salasanalle
	
	public KayttajaImpl(int id, String salasana){
		this.id = id;
		this.salasana = salasana;	
		
		this.kayttajatunnus = "";
		this.sahkoposti = "";
		this.etunimi = "";
		this.sukunimi = "";
		this.uusitunti = new TunnitImpl();
	}

	// Getterit ja setterit
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getKayttajatunnus() {
		return kayttajatunnus;
	}


	public void setKayttajatunnus(String kayttajatunnus) {
		this.kayttajatunnus = kayttajatunnus;
	}


	public String getSahkoposti() {
		return sahkoposti;
	}


	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}


	public String getEtunimi() {
		return etunimi;
	}


	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}


	public String getSukunimi() {
		return sukunimi;
	}


	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}


	public String getSalasana() {
		return salasana;
	}


	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	
	public ArrayList<Tunnit> getTunnit() {
		return tunnit;
	}

	public void addTunnit(Tunnit uusiTunnit) {
		this.tunnit.add(uusiTunnit);
	}
	
	public void setTunnit(ArrayList<Tunnit> tunnit) {
		this.tunnit = tunnit;
}
	
	public Tunnit getUusitunti() {
		return uusitunti;
	}

	public void setUusitunti(Tunnit uusitunti) {
		this.uusitunti = uusitunti;
	}

}
