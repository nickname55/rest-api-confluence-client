package com.pampushko.confluence.models.child_content.comment;

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
public class ChildCommentExpandable extends BaseModel
{
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	/**
	 * Пример: "/rest/api/content/5210113"
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
	 * Пример: "/rest/api/content/171671553/child"
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * Пример: "/rest/api/content/171671553/restriction/byOperation"
	 * <br>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/171671553/history"
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
	 * Пример: "/rest/api/content/171671553/descendant"
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
