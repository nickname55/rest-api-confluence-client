package com.pampushko.confluence.models.attachment.create.child_objects;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.Version;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachmentExpandable;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachmentExtensions;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachmentLinks;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachmentMetadata;
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
public class CrAttItem extends BaseModel
{
	/**
	 * Пример: "att184516614"
	 */
	@SerializedName("id")
	String id;
	/**
	 * Пример: "attachment"
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * Пример: "current"
	 */
	@SerializedName("status")
	String status;
	
	/**
	 * Пример: "1.json" //имя файла
	 */
	@SerializedName("title")
	String title;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * <br>
	 */
	@SerializedName("container")
	CrAttContainer container;
	
	/**
	 * <br>
	 */
	@SerializedName("macroRenderedOutput")
	CrAttMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	ChildAttachmentMetadata metadata;
	
	/**
	 * <br>
	 */
	@SerializedName("extensions")
	ChildAttachmentExtensions extensions;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	ChildAttachmentExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	ChildAttachmentLinks links;
}
