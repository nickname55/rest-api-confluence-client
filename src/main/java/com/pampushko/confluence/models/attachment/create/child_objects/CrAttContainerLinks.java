package com.pampushko.confluence.models.attachment.create.child_objects;

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
public class CrAttContainerLinks
{
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/5210113"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * Пример: "/x/AYBP"
	 * <br>
	 */
	@SerializedName("tinyui")
	String tinyui;
	
	/**
	 * Пример: "/pages/resumedraft.action?draftId=5210113"
	 * <br>
	 */
	@SerializedName("editui")
	String editui;
	
	/**
	 * Пример: "/spaces/4654313/pages/5210113/Change+Item"
	 * <br>
	 */
	@SerializedName("webui")
	String webui;
}
