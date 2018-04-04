package com.pampushko.confluence.models.longtask;

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
public class LongTaskListResultContainer extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("results")
	LongTask[] results;
	
	/**
	 * Пример: 0
	 * <br>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * Пример: 100
	 * <br>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * Пример: 2
	 * <br>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	LongTaskListResultContainerLinks links;
}
