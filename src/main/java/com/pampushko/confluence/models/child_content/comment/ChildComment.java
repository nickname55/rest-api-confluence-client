package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@Slf4j
public class ChildComment extends BaseModel
{
	/**
	 * todo проверить что все свойства мапятся
	 * <br>
	 */
	@SerializedName("results")
	ChildCommentContainer[] results;
	
	/**
	 * <br>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	ChildCommentContainerLinks links;
	
}
