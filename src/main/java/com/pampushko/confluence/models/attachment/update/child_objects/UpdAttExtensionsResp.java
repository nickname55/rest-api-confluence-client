package com.pampushko.confluence.models.attachment.update.child_objects;

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
public class UpdAttExtensionsResp
{
	/**
	 * Пример: "application/json"
	 * <br>
	 */
	String mediaType;
	
	/**
	 * Пример: 29
	 * <br>
	 */
	long fileSize;
	
	/**
	 * Пример: ""this is comment""
	 * <br>
	 */
	String comment;
}
