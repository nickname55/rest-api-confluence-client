package com.pampushko.confluence.models.content_descendant;

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
public class DescendantResultExpandable extends BaseModel
{
	/**
	 * Пример: "/rest/api/content/5210113/descendant/attachment"
	 * <br>
	 */
	@SerializedName("attachment")
	String attachment;
	
	/**
	 * Пример: "/rest/api/content/5210113/descendant/comment"
	 * <br>
	 */
	@SerializedName("comment")
	String comment;
	
	/**
	 * Пример: "/rest/api/content/5210113/descendant/page"
	 * <br>
	 */
	@SerializedName("page")
	String page;
}
