import com.pampushko.confluence.models.content_property.PropertyListResponseContainer;
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
public class GetSpacePropertiesTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//пустой набор параметров
		Map<String, String> params = new HashMap<String, String>();
		
		//ключ области
		final String spaceKey = "GAT";
		
		//выполняем запрос и печатаем результат
		PropertyListResponseContainer result = confluence.getSpaceProperties(spaceKey, params);
		System.out.println(result);
	}
}
