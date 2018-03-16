package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.custom_deserialazers.ExpandablePropDeserializer;
import com.pampushko.confluence.models.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ChildPageContainer extends BaseModel
{
	/**
	 * <br>
	 */
	private String id;
	
	/**
	 * <br>
	 */
	private String type;
	
	/**
	 * <br>
	 */
	private String status;
	
	/**
	 * <br>
	 */
	private String title;
	
	/**
	 * <br>
	 */
	private Extensions extensions;
	
	/**
	 * <br>
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("macroRenderedOutput")
	private ChildPageMacroRenderedOutput macroRenderedOutput;
	//------------------------------------------------------------------------------
	
	/**
	 * <br>
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	/**
	 * <br>
	 */
	@SerializedName("container")
	String container;
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * <br>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * <br>
	 */
	@SerializedName("history")
	History history;
	
	/**
	 * <br>
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * <br>
	 */
	@SerializedName("body")
	Body body;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * <br>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * <br>
	 */
	@SerializedName("space")
	Space space;
	
	//---------------------------------------------------------------------------
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private ChildPageContainerLinks links;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	private ChildPageExpandable expandable;
	
}
