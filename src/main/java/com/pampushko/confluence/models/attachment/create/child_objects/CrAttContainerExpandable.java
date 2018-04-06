package com.pampushko.confluence.models.attachment.create.child_objects;

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
public class CrAttContainerExpandable extends BaseModel
{
	/**
	 * Пример: ""
	 * <br>
	 */
	String childTypes;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <br>
	 */
	String container;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String metadata;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String operations;
	
	/**
	 * Пример: "/rest/api/content/5210113/child"
	 * <br>
	 */
	String children;
	
	/**
	 * Пример: "/rest/api/content/5210113/restriction/byOperation"
	 * <br>
	 */
	String restrictions;
	
	/**
	 * Пример: "/rest/api/content/5210113/history"
	 * <br>
	 */
	String history;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String ancestors;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String body;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String version;
	
	/**
	 * Пример: "/rest/api/content/5210113/descendant"
	 * <br>
	 */
	String descendants;
	
	/**
	 * Пример: "/rest/api/space/4654313"
	 * <br>
	 */
	String space;
}
