package com.pampushko.confluence.models.attachment.item;

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
public class AttContainerExpandable extends BaseModel
{
	/**
	 * Пример: ""
	 * <p>
	 */
	String childTypes;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <p>
	 */
	String container;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	String metadata;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	String operations;
	
	/**
	 * Пример: "/rest/api/content/5210113/child"
	 * <p>
	 */
	String children;
	
	/**
	 * Пример: "/rest/api/content/5210113/restriction/byOperation"
	 * <p>
	 */
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/5210113/history"
	 * <p>
	 */
	String history;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	String ancestors;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	String body;
	
	/**
	 * Пример: ""
	 * <p>
	 */
	String version;
	
	/**
	 * Пример: "/rest/api/content/5210113/descendant"
	 * <p>
	 */
	String descendants;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <p>
	 */
	String space;
}
