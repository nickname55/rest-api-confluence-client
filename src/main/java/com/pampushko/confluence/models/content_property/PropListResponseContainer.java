package com.pampushko.confluence.models.content_property;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class PropListResponseContainer extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("results")
	PropResponse[] results;
	
	/**
	 * Пример: 0
	 * <br>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * Пример: 10
	 * <br>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * Пример: 5
	 * <br>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	PropResponseContainerLinks links;
}
