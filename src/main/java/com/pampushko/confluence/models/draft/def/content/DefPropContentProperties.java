package com.pampushko.confluence.models.draft.def.content;

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
public class DefPropContentProperties extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("id")
	DefPropContentPropertiesId id;
	
	/**
	 * <br>
	 */
	@SerializedName("type")
	DefPropContentPropertiesType type;
	
	/**
	 * <br>
	 */
	@SerializedName("status")
	DefPropContentPropertiesStatus status;
	
	/**
	 * <br>
	 */
	@SerializedName("title")
	DefPropContentPropertiesTitle title;
	
	/**
	 * <br>
	 */
	@SerializedName("space")
	DefPropContentPropertiesSpace space;
	
	/**
	 * <br>
	 */
	@SerializedName("history")
	DefPropContentPropertiesHistory history;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	DefPropContentPropertiesVersion version;
	
	/**
	 * <br>
	 */
	@SerializedName("ancestors")
	DefPropContentPropertiesAncestors ancestors;
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	DefPropContentPropertiesOperations operations;
	
	/**
	 * <br>
	 */
	@SerializedName("children")
	DefPropContentPropertiesChildren children;
	
	/**
	 * <br>
	 */
	@SerializedName("descendants")
	DefPropContentPropertiesDescendants descendants;
	
	/**
	 * <br>
	 */
	@SerializedName("container")
	DefPropContentPropertiesContainer container;
	
	/**
	 * <br>
	 */
	@SerializedName("body")
	DefPropContentPropertiesBody body;
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	DefPropContentPropertiesMetadata metadata;
	
	/**
	 * <br>
	 */
	@SerializedName("extensions")
	DefPropContentPropertiesExtensions extensions;
	
	/**
	 * <br>
	 */
	@SerializedName("restrictions")
	DefPropContentPropertiesRestrictions restrictions;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
