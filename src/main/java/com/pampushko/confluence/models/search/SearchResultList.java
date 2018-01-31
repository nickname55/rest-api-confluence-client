package com.pampushko.confluence.models.search;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * список (коллекция) результатов поиска
 * <br />
 */
@Data
@Slf4j
public class SearchResultList extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("results")
	private SearchResultItem[] searchResultItems;
	
	public SearchResultList()
	{
	
	}
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
