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
	@SerializedName("macroRenderedOutput")
	CrAttContainerMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <br>
	 */
	@SerializedName("extensions")
	CrAttContainerExtensions extensions;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	CrAttContainerExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	CrAttContainerLinks links;
	
}
