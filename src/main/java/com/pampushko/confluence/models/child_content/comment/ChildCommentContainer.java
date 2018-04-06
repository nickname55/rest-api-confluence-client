package com.pampushko.confluence.models.child_content.comment;

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
public class ChildCommentContainer extends BaseModel
{
	/**
	 * "171671553"
	 * <br>
	 */
	private String id;
	
	/**
	 * "comment"
	 * <br>
	 */
	private String type;
	
	/**
	 * "current"
	 * <br>
	 */
	private String status;
	
	/**
	 * "Re: Change Item"
	 * <br>
	 */
	private String title;
	
	
	/**
	 * todo проверить необходимость этого свойства
	 */
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	@SerializedName("macroRenderedOutput")
	ChildCommentMacroRenderedOutput macroRenderedOutput;
	
	/**
	 * <br>
	 */
	private ChildCommentExtensions extensions;
	
	
	//---------------------------------------------------------------------------
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	private ChildCommentExpandable expandable;
	
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private ChildCommentLinks links;
	
}
