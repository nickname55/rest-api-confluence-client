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
public class UpdAttMetadataExpandable
{
	/**
	 * Пример: ""
	 * <br>
	 */
	String currentuser;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String properties;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String frontend;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	String likes;
}
