package fi.softala.tunti2_tuntikirjaus.luokat;

import java.util.ArrayList;

public class Kayttaja {
	
	// Muuttujat
	
	private int id;
	private String kayttajatunnus;
	private String sahkoposti;
	private String etunimi;
	private String sukunimi;
	private String salasana;
	private ArrayList<Tunnit> tunnit;
	
	
	// Tyhjä constructor
	
	public Kayttaja(){
		this.id = -1;
		this.kayttajatunnus = "";
		this.sahkoposti = "";
		this.etunimi = "";
		this.sukunimi = "";
		this.salasana = "";		
		this.tunnit = new ArrayList<Tunnit>();
	}
	
	// Constructor joka vaatii kaikki muuttujat
	
	public Kayttaja(int id, String kayttajatunnus, String sahkoposti, String etunimi, String sukunimi, String salasana, ArrayList<Tunnit> tunnit){
		
		this.id = id;
		this.kayttajatunnus = kayttajatunnus;
		this.sahkoposti = sahkoposti;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
		this.tunnit = tunnit;
	}
	
	// Constructor id:lle ja salasanalle
	
	public Kayttaja(int id, String salasana){
		this.id = id;
		this.salasana = salasana;	
		
		this.kayttajatunnus = "";
		this.sahkoposti = "";
		this.etunimi = "";
		this.sukunimi = "";
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
	
	

}
