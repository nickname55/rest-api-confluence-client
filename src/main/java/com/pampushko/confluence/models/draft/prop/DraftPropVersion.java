package com.pampushko.confluence.models.draft.prop;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.DraftRef;
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
public class DraftPropVersion extends BaseModel
{
	/**
	 * Пример: "array"
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("items")
	DraftRef items;
}
