import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class AddWatcherByUsernameTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется новое свойство
		final String contentId = "131563538";
		final String username = "ivanov";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.addWatcherByUserName(contentId, username);
		System.out.println("Статус добавления пользователя " + username + " в наблюдатели контента с id=" + contentId + " равен " + result);
	}
}
