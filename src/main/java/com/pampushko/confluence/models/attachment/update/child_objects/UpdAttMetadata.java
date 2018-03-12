package com.pampushko.confluence.models.attachment.update.child_objects;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class UpdAttMetadata
{
	/**
	 * Пример: "This is my File"
	 * <br>
	 */
	String comment;
	
	/**
	 * Пример: "text/plain"
	 */
	String mediaType;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("labels")
	UpdAttMetadataLabels labels;
	
	UpdAttMetadataExpandable _expandable;
}
