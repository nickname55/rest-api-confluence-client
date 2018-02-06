package com.pampushko.confluence.custom_deserialazers;

import com.google.gson.*;
import com.pampushko.confluence.models.macros.Parameters;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Сериализатор/десериализатор для параметров макросов в Confluence,
 * <br />
 * Необходим, так как у различных макросов может быть различный набор параметров
 * <br />
 * И, соответственно, не получается создать универсальный объект Properties,
 * <br />
 * который содержал бы свойства всех макросов,
 * <br />
 * потому мы создаем объект Properties с одним свойством типа Map
 * <br />
 * и в это свойство помещаем/извлекаем значения properties макросов
 * <br />
 * Таким образом нам не важно какие бывают у макросов properties.
 * <br />
 */
@Slf4j
public class MacrosParameterJsonAdapter implements JsonDeserializer<Parameters>, JsonSerializer<Parameters>
{
	@Override
	public Parameters deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		Parameters parameters = new Parameters();
		if (json.isJsonObject())
		{
			JsonObject jsonObject = json.getAsJsonObject();
			
			Map<String, String> result = new HashMap<>();
			for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet())
			{
				String propValue = "";
				JsonElement propertyObject = entry.getValue();
				if (propertyObject.isJsonObject())
				{
					JsonObject jsonPropertyObject = propertyObject.getAsJsonObject();
					JsonElement valueOfProperty = jsonPropertyObject.get("value");
					if (valueOfProperty.isJsonPrimitive())
					{
						propValue = valueOfProperty.getAsString();
					}
				}
				result.put(entry.getKey(), propValue);
			}
			parameters.setParam(result);
		}
		return parameters;
	}
	
	@Override
	public JsonElement serialize(Parameters sourceObject, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject resutlJsonObject = new JsonObject(); //extend JsonElement
		Map<String, String> param = sourceObject.getParam();
		Gson gson = new Gson();
		for (Map.Entry<String, String> entry : param.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			JsonObject propertyValueJsonObj = new JsonObject();
			propertyValueJsonObj.addProperty("value", value);
			resutlJsonObject.add(key, propertyValueJsonObj);
		}
		return resutlJsonObject;
	}
}
