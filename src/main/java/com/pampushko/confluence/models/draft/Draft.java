package com.pampushko.confluence.models.draft;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Draft extends BaseModel
{
	/**
	 * Пример: "https://docs.atlassian.com/jira/REST/schema/content#"
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример: "Content"
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * Пример: "object"
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример:
	 */
	@SerializedName("properties")
	DraftProperties properties;
	
	/**
	 * Пример:
	 */
	@SerializedName("definitions")
	DraftDefinitions definitions;
	
	/**
	 * Пример: false
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
