package com.pampushko.confluence.models.history;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.ProfilePicture;
import com.pampushko.confluence.models._Links;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode
@Slf4j
public class By extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("type")
	String type; //"known"
	
	/**
	 * <br>
	 */
	@SerializedName("username")
	String username; //"admin"
	
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
	String displayName; //"Alexander Ivanov"
	
	/**
	 * todo подходит ли для этого объекта _ByExpandable тип?
	 * <br>
	 */
	@SerializedName("_expandable")
	_ByExpandableHistory expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	_Links links;
}