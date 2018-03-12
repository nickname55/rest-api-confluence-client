package com.pampushko.confluence.models.attachment.update.child_objects;

import com.google.gson.annotations.SerializedName;
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
public class UpdAttExpandableReq
{
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <br>
	 */
	@SerializedName("container")
	String container;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * Пример: "/rest/api/content/5210113/child"
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * Пример: "/rest/api/content/5210113/restriction/byOperation"
	 * <br>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/5210113/history"
	 * <br>
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("version")
	String version;
	
	/**
	 * Пример: "/rest/api/content/5210113/descendant"
	 * <br>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <br>
	 */
	@SerializedName("space")
	String space;
}
