package com.pampushko.confluence.models.draft.def.space;

import com.google.gson.annotations.SerializedName;
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
public class DefPropSpacePropertiesDescription
{
	/**
	 * Пример: "object"
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * todo написать сериализацию-десериализацию для JSON
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
