package com.pampushko.confluence.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 */
@Data
@Builder
@Slf4j
public class Extensions extends BaseModel
{
	/**
	 * Значение
	 * <br />
	 */
	@Builder.Default
	private String position = "none";
	
}
