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
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример: "page"
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример: "current"
	 * <br>
	 */
	@SerializedName("status")
	String status;
	
	/**
	 * Пример: "Change Item"
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * <br>
	 */
	@SerializedName("space")
	String space;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * <br>
	 */
	@SerializedName("ancestors")
	String[] ancestors;
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String[] operations;
	
	
	/**
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	
	/**
	 * <br>
	 */
	@SerializedName("descendants")
	UpdAttDescendants descendants;
	
	
	/**
	 * <br>
	 */
	@SerializedName("container")
	UpdAttContainer container;
	
	
	/**
	 * <br>
	 */
	@SerializedName("body")
	UpdAttBody body;
	
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	UpdAttMetadata metadata;
	
	
	/**
	 * <br>
	 */
	@SerializedName("restrictions")
	UpdAttRestrictions restrictions;
	
	/**
	 * <br>
	 */
	@SerializedName("macroRenderedOutput")
	UpdAttMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <br>
	 */
	@SerializedName("extensions")
	Extensions extensions;
	
	@SerializedName("_expandable")
	UpdAttExpandableReq expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	UpdAttLinksReq links;
	
}
