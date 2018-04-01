import com.pampushko.confluence.models.label.Label;
import com.pampushko.confluence.models.label.LabelResultList;
import com.pampushko.confluence.rest.Confluence;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class AddLabelsTest
{
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).userName(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//создаём список из меток
		List<Label> labels = new ArrayList<>();
		Label label1 = new Label("test1");
		Label label2 = new Label("test\\2");
		Label label3 = new Label("test/3");
		labels.add(label1);
		labels.add(label2);
		labels.add(label3);
		
		//выполняем запрос и печатаем результат
		LabelResultList labelResultList = confluence.addLabels(contentId, labels);
		System.out.println(labelResultList);
	}
}
