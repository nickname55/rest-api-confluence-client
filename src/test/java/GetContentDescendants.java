import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class GetContentDescendants
{
	public static void main(String[] args) throws IOException
	{
		
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//параметр запроса expand
		final String expand = "comment,page,attachment";
		
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("start", "3");
				put("limit", "0");
			}
		};
		
		//выполняем запрос и печатаем результат
		Object contentDescendantsMap = confluence.getContentDescendants(contentId, expand);
		System.out.println(contentDescendantsMap);
	}
}
