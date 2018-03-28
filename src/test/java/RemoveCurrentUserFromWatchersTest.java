import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class RemoveCurrentUserFromWatchersTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы
		final String contentId = "131563538";
		
		//выполняем запрос и печатаем результат
		boolean result = confluence.removeCurrentUserFromWatchers(contentId);
		System.out.println("Статус удаления текущего пользователя из списка наблюдателей контента с id=" + contentId + " равен " + result);
	}
}
