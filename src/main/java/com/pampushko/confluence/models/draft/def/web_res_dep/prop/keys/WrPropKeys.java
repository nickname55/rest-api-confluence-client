package com.pampushko.confluence.models.draft.def.web_res_dep.prop.keys;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.WrPropertiesKeysItems;
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
public class WrPropKeys extends BaseModel
{
	/**
	 * Пример: "array"
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * <br>
	 */
	@SerializedName("items")
	WrPropertiesKeysItems items;
}
