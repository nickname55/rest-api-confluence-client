package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Возвращаемый Confluence REST API список элементов контента
 * <br />
 */
@Data
@Slf4j
public class ContentContainter extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("page")
	private Page page;
	
	/**
	 * <br />
	 */
	@SerializedName("blogpost")
	private Blogpost blogpost;
	
	/**
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
