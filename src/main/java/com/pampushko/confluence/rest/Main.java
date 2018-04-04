package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.content_property.PropertyOfContent;
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
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//пустой набор параметров
		Map<String, String> params = new HashMap<String, String>();
		
		//ключ области
		final String spaceKey = "GAT";
		
		//ключ свойства области, значение этого ключа мы хотим получить
		final String propertyKey = "ura555";
		
		//создаём новый объект свойства
		PropertyOfContent property = new PropertyOfContent();
		property.setKey("ura555");
		property.setValue("ulala555");
		
		//выполняем запрос и печатаем результат
		Object result = confluence.createSpacePropertyByKey(spaceKey, propertyKey, property);
		System.out.println(result);
	}
}
