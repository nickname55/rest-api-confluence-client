package com.pampushko.confluence.settings;

import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Класс для чтения настроек приложения
 * <br />
 */
@Slf4j
public class SettingsManager
{
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
