package com.pampushko.confluence.models.convert;

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
public class ConvertationResponsBodyExpandable extends BaseModel
{
	/**
	 * Пример: "/rest/api/content/3604482"
	 * <br>
	 */
	@SerializedName("content")
	String content;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("webresource")
	String webresource;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("embeddedContent")
	String embeddedContent;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("mediaToken")
	String mediaToken;
}