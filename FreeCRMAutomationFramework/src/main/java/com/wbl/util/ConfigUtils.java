package com.wbl.util;

import java.io.FileReader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigUtils {

	Logger log = LogManager.getLogger(ConfigUtils.class);

	public static final Properties prop = new Properties();

	public ConfigUtils(String fileName) {
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			log.error("There is an exception while reading the fileName from the configUtils");
		}
	}

	public String getProperty(String key) {
		String property = null;
		try {
			property = prop.getProperty(key);
		} catch (Exception e) {
			log.error("There is an exception getting the url");
		}
		return property;
	}
}
