package com.pampushko.confluence.models.group;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models._Links;
import lombok.extern.slf4j.Slf4j;

/**
 * Элемент содержащий группу пользователей Confluence
 * <br />
 */
@Slf4j
public class Group extends BaseModel
{
	/**
	 *
	 * <br />
	 */
	@SerializedName("type")
	String type;
	
	/**
	 *
	 * <br />
	 */
	@SerializedName("name")
	String name;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
	
}
