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
	 * <br>
	 */
	@SerializedName("mediaType")
	String mediaType;
	
	/**
	 * <br>
	 */
	@SerializedName("fileSize")
	long fileSize;
	
	/**
	 * <br>
	 */
	@SerializedName("comment")
	String comment;
	
	/**
	 * <br>
	 */
	@SerializedName("mediaTypeDescription")
	String mediaTypeDescription;
	
}
