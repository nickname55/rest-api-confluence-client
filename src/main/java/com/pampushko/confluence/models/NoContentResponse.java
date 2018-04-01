package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Ответ без контента
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class NoContentResponse extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("statusCode")
	private int statusCode;
	
	/**
	 * <br>
	 */
	@SerializedName("message")
	private String message;
	
	/**
	 * <br>
	 */
	@SerializedName("data")
	private ResponseData data;
}
