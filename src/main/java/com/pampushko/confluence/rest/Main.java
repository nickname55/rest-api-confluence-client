package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import com.pampushko.confluence.properties.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class Main
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	public static final String url = "";
	private static final String username = "";
	private static final String password = "";
	
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = Settings.getValues();
		
		//вызываем билдер и создаем клиент
		ConfluenceClient confluence = ConfluenceClient.newBuilder()
				.baseUrl(settings.getProperty("baseUrl"))
				.username(settings.getProperty("username"))
				.password(settings.getProperty("password"))
				.build();
		
		//получаем список областей
		SpaceResultList spaces = confluence.getSpaces();
		for (Space space : spaces.getSpaces())
		{
			log.info("\n");
			log.info("Область {}", space.toString());
			log.info("\n");
		}
		//печатаем найденные области
		System.out.println(spaces);
	}
}
