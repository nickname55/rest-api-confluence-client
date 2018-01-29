package com.pampushko.confluence.custom_deserialazers;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * десериализатор для свойств, содержащихся в _expandable объекте ответа
 * <br />
 * свойства содержащиеся в expandable включаются в состав объекта-модели,
 * <br />
 * но, если это свойство отсутствует в ответе, то возникает исключение, генерируемого стандартным десериализатором
 * <br />
 * А свойство появляется в ответе в зависимости от того указали ли мы
 * <br />
 * необходимость вернуть это свойство при помощи параметра запроса expand
 * <br />
 * Потому мы используем специальный десериализатор,
 * <br />
 * которые проверяет можно ли создать объект на основании имеющихся в ответе данных,
 * <br />
 * и если это возможно - то объект создается,
 * <br />
 * а если невозможно - то вместо объекта возвращается null
 * <br />
 */
@Slf4j
public class ExpandablePropDeserializer<T> implements JsonDeserializer<T>
{
	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		if (json.isJsonObject())
		{
			return new Gson().fromJson(json, typeOfT);
		}
		else
		{
			return null;
		}
	}
}
