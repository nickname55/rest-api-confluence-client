package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс модель для области Confluence (Space)
 * <br />
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
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
	 * Описание области
	 * <br />
	 */
	private SpaceDescription description;
	
	public void setDescription(String description)
	{
		String representation = "";
		Plain plain = new Plain(description);
		this.description = new SpaceDescription(plain);
	}
	
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
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_SpaceExpandable expandable;
	
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
	
	public Space()
	{
	
	}
	
	public Space(String key)
	{
		this.key = key;
	}
}
