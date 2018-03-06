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
	 * <p>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: "/wiki"
	 * <p>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 * <p>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * <p>
	 */
	@SerializedName("tinyui")
	String tinyui;
	
	/**
	 * <p>
	 */
	@SerializedName("editui")
	String editui;
	
	/**
	 * <p>
	 */
	@SerializedName("webui")
	String webui;
}
