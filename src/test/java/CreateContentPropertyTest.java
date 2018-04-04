import com.pampushko.confluence.models.content_property.PropertyResponse;
import com.pampushko.confluence.models.content_property.PropertyOfContent;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class CreateContentPropertyTest
{
	public static void main(String[] args) throws IOException
	{
		
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется новое свойство
		final String contentId = "5210113";
		
		//создаём новое свойства для контента
		PropertyOfContent propertyOfContent = new PropertyOfContent();
		
		final String propKey = "hello7";
		propertyOfContent.setKey(propKey);
		
		propertyOfContent.setValue("i love you");
		
		System.out.println(propertyOfContent);
		
		//выполняем запрос и печатаем результат
		PropertyResponse response = confluence.createContentProperties(contentId, propertyOfContent);
		System.out.println(response);
	}
	
}
