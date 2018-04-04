import com.pampushko.confluence.models.content_property.PropertyResponse;
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
public class GetSpacePropertyByKeyTest
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
		
		//ключ свойства области, значение этого ключа мы хотим получить
		final String propertyKey = "ura5";
		
		//выполняем запрос и печатаем результат
		PropertyResponse result = confluence.getSpacePropertyByKey(spaceKey, propertyKey);
		System.out.println(result);
	}
}
