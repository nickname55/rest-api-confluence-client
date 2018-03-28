import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.convert.req.ContentBody;
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
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ConvertTest extends BaseModel
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//создаём объект с контентом, который мы хотим конвертировать в другой формат
		final ContentBody contentBody = new ContentBody();
		contentBody.setValue("<p>Some example body in storage format</p>");
		contentBody.setRepresentation("storage");
		
		//выполняем запрос и печатаем результат
		Object result = confluence.convert(contentBody, "export_view");
		System.out.println(result);
	}
}
