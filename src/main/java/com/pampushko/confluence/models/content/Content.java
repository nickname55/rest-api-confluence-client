package com.pampushko.confluence.models.content;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.custom_deserialazers.ExpandablePropDeserializer;
import com.pampushko.confluence.models.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class Content extends BaseModel
{
	/**
	 * Идентификатор области
	 * <br>
	 */
	@SerializedName("id")
	private String id;
	
	/**
	 * Ключ области, например {@literal "TEST"}.
	 * <br>
	 * Ключи областей могут содержать только латинские буквы и числа {@literal (A-Z, a-z, 0-9)}
	 * <br>
	 */
	@SerializedName("key")
	private String key;
	
	/**
	 * Имя области
	 * <br>
	 */
	@SerializedName("name")
	private String name;
	
	/**
	 * Заголовок
	 * <br>
	 */
	@SerializedName("title")
	private String title;
	
	
	/**
	 * Описание области
	 * <br>
	 */
	@SerializedName("description")
	private SpaceDescription description;
	
	/**
	 * Тип области
	 * <br>
	 */
	@SerializedName("type")
	private String type;
	
	/**
	 * Статус области
	 * <br>
	 */
	@SerializedName("status")
	private String status;
	
	
	/**
	 * <br>
	 */
	@SerializedName("restrictions")
	private Restrictions restrictions;
	
	//-------------------------------------------------------------------------
	/**
	 * <br>
	 */
	//@SerializedName("container")
	//String container; //todo разобраться что это за контенер? и зачем он нужен
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * <br>
	 */
	//@SerializedName("extensions")
	//String extensions; //todo разобраться
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * <br>
	 */
	@SerializedName("history")
	History history;
	
	/**
	 * <br>
	 */
	@SerializedName("ancestors")
	Parent[] ancestors;
	
	/**
	 * <br>
	 */
	@SerializedName("body")
	Body body;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * <br>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * <br>
	 */
	@SerializedName("space")
	Space space;
	
	//-------------------------------------------------------------------------
	
	/**
	 * свойство добавлено для совместимости с функцией get descendant content by type
	 * <br>
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("macroRenderedOutput")
	ContentResultListMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * свойство добавлено для совместимости с функцией get descendant content by type
	 * <br>
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("extensions")
	ContentResultListExtensions extensions;
	
	//-------------------------------------------------------------------------
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	_ContentExpandable expandable;
	
	/**
	 * <br>
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
}
