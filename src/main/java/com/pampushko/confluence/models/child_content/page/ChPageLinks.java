package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class ChPageLinks extends BaseModel
{
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("self")
	private String self;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("tinyui")
	private String tinyui;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("editui")
	private String editui;
	
	/**
	 * page - results - links
	 * <br>
	 */
	@SerializedName("webui")
	private String webui;
	
	/**
	 * content - links
	 * <br>
	 */
	@SerializedName("base")
	private String base;
	
	/**
	 * content - links
	 * <br>
	 */
	@SerializedName("context")
	private String context;
	
	/**
	 * space - links
	 * <br>
	 */
	@SerializedName("collection")
	private String collection;
}
