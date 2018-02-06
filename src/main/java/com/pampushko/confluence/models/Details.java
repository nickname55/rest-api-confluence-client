package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Детали юзера user.details
 */
@Slf4j
public class Details extends BaseModel
{
	/**
	 * <br />
	 * expandable
	 */
	@SerializedName("business")
	String business;
	
	/**
	 * <br />
	 * expandable
	 */
	@SerializedName("personal")
	String personal;
	
	//----------------------------------------------------------
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_DetailsExpandable expandable;
	
}
