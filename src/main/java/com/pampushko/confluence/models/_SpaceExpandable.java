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
public class _SpaceExpandable extends BaseModel
{
	
	/**
	 * <br />
	 */
	@SerializedName("settings")
	String settings;
	
	/**
	 * <br />
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * <br />
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br />
	 */
	@SerializedName("lookAndFeel")
	String lookAndFeel;
	
	/**
	 * <br />
	 */
	@SerializedName("permissions")
	String permissions;
	
	/**
	 * <br />
	 */
	@SerializedName("icon")
	String icon;
	
	/**
	 * <br />
	 */
	@SerializedName("description")
	String description;
	
	/**
	 * <br />
	 */
	@SerializedName("theme")
	String theme;
	
	/**
	 * <br />
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * <br />
	 */
	@SerializedName("homepage")
	String homepage;
	
	//----------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
