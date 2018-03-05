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
@EqualsAndHashCode
@Slf4j
public class CommentLinks extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("webui")
	String webui;
	
	/**
	 * <p>
	 */
	@SerializedName("self")
	String self;
}
