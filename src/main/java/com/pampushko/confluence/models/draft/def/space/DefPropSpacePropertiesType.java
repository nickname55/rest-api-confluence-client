package com.pampushko.confluence.models.draft.def.space;

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
public class DefPropSpacePropertiesType extends BaseModel
{
	/**
	 * Пример: "Space Type"
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример: "object"
	 * <br>
	 */
	@SerializedName("type")
	String type;
}
