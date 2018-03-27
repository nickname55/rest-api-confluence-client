package com.pampushko.confluence.models.draft.def.known_user;

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
public class DefPropKnownUser extends BaseModel
{
	/**
	 * Пример: "Known User"
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример: "object"
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("properties")
	DefPropKnownUserProperties properties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
	
}
