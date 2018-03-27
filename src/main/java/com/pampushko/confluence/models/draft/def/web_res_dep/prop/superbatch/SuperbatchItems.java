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
public class SuperbatchItems extends BaseModel
{
	/**
	 * Пример: "Super Batch Web Resources"
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
	
	/**
	 * todo добавить сериализатор-десериализатор для свойства
	 * Пример:
	 * <br>
	 */
	@SerializedName("properties")
	SuperbatchItemsProperties properties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
