import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.content.Content;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import com.pampushko.confluence.utils.ContentUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class CreateContentTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<String, String>()
		{
			{
			
			}
		};
		
		Space space = confluence.getSpaceByKey("KARMA");
		Content page = ContentUtils.createNewContent();
		page.setSpace(space);
		Content content = confluence.createContent(page, params);
		System.out.println(content);
	}
	
}
