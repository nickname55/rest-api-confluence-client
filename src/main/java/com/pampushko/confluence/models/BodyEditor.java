package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class BodyEditor
{
	/**
	 * <br />
	 */
	String value;
	
	/**
	 * <br />
	 */
	String representation;
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_BodyEditorExpandable expandable;
}
