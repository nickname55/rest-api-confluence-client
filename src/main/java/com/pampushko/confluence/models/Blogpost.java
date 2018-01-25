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
public class Blogpost extends BaseModel
{
	/**
	 * todo подойдет ли здесь PageResultItem или нужен отдельный новый тип?
	 * <br />
	 */
	private PageResultItem[] results;
	
	/**
	 * <br />
	 */
	private String start;
	
	/**
	 * <br />
	 */
	private String limit;
	
	/**
	 * <br />
	 */
	private String size;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	private _Links links;
	
	
	//todo сделать _expandable;

	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
