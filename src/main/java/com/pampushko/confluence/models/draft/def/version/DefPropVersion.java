package com.pampushko.confluence.models.draft.def.version;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
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
@Slf4j
public class DefPropVersion extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("properties")
	DefPropVersionProperties properties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
	
	/**
	 * Пример: 0 : "number", 1 : "minorEdit", 2 : "hidden"
	 * <br>
	 */
	@SerializedName("required")
	String[] required;
	
}
