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
public class LongTaskLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net/wiki"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: "/wiki"
	 * <br>
	 */
	@SerializedName("context")
	String context;
}
