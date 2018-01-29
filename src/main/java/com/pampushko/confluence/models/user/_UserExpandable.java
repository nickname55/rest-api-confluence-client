package com.pampushko.confluence.models.user;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class _UserExpandable extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br />
	 */
	@SerializedName("details")
	String details;
	
}
