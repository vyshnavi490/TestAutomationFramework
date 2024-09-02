package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	public static void load() {

		Properties prop = new Properties();
		InputStream input = null;
		try {
			File file = new File("src/test/resources/config/config.properties");
			// Load the configuration file
			input = new FileInputStream(file);
			// Load properties from input stream
			prop.load(input);
			// Reading properties from config.properties file and assigning them to settings
			// class static fields
			Settings.appURL = prop.getProperty("appURL");
			Settings.browser = prop.getProperty("browser");
			Settings.username = prop.getProperty("username");
			Settings.password = prop.getProperty("password");
			Settings.reportPath = prop.getProperty("reportPath");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close the input stream
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
