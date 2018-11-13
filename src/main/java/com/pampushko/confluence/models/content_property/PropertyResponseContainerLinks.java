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
public class PropertyResponseContainerLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/5210113/property/hello"
	 * <br>
	 */
	@SerializedName("self")
	String self;
}
