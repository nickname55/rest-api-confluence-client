import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class RemoveWatcherFromSpaceByUserKeyTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//ключ области
		final String spaceKey = "GAT";
		
		//login пользователя
		final String userKey = "8a7f80836261842b016261ec1e130089";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.removeWatcherFromSpaceByUserKey(spaceKey, userKey);
		System.out.println("Статус удаления пользователя из списка наблюдателей области имеющей spaceKey=" + spaceKey + " равен " + result);
	}
}
