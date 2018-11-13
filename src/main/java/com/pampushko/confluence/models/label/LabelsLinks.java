package com.pampushko.confluence.models.label;

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
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class LabelsLinks
{
	/**
	 * Пример: "/rest/api/content/att184680449/label?limit=200&amp;start=200"
	 * <br>
	 */
	@SerializedName("next")
	String next;
	
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/att184680449/label"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * Пример: "https://java-java.atlassian.net"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("context")
	String context;
}
