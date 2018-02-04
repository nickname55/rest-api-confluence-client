package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Data
@Slf4j
public class Body
{
	/**
	 * <br />
	 */
	@SerializedName("editor")
	BodyEditor editor;
	
	/**
	 * <br />
	 */
	String atlas_doc_format;
	
	/**
	 * <br />
	 */
	String view;
	
	/**
	 * <br />
	 */
	String export_view;
	
	/**
	 * <br />
	 */
	String styled_view;
	
	/**
	 * <br />
	 */
	Storage storage;
	
	/**
	 * <br />
	 */
	String editor2;
	
	/**
	 * <br />
	 */
	String anonymous_export_view;
	
	
	//-------------------------------------------------------------------
	@SerializedName("_expandable")
	_BodyExpandable expandable;
}
