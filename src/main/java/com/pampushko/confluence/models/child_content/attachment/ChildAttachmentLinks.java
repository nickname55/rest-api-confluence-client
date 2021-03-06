package com.pampushko.confluence.models.child_content.attachment;

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
public class ChildAttachmentLinks extends BaseModel
{
	/**
	 * Пример: "/spaces/4654313/pages/5210113/Change+Item?preview=%2F5210113%2F172261377%2FIdeaProject.png"
	 * <br>
	 */
	@SerializedName("webui")
	String webui;
	
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/att172261377"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * Пример: "/download/attachments/5210113/IdeaProject.png?version=1&amp;modificationDate=1520279647763&amp;cacheVersion=1&amp;api=v2"
	 * <br>
	 */
	@SerializedName("download")
	String download;
}
