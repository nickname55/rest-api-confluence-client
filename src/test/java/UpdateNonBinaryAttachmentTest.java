import com.pampushko.confluence.models.Version;
import com.pampushko.confluence.models.attachment.update.UpdAttRequest;
import com.pampushko.confluence.models.attachment.update.UpdAttResponse;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Обновление <strong>НЕ</strong> бинарных данных вложения (комментарий, media-type, filename, parent container)
 */
@Slf4j
public class UpdateNonBinaryAttachmentTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<String, String>()
		{
			{
			
			}
		};
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//идентификатор вложения, не бинарные данные которого мы хотим обновить
		final String attachmentId = "att184451088";
		
		final UpdAttRequest requestBody = new UpdAttRequest();
		requestBody.setTitle("new long beautiful filename.json"); //новое имя файла-вложения
		requestBody.setId(attachmentId);
		Version version = new Version();
		version.setNumber(1L); //версия файла, которую мы будем обновлять
		requestBody.setVersion(version);
		
		//выполняем запрос и печатаем результат
		UpdAttResponse updateAttachmentResponse = confluence.updateAttachment(contentId, attachmentId, requestBody, params);
		System.out.println(updateAttachmentResponse);
	}
}
