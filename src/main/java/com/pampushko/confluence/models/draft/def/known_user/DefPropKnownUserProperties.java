package com.pampushko.confluence.models.draft.def.known_user;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.DraftRef;
import com.pampushko.confluence.models.draft.DraftTypeObject;
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
public class DefPropKnownUserProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("profilePicture")
	DraftRef profilePicture;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("displayName")
	DraftTypeObject displayName;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("username")
	DraftTypeObject username;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("status")
	DefPropKnownUserPropertiesStatus status;
}
