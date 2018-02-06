package com.pampushko.confluence.models.user_watch;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class WatchObject extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("watching")
	boolean watching;
}
