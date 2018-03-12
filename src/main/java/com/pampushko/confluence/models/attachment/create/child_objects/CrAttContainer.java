package com.pampushko.confluence.models.attachment.create.child_objects;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
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
public class CrAttContainer extends BaseModel
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
	@SerializedName("macroRenderedOutput")
	CrAttContainerMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <p>
	 */
	@SerializedName("extensions")
	CrAttContainerExtensions extensions;
	
	/**
	 * <p>
	 */
	@SerializedName("_expandable")
	CrAttContainerExpandable expandable;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	CrAttContainerLinks links;
	
}
