package com.pampushko.confluence.models.macros;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models._Links;
import lombok.extern.slf4j.Slf4j;

/**
 * Макрос (макросы могут быть частью тела страницы)
 * <br />
 */
@Slf4j
public class Macros extends BaseModel
{
	/**
	 * имя макроса
	 * <br />
	 */
	@SerializedName("name")
	String name;
	
	/**
	 * тело макроса
	 * <br />
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * <br />
	 */
	@SerializedName("parameters")
	Parameters parameters;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
}
