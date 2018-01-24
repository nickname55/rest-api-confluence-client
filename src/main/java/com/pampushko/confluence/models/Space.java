package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import lombok.Data;

/**
 * Класс модель для области Confluence (Space)
 * <br />
 */
@Data
public class Space extends BaseModel
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
	
	public Space()
	{
	
	}
	
	public Space(String key)
	{
		this.key = key;
	}
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
