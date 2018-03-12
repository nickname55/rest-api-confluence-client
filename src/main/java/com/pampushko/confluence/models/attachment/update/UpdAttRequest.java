package com.pampushko.confluence.models.attachment.update;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.Version;
import com.pampushko.confluence.models.attachment.update.child_objects.*;
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
public class UpdAttRequest extends BaseModel
{
	/**
	 * Пример : "att5678"
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример: "attachment"
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
	 * Пример: "myfile.txt"
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("ancestors")
	UpdAttAncestor[] ancestors;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operations")
	UpdAttrOperation[] operations;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("children")
	UpdAttChildren children;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("descendants")
	UpdAttDescendants descendants;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("container")
	UpdAttContainer container;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("body")
	UpdAttBody body;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("metadata")
	UpdAttMetadata metadata;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("restrictions")
	UpdAttRestrictions restrictions;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	UpdAttLinksReq links;
}
