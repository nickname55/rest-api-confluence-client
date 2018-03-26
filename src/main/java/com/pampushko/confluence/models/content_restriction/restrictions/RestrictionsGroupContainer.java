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
public class RestrictionsGroupContainer extends BaseModel
{
	@SerializedName("results")
	RestrictionForGroup[] results;
	/**
	 * Пример: 0
	 * <br>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * Пример: 200
	 * <br>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * Пример: 0
	 * <br>
	 */
	@SerializedName("size")
	long size;
}
