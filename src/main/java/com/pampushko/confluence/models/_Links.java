package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br>
 * <br>
 * В разных объекта возвращаемых API используется также объект _links,
 * <br>
 * но не совсем ясно это один и тот же объект, с каким-то набором полей,
 * <br>
 * или набор полей объекта _links может быть различным
 * <br>
 * в зависимости от того, где мы этот объект встречаем.
 * <br>
 * <br>
 * В настоящей реализации в этот объект в Java добавлены <strong>все поля</strong>, которые я где-то встречал
 * <br>
 * объектах _links в различных частях ответа API
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class _Links extends BaseModel
{
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("self")
	private String self;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("tinyui")
	private String tinyui;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("editui")
	private String editui;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("webui")
	private String webui;
	
	/**
	 * content - links
	 * <br>
	 */
	@SerializedName("base")
	private String base;
	
	/**
	 * content - links
	 * <br>
	 */
	@SerializedName("context")
	private String context;
	
	/**
	 * space - links
	 * <br>
	 */
	@SerializedName("collection")
	private String collection;
}
