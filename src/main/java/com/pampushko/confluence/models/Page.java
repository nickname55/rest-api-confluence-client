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
public class Page extends BaseModel
{
	/**
	 * <br />
	 */
	//имя возвращаемой API коллекции в JSON
	@SerializedName("results")
	private PageResultItem[] pageResultItems;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("start")
	private int start;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("limit")
	private int limit;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("size")
	private int size;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("_links")
	private _Links links;
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
