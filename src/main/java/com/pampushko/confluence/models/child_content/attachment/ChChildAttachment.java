package com.pampushko.confluence.models.child_content.attachment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChChildAttachment extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("results")
	ChAttachmentResultItem[] results;
	
	/**
	 * <p>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * <p>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * <p>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	ChAttachmentResultItemLinks links;
}
