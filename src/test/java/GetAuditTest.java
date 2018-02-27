import com.pampushko.confluence.models.audit.AuditResultList;
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

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class GetAuditTest
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
				put("limit", "22");
			}
		};
		AuditResultList auditResultList = confluence.getAudit(params);
		System.out.println(auditResultList);
	}
	
}
