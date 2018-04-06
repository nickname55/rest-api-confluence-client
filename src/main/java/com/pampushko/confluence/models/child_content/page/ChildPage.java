package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildPage extends BaseModel
{
	/**
	 * todo дописать
	 * <br>
	 */
	@SerializedName("results")
	ChildPageContainer[] results;
	
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
	ChildPageContainerLinks links;
}
