package com.softserve.edu.pageobject.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
    private final String RIGHT_SLASH = "/";
    private final String DEFAULT_VALUE = "";
    private String fileName;
    private Map<String, String> mapProperties;

    public PropertiesReader(String fileName) {
        this.fileName = fileName;
        mapProperties = new HashMap<>();
        readProperties(fileName);
    }

    private String filterProperties(String value) {
    	value = value.trim().replace(" ", "_").toUpperCase();
    	String result = value;
    	//System.out.println("filterProperties() value = " + value);
    	//System.out.println("RegexUtils.isSecurityMatches(value) = " + RegexUtils.isSecurityMatches(value));
    	if (RegexUtils.isSecurityMatches(value)) {
    		result = EnvironmentUtils.readEnvironment(RegexUtils.extractSecurityValue(value)); 
    	}
    	//System.out.println("filterProperties() result = " + result);
    	return result;
    }

    private void readProperties(String fileName) {
        String path = PropertiesReader.class.getResource(RIGHT_SLASH + fileName).getPath();
        try (InputStream input = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(input);
            for (String current : properties.stringPropertyNames()) {
                mapProperties.put(current.toLowerCase().trim(),
                		filterProperties(properties.getProperty(current, DEFAULT_VALUE)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Map<String, String> getAllProperties() {
        return mapProperties;
    }
    
    public String getPropertiesByKey(String key) {
    	System.out.println("getPropertiesByKey(): key = " + key + " value = " +  getAllProperties().get(key));
        return getAllProperties().get(key);
    }

}
