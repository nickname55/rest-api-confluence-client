import com.pampushko.confluence.models.audit.Audit;
import com.pampushko.confluence.models.audit.Author;
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

@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class CreateAuditTest
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
				put("limit", "2");
			}
		};
		
		Audit auditObj = Audit.builder()
				.author(
						Author.builder()
								.type("user")
								.displayName("Alexander Pampushko")
								.operations(null)
								.username("admin")
								.userKey("8a7f80835e12863a015e14c6d9910023")
								.build()
				)
				
				.remoteAddress("91.240.50.178")
				.creationDate(1518274997993L)
				.summary("я создал!")
				.description("я создал тестовую запись")
				.category("TEST")
				.sysAdmin(false)
				.build();
		Audit auditRecord = confluence.createAudit(auditObj);
		System.out.println(auditRecord);
	}

}
