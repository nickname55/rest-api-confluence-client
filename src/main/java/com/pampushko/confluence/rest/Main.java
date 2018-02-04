package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.Body;
import com.pampushko.confluence.models.Content;
import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.Storage;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		final String contentId = "75563009";
		
		Map<String, String> params = new HashMap<String, String>()
		{
			{
			
			}
		};
		Content content = new Content();
		Space space = confluence.getSpaceByKey("Karma", params);
		content.setType("page");
		content.setTitle("Это новая интересная очень страница");
		Body body = new Body();
		Storage storage = new Storage();
		storage.setValue("<h1>Heading 1</h1><h2>Heading 2</h2><hr /><hr /><hr /><a href=\"http://www.atlassian.com\">Atlassian</a> <p>Привет, привет. Как дела?</p>");
		storage.setRepresentation(Storage.Representation.STORAGE.toString()); //необязательно
		body.setStorage(storage);
		content.setBody(body);
		content.setSpace(space);
		
		Content resultContent = confluence.createContent(content, params);
		System.out.println(resultContent);
	}
}
