import com.pampushko.confluence.models.Body;
import com.pampushko.confluence.models.Storage;
import com.pampushko.confluence.models.Version;
import com.pampushko.confluence.models.content.Content;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class UpdateContentTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		final String contentId = "134316056";
		Map<String, String> param = new HashMap<String, String>()
		{
			{
			
			}
		};
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
		Version version = new Version();
		//версия должна быть на единицу больше от текущей версии обновляемого нами контента
		version.setNumber(10);
		content.setVersion(version);
		System.out.println(content);
		Content updatedContent = confluence.updateContent(content, contentId);
		System.out.println(updatedContent);
	}
	
}
