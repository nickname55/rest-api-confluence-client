package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildComment extends BaseModel
{
	/**
	 * todo проверить что все свойства мапятся
	 * <p>
	 */
	@SerializedName("results")
	CommentResultItem[] results;
	
	/**
	 * <p>
	 */
	@SerializedName("start")
	String start;
	
	/**
	 * <p>
	 */
	@SerializedName("limit")
	String limit;
	
	/**
	 * <p>
	 */
	@SerializedName("size")
	String size;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	CommentResultItemLinks links;
	
}
