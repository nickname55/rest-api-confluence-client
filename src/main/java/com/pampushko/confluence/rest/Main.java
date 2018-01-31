package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.search.SearchResultList;
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
		Confluence confluence = Confluence.newBuilder()
				.baseUrl(settings.getProperty("baseUrl"))
				.username(settings.getProperty("username"))
				.password(settings.getProperty("password"))
				.build();
		
		//получаем контент по запросу CQL, но только один элемент
		Confluence.SearchParams searchParams = Confluence.SearchParams.builder().cql("space = KARMA order by created").limit(1).build();
		SearchResultList searchResultList2 = confluence.search(searchParams);
		
		//получаем весь контент по запросу CQL
		SearchResultList searchResultList1 = confluence.search("space = KARMA order by created");
		
		System.out.println("------------------------------------------------------------");
		System.out.println(searchResultList1);
		System.out.println("------------------------------------------------------------");
		System.out.println(searchResultList2);
		System.out.println("------------------------------------------------------------");
	}
}
