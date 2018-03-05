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
@EqualsAndHashCode
@Slf4j
public class AttachmentResultItem extends BaseModel
{
	/**
	 * "att172261377"
	 * <p>
	 */
	private String id;
	
	/**
	 * "attachment"
	 * <p>
	 */
	private String type;
	
	/**
	 * "current"
	 * <p>
	 */
	private String status;
	
	/**
	 * "IdeaProject.png"
	 * <p>
	 */
	private String title;
	
	/**
	 * <p>
	 */
	private AttachmentMetadata metadata;
	
	
	/**
	 * <p>
	 */
	private AttachmentExtensions extensions;
	
	
	//---------------------------------------------------------------------------
	/**
	 * <p>
	 */
	@SerializedName("_expandable")
	private AttachmentExpandable expandable;
	
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	private AttachmentLinks links;
	
}
