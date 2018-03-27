package com.pampushko.confluence.models.draft.def.icon;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
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
public class DefPropIconProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("path")
	DraftTypeObject path;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("width")
	DraftTypeObject width;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("height")
	DraftTypeObject height;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("isDefault")
	DraftTypeObject isDefault;
	
}
