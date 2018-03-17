package com.pampushko.confluence.models.child_content.attachment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.attachment.create.child_objects.CrAttMetadataExpandable;
import com.pampushko.confluence.models.label.LabelResultList;
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
public class ChildAttachmentMetadata extends BaseModel
{
	/**
	 * Пример: "image/png" или "application/json"
	 * <p>
	 */
	@SerializedName("mediaType")
	String mediaType;
	
	/**
	 * Пример: ""this is comment""
	 */
	@SerializedName("comment")
	String comment;
	
	/**
	 *
	 */
	@SerializedName("labels")
	LabelResultList labels;
	
	/**
	 *
	 */
	@SerializedName("_expandable")
	CrAttMetadataExpandable expandable;
	
}
