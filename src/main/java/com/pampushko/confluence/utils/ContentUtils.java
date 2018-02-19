package com.pampushko.confluence.utils;

import com.pampushko.confluence.models.Body;
import com.pampushko.confluence.models.Storage;
import com.pampushko.confluence.models.content.Content;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ContentUtils
{
	public static void main(String[] args)
	{
		createNewContent();
	}
	
	public static Content createNewContent()
	{
		Content content = new Content();
		String title = "super page 222";
		content.setTitle(title);
		String type = "page";
		content.setType(type);
		Storage storage = new Storage();
		storage.setRepresentation("storage");
		storage.setValue("<p>Ура, у нас всё получилось</p>" +
				"<h1>а может быть и нет</h1>" +
				"<h2>заголовок второго (2) уровня</h2>" +
				"<h3>tretiy zagolovok33333</h3>");
		Body body = new Body();
		body.setStorage(storage);
		content.setBody(body);
		//System.out.println(content);
		return content;
	}
}
