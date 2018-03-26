package com.pampushko.confluence.models.content_restriction.restrictions;

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
public class RestrictionForUserExpandable extends BaseModel
{
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("details")
	String details;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("personalSpace")
	String personalSpace;
}
