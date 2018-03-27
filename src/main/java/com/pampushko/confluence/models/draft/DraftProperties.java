package com.pampushko.confluence.models.draft;

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
public class DraftProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("status")
	String status;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("space")
	String space;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("version")
	String version;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("container")
	String container;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("extensions")
	String extensions;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("restrictions")
	String restrictions;
}
