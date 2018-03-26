package com.pampushko.confluence.models.content_restriction.restrictions;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.ProfilePicture;
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
public class RestrictionForUser extends BaseModel
{
	/**
	 * Пример: "known"
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * "administrator"
	 * <br>
	 */
	@SerializedName("username")
	String username;
	
	/**
	 * Пример: "1a1f80131112363a315e14c6d9911111"
	 * <br>
	 */
	@SerializedName("userKey")
	String userKey;
	
	/**
	 * Пример: "550058:649888af-0a0a-4a2a-b35d-caef000732f0"
	 * <br>
	 */
	@SerializedName("accountId")
	String accountId;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("profilePicture")
	ProfilePicture profilePicture;
	
	/**
	 * Пример: "Alexander Ivanov"
	 * <br>
	 */
	@SerializedName("displayName")
	String displayName;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	RestrictionForUserExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	RestrictionForUserLinks links;
}
