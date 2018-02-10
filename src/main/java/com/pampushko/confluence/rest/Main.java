package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.PageResultItem;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Базовый класс для запуска клиента
 * <br>
 */
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
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		final String contentId = "66781185";
		Map<String, String> param = new HashMap<String, String>()
		{
			{
			
			}
		};
		PageResultItem content = confluence.getContentById(contentId, param);
		System.out.println(content);
	}
}
