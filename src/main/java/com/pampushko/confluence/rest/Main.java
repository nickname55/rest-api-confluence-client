package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.user_watch.WatchObject;
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
		
		final String contentId = "75563009";
		final String userkey = "8a7f80835e12863a015e14c6d9910023";
		final String username = "admin";
		
		WatchObject watchObjectContent = confluence.watch(contentId);
		WatchObject watchObjectUsername = confluence.watchByUsername(contentId, username);
		WatchObject watchObjectUserkey = confluence.watchByKey(contentId, userkey);
		
		
		System.out.println("--content by current user--");
		System.out.println(watchObjectContent);
		System.out.println("--content by userkey--");
		System.out.println(watchObjectUserkey);
		System.out.println("--content by username--");
		System.out.println(watchObjectUsername);
		
		
	}
}
