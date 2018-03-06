package com.pampushko.confluence.models.child_content.attachment;

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
@EqualsAndHashCode
@Slf4j
public class ChAttachmentExpandable
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
	@SerializedName("operations")
	String operations;
	
	/**
	 * Пример: "/rest/api/content/att172261377/child"
	 * <p>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * Пример: "/rest/api/content/att172261377/restriction/byOperation"
	 * <p>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/att172261377/history"
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
	 * Пример: "/rest/api/content/att172261377/descendant"
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
