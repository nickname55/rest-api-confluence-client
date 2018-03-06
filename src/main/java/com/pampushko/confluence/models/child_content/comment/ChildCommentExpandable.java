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
	 * <p>
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	/**
	 * Пример: "/rest/api/content/5210113"
	 * <p>
	 */
	@SerializedName("container")
	String container;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * Пример: "/rest/api/content/171671553/child"
	 * <p>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * Пример: "/rest/api/content/171671553/restriction/byOperation"
	 * <p>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/171671553/history"
	 * <p>
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	@SerializedName("version")
	String version;
	
	/**
	 * Пример: "/rest/api/content/171671553/descendant"
	 * <p>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <p>
	 */
	@SerializedName("space")
	String space;
}
