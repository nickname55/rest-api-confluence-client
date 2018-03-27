package com.pampushko.confluence.models.draft.def.web_res_dep.prop;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.contexts.WrPropContexts;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.keys.WrPropKeys;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.superbatch.WrPropSuperbatch;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.tags.WrPropTags;
import com.pampushko.confluence.models.draft.def.web_res_dep.prop.uris.WrPropUris;
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
public class WrProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("keys")
	WrPropKeys keys;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("contexts")
	WrPropContexts contexts;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("uris")
	WrPropUris uris;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("tags")
	WrPropTags tags;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("superbatch")
	WrPropSuperbatch superbatch;
}
