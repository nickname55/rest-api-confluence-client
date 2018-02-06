package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class _BodyExpandable extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("editor")
	String editor;
	
	/**
	 * <br />
	 */
	@SerializedName("atlas_doc_format")
	String atlas_doc_format;
	
	/**
	 * <br />
	 */
	@SerializedName("view")
	String view;
	
	/**
	 * <br />
	 */
	@SerializedName("export_view")
	String export_view;
	
	/**
	 * <br />
	 */
	@SerializedName("styled_view")
	String styled_view;
	
	/**
	 * <br />
	 */
	@SerializedName("storage")
	String storage;
	
	/**
	 * <br />
	 */
	@SerializedName("editor2")
	String editor2;
	
	/**
	 * <br />
	 */
	@SerializedName("anonymous_export_view")
	String anonymous_export_view;
}
