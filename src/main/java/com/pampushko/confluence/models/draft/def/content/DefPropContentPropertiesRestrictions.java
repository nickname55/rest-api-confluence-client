package com.pampushko.confluence.models.draft.def.content;

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
public class DefPropContentPropertiesRestrictions extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * todo добавить сериализатор-десериализатор для JSON
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
