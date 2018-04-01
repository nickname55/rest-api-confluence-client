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
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ResponseErrorMessage extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("translation")
	private String translation;
	
	/**
	 * <br>
	 */
	@SerializedName("args")
	private String[] args;
}
