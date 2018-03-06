package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChChildComment extends BaseModel
{
	/**
	 * todo проверить что все свойства мапятся
	 * <p>
	 */
	@SerializedName("results")
	ChCommentResultItem[] results;
	
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
	ChCommentResultItemLinks links;
	
}
