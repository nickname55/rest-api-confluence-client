package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.Plain;
import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceDescription;
import com.pampushko.confluence.models.SpaceResultList;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Main
{
	public static final String url = "";
	private static final String username = "";
	private static final String password = "";
	
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
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
		
		//создаём область с данными для обновления
		Space space = new Space();
		space.setName("всехорошо ура ура !");
		Plain plainForSpaceDescription = Plain.builder().value("Всё будет очень хорошо!!!")
				.build();
		SpaceDescription description = SpaceDescription.builder()
				.plain(plainForSpaceDescription).build();
		space.setDescription(description);
		Space respSpace = confluence.updateSpace(space, "tndl3333330");
		System.out.println(respSpace);
	}
}
