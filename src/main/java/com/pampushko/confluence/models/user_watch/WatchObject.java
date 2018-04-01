package com.pampushko.confluence.models.user_watch;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
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
public class WatchObject extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("watching")
	boolean watching;
}
