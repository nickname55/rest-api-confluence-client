package com.pampushko.confluence.models.draft.def.version;

import com.google.gson.annotations.SerializedName;
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
public class DefPropVersionProperties
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("by")
	DraftRef by;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("when")
	DraftTypeObject when;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("message")
	DraftTypeObject message;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("number")
	DraftTypeObject number;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("minorEdit")
	DraftTypeObject minorEdit;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("hidden")
	DraftTypeObject hidden;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("syncRev")
	DraftTypeObject syncRev;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content")
	DefPropVersionPropertiesContent content;
}
