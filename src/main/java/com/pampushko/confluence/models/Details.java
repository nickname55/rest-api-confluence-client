package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Детали юзера user.details
 */
@Slf4j
public class Details
{
	/**
	 * <br />
	 */
	@SerializedName("business") //expand
	String business;
	
	/**
	 * <br />
	 */
	@SerializedName("personal") //expand
	String personal;
	
	//----------------------------------------------------------
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_DetailsExpandable expandable;
	
}
