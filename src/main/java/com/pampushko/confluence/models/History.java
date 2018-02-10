package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * история изменений страницы
 * <br>
 */
@Slf4j
public class History extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("latest")
	boolean latest;
	
	/**
	 * <br>
	 */
	@SerializedName("createdBy")
	CreatedBy createdBy;
	
	/**
	 * <br>
	 */
	@SerializedName("createdDate")
	String createdDate;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	_HistoryExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	_Links links;
	
}
