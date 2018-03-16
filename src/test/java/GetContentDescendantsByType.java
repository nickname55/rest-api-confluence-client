import com.pampushko.confluence.models.content.ContentResultList;
import com.pampushko.confluence.models.enums.ContentType;
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
public class GetContentDescendantsByType
{
	public static void main(String[] args) throws IOException
	{
		
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//параметр запроса expand
		final String expand = "comment,page,attachment";
		
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("start", "0");
				put("limit", "10");
			}
		};
		
		//выполняем запрос и печатаем результат
		ContentResultList contentDescendantsMap = confluence.getContentDescendantsByType(contentId, ContentType.page.toString(), expand, params);
		System.out.println(contentDescendantsMap);
	}
}
