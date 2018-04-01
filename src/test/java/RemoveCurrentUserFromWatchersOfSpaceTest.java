import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class RemoveCurrentUserFromWatchersOfSpaceTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//ключ области
		final String spaceKey = "GAT";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.removeCurrentUserFromWatchersOfSpace(spaceKey);
		System.out.println("Статус удаления пользователя из списка наблюдателей области имеющей spaceKey=" + spaceKey + " равен " + result);
	}
}
