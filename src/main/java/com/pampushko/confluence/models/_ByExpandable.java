package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class _ByExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br>
	 */
	@SerializedName("details")
	String details;
	
	/**
	 * <br>
	 */
	@SerializedName("personalSpace")
	String personalSpace;
	
}
