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
public class DraftDefinitions extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("anonymous")
	String anonymous;
	
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
	@SerializedName("content")
	String content;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-body")
	String contentBody;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-id")
	String contentId;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-representation")
	String contentRepresentation;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-restriction")
	String contentRestriction;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-status")
	String contentStatus;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content-type")
	String contentType;
	
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
	@SerializedName("html-string")
	String htmlString;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("icon")
	String icon;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("known-user")
	String knownUser;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operation-check-result")
	String operationCheckResult;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operation-key")
	String operationKey;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("person")
	String person;
	
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
	@SerializedName("unknown-user")
	String unknownUser;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("user")
	String user;
	
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
	@SerializedName("web-resource-dependencies")
	String webResourceDependencies;
}
