package com.pampushko.confluence.models.content_descendant;

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
public class DescendantResultLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/5210113/descendant"
	 * <br>
	 */
	String self;
	
	/**
	 * Пример: "https://java-java.atlassian.net"
	 * <br>
	 */
	String base;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String context;
}
