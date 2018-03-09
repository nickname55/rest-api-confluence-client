package com.pampushko.confluence.models.attachment.item;

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
public class AttContainer extends BaseModel
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
	AttContainerMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <p>
	 */
	@SerializedName("extensions")
	AttContainerExtensions extensions;
	
	/**
	 * <p>
	 */
	@SerializedName("_expandable")
	AttContainerExpandable expandable;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	AttContainerLinks links;
	
}
