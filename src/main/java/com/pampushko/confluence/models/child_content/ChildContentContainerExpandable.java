package com.pampushko.confluence.models.child_content;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ChildContentContainerExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("attachment")
	String attachment;
	
	/**
	 * <br>
	 */
	@SerializedName("comment")
	String comment;
	
	/**
	 * <br>
	 */
	@SerializedName("page")
	String page;
}
