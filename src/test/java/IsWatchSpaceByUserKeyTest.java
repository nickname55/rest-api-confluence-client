import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class IsWatchSpaceByUserKeyTest
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
		final String userName = "pampushko+78978945";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.isWatchSpaceByUserName(spaceKey, userName);
		System.out.println("Статус наблюдателя для области " + spaceKey + " равен " + result);
	}
}
