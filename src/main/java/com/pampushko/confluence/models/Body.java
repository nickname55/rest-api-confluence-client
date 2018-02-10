package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class Body extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("editor")
	BodyEditor editor;
	
	/**
	 * <br>
	 */
	@SerializedName("atlas_doc_format")
	String atlas_doc_format;
	
	/**
	 * <br>
	 */
	@SerializedName("view")
	String view;
	
	/**
	 * <br>
	 */
	@SerializedName("export_view")
	String export_view;
	
	/**
	 * <br>
	 */
	@SerializedName("styled_view")
	String styled_view;
	
	/**
	 * <br>
	 */
	@SerializedName("storage")
	Storage storage;
	
	/**
	 * <br>
	 */
	@SerializedName("editor2")
	String editor2;
	
	/**
	 * <br>
	 */
	@SerializedName("anonymous_export_view")
	String anonymous_export_view;
	
	
	//-------------------------------------------------------------------
	@SerializedName("_expandable")
	_BodyExpandable expandable;
}
