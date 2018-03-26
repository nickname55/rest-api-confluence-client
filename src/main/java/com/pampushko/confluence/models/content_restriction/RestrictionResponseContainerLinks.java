package com.pampushko.confluence.models.content_restriction;

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
public class RestrictionResponseContainerLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net/wiki/rest/api/content/5210113/restriction/byOperation"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
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
