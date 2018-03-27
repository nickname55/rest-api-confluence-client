package com.pampushko.confluence.models.draft.def.content_restriction;

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
public class DefPropContentRestrictionProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content")
	DefPropContentRestrictionPropertiesContent content;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operation")
	DefPropContentRestrictionPropertiesOperation operation;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("restrictions")
	DefPropContentRestrictionPropertiesRestrictions restrictions;
}
