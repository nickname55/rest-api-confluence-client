package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class By extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * <br>
	 */
	@SerializedName("username")
	String username;
	
	/**
	 * <br>
	 */
	@SerializedName("userKey")
	String userKey;
	
	/**
	 * <br>
	 */
	@SerializedName("accountId")
	String accountId;
	
	/**
	 * <br>
	 */
	@SerializedName("profilePicture")
	ProfilePicture profilePicture;
	
	/**
	 * <br>
	 */
	@SerializedName("displayName")
	String displayName;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	_ByExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	ByLinks links;
}
