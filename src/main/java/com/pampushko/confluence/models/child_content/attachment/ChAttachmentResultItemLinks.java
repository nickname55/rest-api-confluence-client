package com.pampushko.confluence.models.child_content.attachment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChAttachmentResultItemLinks extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("self")
	String self;
}
