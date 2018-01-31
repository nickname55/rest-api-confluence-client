package com.pampushko.confluence.models.search;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.Content;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Поиск возвращает коллекцию элементов,
 * <br />
 * текущий класс представляет элемент коллекции
 * <br />
 */
@Data
@Slf4j
public class SearchResultItem extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("content")
	Content content;
	
	/**
	 * <br />
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * <br />
	 */
	@SerializedName("excerpt")
	String excerpt;
	
	/**
	 * <br />
	 */
	@SerializedName("url")
	String url;
	
	/**
	 * <br />
	 */
	@SerializedName("resultGlobalContainer")
	ResultGlobalContainer resultGlobalContainer;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("breadcrumbs")
	Breadcrumb[] breadcrumbs;
	
	/**
	 * <br />
	 */
	@SerializedName("entityType")
	String entityType;
	
	/**
	 * <br />
	 */
	@SerializedName("iconCssClass")
	String iconCssClass;
	
	/**
	 * <br />
	 */
	@SerializedName("lastModified")
	String lastModified;
	
	/**
	 * <br />
	 */
	@SerializedName("friendlyLastModified")
	String friendlyLastModified;
	
	//-------------------------------------------------------------
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
