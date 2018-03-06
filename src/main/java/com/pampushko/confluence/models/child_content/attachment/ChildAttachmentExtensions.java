package com.pampushko.confluence.models.child_content.attachment;

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
public class ChildAttachmentExtensions extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("mediaType")
	String mediaType;
	
	/**
	 * <p>
	 */
	@SerializedName("fileSize")
	long fileSize;
	
	/**
	 * <p>
	 */
	@SerializedName("comment")
	String comment;
	
	/**
	 * <p>
	 */
	@SerializedName("mediaTypeDescription")
	String mediaTypeDescription;
	
}
