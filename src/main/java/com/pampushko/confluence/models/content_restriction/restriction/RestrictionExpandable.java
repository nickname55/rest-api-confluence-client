package com.pampushko.confluence.models.content_restriction.restriction;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
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
public class RestrictionExpandable extends BaseModel
{
	/**
	 * Пример: "/rest/api/content/5210113"
	 * <br>
	 */
	@SerializedName("content")
	String content;
	
}
