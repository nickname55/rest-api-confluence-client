package com.pampushko.confluence.models.draft.def.content;

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
public class DefPropContent extends BaseModel
{
	/**
	 * Пример: "Content"
	 * <br>
	 */
	String title;
	
	/**
	 * Пример: "object"
	 * <br>
	 */
	String type;
	
	/**
	 * Пример:
	 * <br>
	 */
	DefPropContentProperties properties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	boolean additionalProperties;
}
