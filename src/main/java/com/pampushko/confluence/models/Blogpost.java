package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
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
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Blogpost extends BaseModel
{
	/**
	 * todo подойдет ли здесь PageResultItem или нужен отдельный новый тип?
	 * <br>
	 */
	@SerializedName("results")
	private PageResultItem[] results;
	
	/**
	 * <br>
	 */
	@SerializedName("start")
	private String start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	private String limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	private String size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private _Links links;
	
	//todo сделать _expandable;
}
