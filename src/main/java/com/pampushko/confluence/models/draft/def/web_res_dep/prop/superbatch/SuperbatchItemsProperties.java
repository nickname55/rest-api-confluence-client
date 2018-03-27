package com.pampushko.confluence.models.draft.def.web_res_dep.prop.superbatch;

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
public class SuperbatchItemsProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("uris")
	SuperbatchItemsPropertiesUris uris;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("tags")
	SuperbatchItemsPropertiesTags tags;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("metatags")
	SuperbatchItemsPropertiesMetatags metatags;
}
