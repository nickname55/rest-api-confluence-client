package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * история изменений страницы
 * <br />
 */
@Slf4j
public class History
{
	/**
	 * <br />
	 */
	boolean latest;
	
	@SerializedName("createdBy")
	CreatedBy createdBy;
	
	@SerializedName("createdDate")
	String createdDate;
	
	@SerializedName("_expandable")
	_HistoryExpandable expandable;

	@SerializedName("_links")
	_Links links;
	
}
