package com.pampushko.confluence.models.child_content.attachment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildAttachmentContainerLinks extends BaseModel
{
	/**
	 *
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * <br>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 *
	 * <br>
	 */
	@SerializedName("self")
	String self;
}
