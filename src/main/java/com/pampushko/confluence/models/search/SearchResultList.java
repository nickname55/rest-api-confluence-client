package com.pampushko.confluence.models.search;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * список (коллекция) результатов поиска
 * <br />
 */
@Getter
@Setter
@EqualsAndHashCode
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
}
