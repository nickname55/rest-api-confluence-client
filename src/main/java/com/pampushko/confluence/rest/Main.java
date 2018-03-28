package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.convert.req.ContentBody;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
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
		
		//создаём объект с контентом, который мы хотим конвертировать в другой формат
		final ContentBody contentBody = new ContentBody();
		contentBody.setValue("<p>Some example body in storage format</p>");
		contentBody.setRepresentation("storage");
		
		//выполняем запрос и печатаем результат
		Object result = confluence.convert(contentBody, "export_view");
		System.out.println(result);
	}
}
