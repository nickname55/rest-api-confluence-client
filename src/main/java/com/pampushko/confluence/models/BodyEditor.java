package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class BodyEditor extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("value")
	String value;
	
	/**
	 * <br />
	 */
	@SerializedName("representation")
	String representation;
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_BodyEditorExpandable expandable;
}
