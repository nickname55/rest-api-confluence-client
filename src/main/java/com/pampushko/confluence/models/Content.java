package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br />
 */
@Data
@Slf4j
public class Content extends BaseModel
{
	/**
	 * Идентификатор области
	 * <br />
	 */
	private Long id;
	
	/**
	 * Ключ области, например {@literal "TEST"}.
	 * <br />
	 * Ключи областей могут содержать только латинские буквы и числа {@literal (A-Z, a-z, 0-9)}
	 * <br />
	 */
	private String key;
	
	/**
	 * Имя области
	 * <br />
	 */
	private String name;
	
	/**
	 * Описание области
	 * <br />
	 */
	private SpaceDescription description;
	
	/**
	 * Тип области
	 * <br />
	 */
	private String type;
	
	/**
	 * Статус области
	 * <br />
	 */
	private String status;
	
	//todo сделать _expandable;
	//todo сделать _links;
	
	public Content()
	{
	
	}
	
	public Content(String key)
	{
		this.key = key;
	}
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
