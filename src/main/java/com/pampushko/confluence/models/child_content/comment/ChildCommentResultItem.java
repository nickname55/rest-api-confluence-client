package com.pampushko.confluence.models.child_content.comment;

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
public class ChildCommentResultItem extends BaseModel
{
	/**
	 * "171671553"
	 * <p>
	 */
	private String id;
	
	/**
	 * "comment"
	 * <p>
	 */
	private String type;
	
	/**
	 * "current"
	 * <p>
	 */
	private String status;
	
	/**
	 * "Re: Change Item"
	 * <p>
	 */
	private String title;
	
	/**
	 * <p>
	 */
	private ChildCommentExtensions extensions;
	
	
	//---------------------------------------------------------------------------
	/**
	 * <p>
	 */
	@SerializedName("_expandable")
	private ChildCommentExpandable expandable;
	
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	private ChildCommentLinks links;
	
}
