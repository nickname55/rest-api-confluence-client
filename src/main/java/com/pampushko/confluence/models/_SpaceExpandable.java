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
public class _SpaceExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("settings")
	String settings;
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br>
	 */
	@SerializedName("lookAndFeel")
	String lookAndFeel;
	
	/**
	 * <br>
	 */
	@SerializedName("permissions")
	String permissions;
	
	/**
	 * <br>
	 */
	@SerializedName("icon")
	String icon;
	
	/**
	 * <br>
	 */
	@SerializedName("description")
	String description;
	
	/**
	 * <br>
	 */
	@SerializedName("theme")
	String theme;
	
	/**
	 * <br>
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * <br>
	 */
	@SerializedName("homepage")
	String homepage;
	
}
