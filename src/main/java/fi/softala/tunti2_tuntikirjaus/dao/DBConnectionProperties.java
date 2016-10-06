package fi.softala.tunti2_tuntikirjaus.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnectionProperties {

	public static final String TIEDOSTON_NIMI = "db_connection.properties";
	private static DBConnectionProperties instance;
	private Properties properties;

	private DBConnectionProperties() throws IOException {

		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(TIEDOSTON_NIMI);
		properties = new Properties();
		properties.load(inputStream);

	}

	public String getProperty(String nimi) {

		return this.properties.getProperty(nimi);

	}

	public static DBConnectionProperties getInstance() throws IOException {
		if (instance == null) {

			instance = new DBConnectionProperties();
		}
		return instance;
	}

}
