package com.pampushko.confluence.models.draft.def.web_res_dep.prop.tags;

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
public class WrPropTags extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * todo добавить сериализатор-десериализатор для JSON
	 * Пример:
	 * <br>
	 */
	@SerializedName("patternProperties")
	String patternProperties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
