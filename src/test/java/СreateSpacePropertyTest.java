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
public class СreateSpacePropertyTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		final String spaceKey = "GAT";
		
		//создаём новый объект свойства
		PropertyOfContent property = new PropertyOfContent();
		property.setKey("ura6");
		property.setValue("ulala6");
		
		//выполняем запрос и печатаем результат
		Object result = confluence.createSpaceProperty(spaceKey, property);
		System.out.println(result);
	}
}
