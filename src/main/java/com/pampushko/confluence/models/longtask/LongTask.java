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
public class LongTask extends BaseModel
{
	/**
	 * Пример: "173998183"
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("name")
	LongTaskName name;
	
	/**
	 * Пример: 1698
	 * <br>
	 */
	@SerializedName("elapsedTime")
	long elapsedTime;
	
	/**
	 * Пример: 100
	 * <br>
	 */
	@SerializedName("percentageComplete")
	int percentageComplete;
	
	/**
	 * Пример: true
	 * <br>
	 */
	@SerializedName("successful")
	boolean successful;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("messages")
	LongTaskMessage[] messages;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	LongTaskLinks links;
}
