package com.pampushko.confluence.models.draft.def;

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
public class DefPropContainer extends BaseModel
{
	/**
	 * Пример: "Container"
	 * <br>
	 */
	String title;
	
	/**
	 * Пример: "object"
	 * <br>
	 */
	String type;
}
