import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import com.pampushko.confluence.utils.FilesUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class GetExportCSVFile
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//набор параметров - дата начала отбора записей (startDate)
		// и дата завершения отбора записей (endDate)
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("startDate", "2018-02-10");
				put("endDate", "2018-02-11");
			}
		};
		
		//создаем временную директорию и получаем имя этой временной директории
		final String directoryName = FilesUtils.getExternalFilesDir();
		log.info("directory name {}", directoryName);
		
		//выполняем запрос и сохраняем результаты запроса в файле, который помещаем во временную директорию
		// (имя файла получаем из HTTP-ответа)
		confluence.exportAudit(directoryName, params);
	}
}
