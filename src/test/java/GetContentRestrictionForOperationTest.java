import com.pampushko.confluence.models.content_restriction.restriction.Restriction;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class GetContentRestrictionForOperationTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется новое свойство
		final String contentId = "5210113";
		
		final String operationKey = "read"; //or update
		
		//выполняем запрос и печатаем результат
		//ограничения контента сгруппированные по операциям
		Restriction contentRestriction = confluence.getContentRestrictionForOperation(contentId, operationKey);
		System.out.println(contentRestriction);
	}
}
