import com.pampushko.confluence.models.content.ContentContainter;
import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class GetSpaceContentTest
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args) throws IOException
	{
		test();
	}
	
	private static void test() throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		Space resultSpace = null;
		
		SpaceResultList spaces = confluence.getSpaces();
		for (Space space : spaces.getSpaces())
		{
			System.out.println(space);
		}
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				//получаем только контент из главной страницы (передавая параметр depth)
				put("depth", "all");
			}
		};
		ContentContainter spaceContent = confluence.getSpaceContent("MYR", params);
		System.out.println(spaceContent);
		//System.out.println(spaceContent.getPage().getPageResultItems()[0].getTitle());
	}
	
}
