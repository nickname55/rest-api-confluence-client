package com.pampushko.confluence.models.child_content.comment;

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
public class ChildCommentLinks extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("webui")
	String webui;
	
	/**
	 * <br>
	 */
	@SerializedName("self")
	String self;
}
