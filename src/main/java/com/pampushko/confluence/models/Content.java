package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
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
	@SerializedName("id")
	private String id;
	
	/**
	 * Ключ области, например {@literal "TEST"}.
	 * <br />
	 * Ключи областей могут содержать только латинские буквы и числа {@literal (A-Z, a-z, 0-9)}
	 * <br />
	 */
	@SerializedName("key")
	private String key;
	
	/**
	 * Имя области
	 * <br />
	 */
	@SerializedName("name")
	private String name;
	
	/**
	 * Описание области
	 * <br />
	 */
	@SerializedName("description")
	private SpaceDescription description;
	
	/**
	 * Тип области
	 * <br />
	 */
	@SerializedName("type")
	private String type;
	
	/**
	 * Статус области
	 * <br />
	 */
	@SerializedName("status")
	private String status;
	
	
	/**
	 * <br />
	 */
	@SerializedName("restrictions")
	private Restrictions restrictions;
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_ContentExpandable expandable;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
	
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
