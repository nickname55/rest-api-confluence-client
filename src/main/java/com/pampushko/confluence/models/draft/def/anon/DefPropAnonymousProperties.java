package com.pampushko.confluence.models.draft.def.anon;

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
public class DefPropAnonymousProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("profilePicture")
	DefPropAnonymousPropertiesProfilePicture profilePicture;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("displayName")
	DefPropAnonymousPropertiesDisplayName displayName;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	DefPropAnonymousPropertiesType type;
}
