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
@EqualsAndHashCode
@Slf4j
public class ContentResultList extends BaseModel
{
	@SerializedName("results")
	private Content[] results;
	
	/**
	 * <br>
	 */
	@SerializedName("start")
	private String start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	private String limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	private String size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private _Links links;
	
}
