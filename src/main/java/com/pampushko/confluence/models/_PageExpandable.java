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
public class _PageExpandable extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	/**
	 * <br />
	 */
	@SerializedName("container")
	String container;
	
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
	@SerializedName("children")
	String children;
	
	/**
	 * <br />
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * <br />
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * <br />
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * <br />
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * <br />
	 */
	@SerializedName("version")
	String version;
	
	/**
	 * <br />
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * <br />
	 */
	@SerializedName("space")
	String space;
	
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
