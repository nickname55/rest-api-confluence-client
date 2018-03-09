package com.pampushko.confluence.models.attachment.item;

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
public class AttContainerLinks
{
	/**
	 * Пример: "https://java-java.atlassian.net/wiki/rest/api/content/5210113"
	 * <p>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * Пример: "/x/AYBP"
	 * <p>
	 */
	@SerializedName("tinyui")
	String tinyui;
	
	/**
	 * Пример: "/pages/resumedraft.action?draftId=5210113"
	 * <p>
	 */
	@SerializedName("editui")
	String editui;
	
	/**
	 * Пример: "/spaces/4654313/pages/5210113/Change+Item"
	 * <p>
	 */
	@SerializedName("webui")
	String webui;
}
