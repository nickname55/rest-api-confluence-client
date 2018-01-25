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
public class PageResultItem extends BaseModel
{
	/**
	 * <br />
	 */
	private String id;
	
	/**
	 * <br />
	 */
	private String type;
	
	/**
	 * <br />
	 */
	private String status;
	
	/**
	 * <br />
	 */
	private String title;
	
	/**
	 *
	 * <br />
	 */
	private Extensions extensions;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	private _Links links;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("_expandable")
	private _PageExpandable expandable;
	
	//--------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
