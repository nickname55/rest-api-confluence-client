import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 *
 */
@Slf4j
public class RemoveWatcherByUsernameTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы
		final String contentId = "131563538";
		//ключ, по которому мы найдем пользователя
		final String username = "pampushko+78978945";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.removeWatcherByUserName(contentId, username);
		System.out.println("Статус удаления пользователя с username=" + username + " из списка наблюдателей контента с id=" + contentId + " равен " + result);
	}
}
