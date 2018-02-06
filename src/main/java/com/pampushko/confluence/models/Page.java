package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br />
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class Page extends BaseModel
{
	/**
	 * <br />
	 */
	//имя возвращаемой API коллекции в JSON
	@SerializedName("results")
	private PageResultItem[] pageResultItems;
	
	/**
	 * <br />
	 */
	@SerializedName("start")
	private int start;
	
	/**
	 * <br />
	 */
	@SerializedName("limit")
	private int limit;
	
	/**
	 * <br />
	 */
	@SerializedName("size")
	private int size;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	private _Links links;
}
