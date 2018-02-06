package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class _BodyEditorExpandable extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("webresource")
	String webresource;
	
	/**
	 * <br />
	 */
	@SerializedName("embeddedContent")
	String embeddedContent;
	
	/**
	 * <br />
	 */
	@SerializedName("content")
	String content;
}
