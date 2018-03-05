package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.PageResultItem;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildPage extends BaseModel
{
	/**
	 * todo дописать
	 * <p>
	 */
	@SerializedName("results")
	PageResultItem[] results;
	
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
	PageResultItemLink links;
}
