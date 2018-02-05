package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.macros.Macros;
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
		
		final String contentId = "983041";
		
		Map<String, String> params = new HashMap<String, String>()
		{
			{
			
			}
		};
		String macroId = "36050d1a-60a4-4586-b5b2-a610e69dc933";
		Macros contentMacroBodyByMacroId = confluence.getContentMacroBodyByMacroId(contentId, "4", macroId);
		System.out.println(contentMacroBodyByMacroId);
	}
}
