package com.pampushko.confluence.models.user_watch;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class WatchObject
{
	/**
	 * <br />
	 */
	@SerializedName("watching")
	boolean watching;
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
