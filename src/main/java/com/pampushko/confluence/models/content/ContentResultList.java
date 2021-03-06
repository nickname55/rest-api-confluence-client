package com.pampushko.confluence.models.content;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models._Links;
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
public class ContentResultList extends BaseModel
{
	@SerializedName("results")
	private Content[] results;
	
	/**
	 * <br>
	 */
	@SerializedName("start")
	private long start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	private long limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	private long size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private _Links links;
	
}
