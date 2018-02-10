package com.pampushko.confluence.models.user;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models._Links;
import lombok.extern.slf4j.Slf4j;

/**
 * Группы пользователей Confluence
 * <br>
 */
@Slf4j
public class UserResultList extends BaseModel
{
	@SerializedName("results")
	User[] results;
	
	@SerializedName("size")
	int size;
	
	@SerializedName("start")
	int start;
	
	@SerializedName("limit")
	int limit;
	
	@SerializedName("_links")
	_Links links;
}
