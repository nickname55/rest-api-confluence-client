package com.pampushko.confluence.properties;

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Properties;

/**
 * Класс для чтения настроек приложения
 * <br />
 */
public class Settings
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	//test
	public static void main(String[] args) throws IOException
	{
		Properties values = getValues();
		log.info("username : {}", values.get("username"));
		log.info("password : {}", values.get("password"));
		log.info("baseUrl : {}", values.get("baseUrl"));
	}
	
	/**
	 * Читает настройки из файла config.properties
	 * @return объект Properties
	 */
	public static synchronized Properties getValues()
	{
		Properties properties = new Properties();
		URL resource = Resources.getResource("config.properties");
		
		try (FileInputStream fileInputStream = new FileInputStream(new File(resource.getFile())))
		{
			properties.load(fileInputStream);
		}
		catch (IOException ex)
		{
			log.error(ex.getMessage());
		}
		return properties;
	}
}
