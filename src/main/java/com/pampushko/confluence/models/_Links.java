package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br />
 * <br />
 * В разных объекта возвращаемых API используется также объект _links,
 * <br />
 * но не совсем ясно это один и тот же объект, с каким-то набором полей,
 * <br />
 * или набор полей объекта _links может быть различным
 * <br />
 * в зависимости от того, где мы этот объект встречаем.
 * <br />
 * <br />
 * В настоящей реализации в этот объект в Java добавлены <strong>все поля</strong>, которые я где-то встречал
 * <br />
 * объектах _links в различных частях ответа API
 * <br />
 */
@Data
@Slf4j
public class _Links extends BaseModel
{
	/**
	 * page -> results -> links
	 * <br />
	 */
	private String self;
	
	/**
	 * page -> results -> links
	 * <br />
	 */
	private String tinyui;
	
	/**
	 * page -> results -> links
	 * <br />
	 */
	private String editui;
	
	/**
	 * page -> results -> links
	 * <br />
	 */
	private String webui;
	
	/**
	 * content -> links
	 * <br />
	 */
	private String base;
	
	/**
	 * content -> links
	 * <br />
	 */
	private String context;
	
	
}
