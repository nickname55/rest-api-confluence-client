package com.pampushko.confluence.models;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Builder
@Slf4j
public class Plain extends BaseModel
{
	/**
	 * Значение
	 * <br />
	 */
	@Builder.Default
	private String value = "";
	
	/**
	 * Формат представления данных размещенных в значении
	 * <br />
	 */
	@Builder.Default
	private String representation = "plain";
}
