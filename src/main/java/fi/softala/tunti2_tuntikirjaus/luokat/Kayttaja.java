package fi.softala.tunti2_tuntikirjaus.luokat;

import java.util.ArrayList;

public interface Kayttaja {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getKayttajatunnus();

	public abstract void setKayttajatunnus(String kayttajatunnus);

	public abstract String getSahkoposti();

	public abstract void setSahkoposti(String sahkoposti);

	public abstract String getEtunimi();

	public abstract void setEtunimi(String etunimi);

	public abstract String getSukunimi();

	public abstract void setSukunimi(String sukunimi);

	public abstract String getSalasana();

	public abstract void setSalasana(String salasana);

	public abstract ArrayList<Tunnit> getTunnit();

	public abstract void addTunnit(Tunnit uusiTunnit);

	public abstract void setTunnit(ArrayList<Tunnit> tunnit);

	public abstract Tunnit getUusitunti();

	public abstract void setUusitunti(Tunnit tunnit);

}
