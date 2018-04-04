import com.pampushko.confluence.models.Version;
import com.pampushko.confluence.models.content_property.PropertyOfContentWithVersion;
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
public class UpdateSpacePropertyByKeyTest
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
		
		//создаём новый объект свойства
		PropertyOfContentWithVersion property = new PropertyOfContentWithVersion();
		Version version = new Version();
		version.setNumber(5);
		property.setKey("ura5");
		property.setValue("ulala666666666777777777777777999999");
		property.setVersion(version);
		
		//выполняем запрос и печатаем результат
		PropertyResponse result = confluence.updateSpacePropertyByKey(spaceKey, propertyKey, property);
		System.out.println(result);
	}
}
