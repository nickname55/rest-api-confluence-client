package com.pampushko.confluence.models.search;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Один из дочерних объектов для результатов поиска
 * <br />
 */
@Slf4j
public class ResultGlobalContainer
{
	/**
	 * <br />
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * <br />
	 */
	@SerializedName("displayUrl")
	String displayUrl;
}
