package fi.softala.tunti2_tuntikirjaus.luokat;

public interface Tunnit {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract int getKayttajaId();

	public abstract void setKayttajaId(int kayttajaId);

	public abstract String getTuntien_maara();

	public abstract void setTuntien_maara(String tuntien_maara);

	public abstract String getPaivamaara();

	public abstract void setPaivamaara(String paivamaara);

	public abstract String getKuvaus();

	public abstract void setKuvaus(String kuvaus);

}
