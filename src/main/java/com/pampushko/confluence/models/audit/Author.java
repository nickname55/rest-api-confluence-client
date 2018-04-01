package com.pampushko.confluence.models.audit;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@Slf4j
public class Author extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * <br>
	 */
	@SerializedName("displayName")
	String displayName;
	
	/**
	 * todo  - в данный момент это свойство почему отствутствует в получаяемом в результате запроса JSON-не, а должно быть "operations": null, как я вижу ответе на запрос, выполняемом без Retrofit-клиента
	 * <br>
	 */
	@SerializedName("operations")
	Operations operations;
	
	/**
	 * <br>
	 */
	@SerializedName("username")
	String username;
	
	/**
	 * <br>
	 */
	@SerializedName("userKey")
	String userKey;
}
