package com.pampushko.confluence.models.user;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.ProfilePicture;
import com.pampushko.confluence.models._Links;
import lombok.extern.slf4j.Slf4j;

/**
 * Элемент содержащий группу пользователей Confluence
 * <br>
 */
@Slf4j
public class User extends BaseModel
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
	_UserExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	_Links links;
	
}
