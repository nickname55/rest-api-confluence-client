package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildCommentResultItemLinks extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("self")
	String self;
}
