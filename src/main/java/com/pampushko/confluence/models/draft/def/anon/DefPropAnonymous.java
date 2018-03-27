package com.pampushko.confluence.models.draft.def.anon;

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
public class DefPropAnonymous extends BaseModel
{
	/**
	 * Пример: "Anonymous"
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
	 * todo - object!
	 * <br>
	 */
	DefPropAnonymousProperties properties;
	
	/**
	 * Пример: false
	 * <br>
	 */
	boolean additionalProperties;
}
