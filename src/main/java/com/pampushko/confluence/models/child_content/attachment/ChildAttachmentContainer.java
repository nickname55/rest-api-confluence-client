package com.pampushko.confluence.models.child_content.attachment;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.custom_deserialazers.ExpandablePropDeserializer;
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
public class ChildAttachmentContainer extends BaseModel
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
	private ChildAttachmentMetadata metadata;
	
	
	/**
	 * todo проверить необходимость наличия этого свойства
	 * <p>
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("macroRenderedOutput")
	private ChildAttachmentMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <p>
	 */
	private ChildAttachmentExtensions extensions;
	
	
	//---------------------------------------------------------------------------
	/**
	 * <p>
	 */
	@SerializedName("_expandable")
	private ChildAttachmentExpandable expandable;
	
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	private ChildAttachmentLinks links;
	
}
