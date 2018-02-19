import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import com.pampushko.confluence.models.content.ContentResultList;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 */
@Slf4j
public class GetContentTest
{
	
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		Space resultSpace = null;
		
		SpaceResultList spaces = confluence.getSpaces();
		for (Space space : spaces.getSpaces())
		{
			System.out.println(space);
		}
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("spaceKey", "KARMA");
			}
		};
		ContentResultList contentResultList = confluence.getContent(params);
		System.out.println(contentResultList);
	}
}

