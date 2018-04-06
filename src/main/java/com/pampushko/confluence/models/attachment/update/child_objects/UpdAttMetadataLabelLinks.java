package com.pampushko.confluence.models.attachment.update.child_objects;

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
public class UpdAttMetadataLabelLinks
{
	/**
	 * Пример: "/rest/api/content/att184451088/label?limit=200&amp;start=200"
	 * <br>
	 */
	@SerializedName("next")
	String next;
	
	/**
	 * Пример: "https://java-java.atlassian.net/wiki/rest/api/content/att184451088/label"
	 * <br>
	 */
	@SerializedName("self")
	String self;
}
