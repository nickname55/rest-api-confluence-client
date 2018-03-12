package com.pampushko.confluence.models.attachment.update.child_objects;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.Extensions;
import com.pampushko.confluence.models.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class UpdAttContainer extends BaseModel
{
	/**
	 * Пример: "5210113"
	 * <p>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример: "page"
	 * <p>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример: "current"
	 * <p>
	 */
	@SerializedName("status")
	String status;
	
	/**
	 * Пример: "Change Item"
	 * <p>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * <p>
	 */
	@SerializedName("space")
	String space;
	
	/**
	 * <p>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * <p>
	 */
	@SerializedName("ancestors")
	String[] ancestors;
	
	/**
	 * <p>
	 */
	@SerializedName("operations")
	String[] operations;
	
	
	/**
	 * <p>
	 */
	@SerializedName("children")
	String children;
	
	
	/**
	 * <p>
	 */
	@SerializedName("descendants")
	UpdAttDescendants descendants;
	
	
	/**
	 * <p>
	 */
	@SerializedName("container")
	UpdAttContainer container;
	
	
	/**
	 * <p>
	 */
	@SerializedName("body")
	UpdAttBody body;
	
	
	/**
	 * <p>
	 */
	@SerializedName("metadata")
	UpdAttMetadata metadata;
	
	
	/**
	 * <p>
	 */
	@SerializedName("restrictions")
	UpdAttRestrictions restrictions;
	
	/**
	 * <p>
	 */
	@SerializedName("macroRenderedOutput")
	UpdAttMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <p>
	 */
	@SerializedName("extensions")
	Extensions extensions;
	
	@SerializedName("_expandable")
	UpdAttExpandableReq expandable;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	UpdAttLinksReq links;
	
}
