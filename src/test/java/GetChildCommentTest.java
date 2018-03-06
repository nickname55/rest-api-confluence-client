import com.pampushko.confluence.models.child_content.ChildContentResult;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class GetChildCommentTest
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
				put("expand", "page,attachment,comment");
			}
		};
		
		final String contentId = "5210113";
		ChildContentResult contentResultList = confluence.getChild(contentId, params);
		System.out.println(contentResultList);
	}
}
