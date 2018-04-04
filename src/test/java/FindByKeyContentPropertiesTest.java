import com.pampushko.confluence.models.content_property.PropertyResponse;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class FindByKeyContentPropertiesTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется новое свойство
		final String contentId = "5210113";
		
		final String propKey = "hello5";
		
		//выполняем запрос и печатаем результат
		PropertyResponse prop = confluence.findByKeyContentProperties(contentId, propKey);
		System.out.println(prop);
	}
}
