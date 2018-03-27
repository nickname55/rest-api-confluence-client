package com.pampushko.confluence.models.draft.def.space;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.draft.DraftTypeObject;
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
public class DefPropSpaceProperties
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("id")
	DraftTypeObject id;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("key")
	DraftTypeObject key;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("name")
	DraftTypeObject name;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("icon")
	DefPropSpacePropertiesIcon icon;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("description")
	DefPropSpacePropertiesDescription description;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("homepage")
	DefPropSpacePropertiesHomepage homepage;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	DefPropSpacePropertiesType type;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("metadata")
	DefPropSpaceMetadata metadata;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
