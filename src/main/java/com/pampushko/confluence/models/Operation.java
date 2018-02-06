package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class Operation extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("operation")
	String operation;
	
	/**
	 * <br />
	 */
	@SerializedName("targetType")
	String targetType;
}
