package com.pampushko.confluence.models.content_restriction.restriction;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.content_restriction.restrictions.Restrictions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Restriction extends BaseModel
{
	/**
	 * Пример: "read"
	 * <br>
	 */
	@SerializedName("operation")
	String operation;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("restrictions")
	Restrictions restrictions;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_expandable")
	RestrictionExpandable expandable;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	RestrictionLinks links;
}
