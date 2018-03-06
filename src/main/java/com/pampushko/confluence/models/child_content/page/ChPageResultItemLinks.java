package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChPageResultItemLinks extends BaseModel
{
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
