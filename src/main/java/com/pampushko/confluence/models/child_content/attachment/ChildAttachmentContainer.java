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
	 * <br>
	 */
	private String id;
	
	/**
	 * "attachment"
	 * <br>
	 */
	private String type;
	
	/**
	 * "current"
	 * <br>
	 */
	private String status;
	
	/**
	 * "IdeaProject.png"
	 * <br>
	 */
	private String title;
	
	/**
	 * <br>
	 */
	private ChildAttachmentMetadata metadata;
	
	
	/**
	 * todo проверить необходимость наличия этого свойства
	 * <br>
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("macroRenderedOutput")
	private ChildAttachmentMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <br>
	 */
	private ChildAttachmentExtensions extensions;
	
	
	//---------------------------------------------------------------------------
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	private ChildAttachmentExpandable expandable;
	
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private ChildAttachmentLinks links;
	
}
