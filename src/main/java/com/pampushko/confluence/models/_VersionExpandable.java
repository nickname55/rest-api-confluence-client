package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class _VersionExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("collaborators")
	String collaborators;
	
	/**
	 * <br>
	 */
	@SerializedName("content")
	String content;
	
	/**
	 * todo добавил как expandable для функции UpdateAttachment
	 * <br>
	 */
	@SerializedName("status")
	String status;
}
