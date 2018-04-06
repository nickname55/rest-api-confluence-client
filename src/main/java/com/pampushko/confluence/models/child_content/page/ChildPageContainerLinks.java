package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildPageContainerLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net/wiki"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: "/wiki"
	 * <br>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * <br>
	 */
	@SerializedName("tinyui")
	String tinyui;
	
	/**
	 * <br>
	 */
	@SerializedName("editui")
	String editui;
	
	/**
	 * <br>
	 */
	@SerializedName("webui")
	String webui;
}
