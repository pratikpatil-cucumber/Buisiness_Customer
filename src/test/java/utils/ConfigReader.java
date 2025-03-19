package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	 private static Properties properties;

	    // Static block to load properties file
	    static {
	        try {
	            FileInputStream fileInputStream = new FileInputStream("./file/datafile.properties");
	            properties = new Properties();
	            properties.load(fileInputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config.properties file");
	        }
	    }

	    // Method to get property value
	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	

}
