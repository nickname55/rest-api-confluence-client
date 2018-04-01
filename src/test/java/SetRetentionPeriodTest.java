import com.pampushko.confluence.models.audit.RetentionPeriod;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
@Slf4j
public class SetRetentionPeriodTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//создаём текущий retention период
		RetentionPeriod retentionPeriod = RetentionPeriod.builder().number(3).units("YEARS").build();
		
		//устанавливаем текущий retention period
		RetentionPeriod retentionPeriodOfAudit = confluence.setRetentionPeriodOfAudit(retentionPeriod);
		System.out.println(retentionPeriodOfAudit);
	}
}
