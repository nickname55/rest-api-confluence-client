package com.pampushko.confluence.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Slf4j
public class Plain extends BaseModel
{
	public Plain()
	{
	
	}
	
	public Plain(String value)
	{
		this.value = value;
	}
	
	public Plain(String value, String representation)
	{
		this.value = value;
		this.representation = representation;
	}
	
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
	
	//todo embeddedContent  Array[0]
}
