package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
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
public class ResponseData extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("authorized")
	private boolean authorized;
	
	/**
	 * <br />
	 */
	@SerializedName("valid")
	private boolean valid;
	
	/**
	 * <br />
	 */
	@SerializedName("errors")
	private ResponseErrorMessageContainer[] errors;
	
	/**
	 * <br />
	 */
	@SerializedName("successful")
	private boolean successful;
}
