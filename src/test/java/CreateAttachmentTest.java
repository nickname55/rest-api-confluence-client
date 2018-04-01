import com.google.common.io.Resources;
import com.pampushko.confluence.models.attachment.create.CreateAttResponseContainer;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class CreateAttachmentTest
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
		
		//это файл который мы хотим добавить как вложение к странице
		final URL fileUrl = Resources.getResource("1.json");
		File file = new File(fileUrl.getPath());
		
		//это комментарий, который мы добавим к вкладываемому файлу
		final String comment = "this is comment";
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//тип контента файла
		final String contentType = "application/json";
		
		//1) заворачиваем содержимое файла в объект RequestBody
		RequestBody fileBody = RequestBody.create(MediaType.parse(contentType), file);
		
		//имя с которым мы добавим вложение к странице
		String fileName = file.getName();
		
		//2) заворачиваем тело файла (RequestBody) и имя файла (fileName) в MultipartBody.Part
		// MultipartBody.Part используется для передачи имени файла вместе с его телом в Retrofit 2
		
		//Тут важно обратить внимание (!), что первый параметром обязательно должна быть строка "file"
		//Это требование Confluence Server REST API : The name of the multipart/form-data parameter that contains attachments must be "file"
		MultipartBody.Part fileBodyAndFileName =
				MultipartBody.Part.createFormData("file", fileName, fileBody);
		
		//выполняем запрос и печатаем результат
		CreateAttResponseContainer responseContainer = confluence.createAttachment(contentId, fileBodyAndFileName, comment, params);
		System.out.println(responseContainer);
	}
	
}
