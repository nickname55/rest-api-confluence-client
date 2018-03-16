package com.pampushko.confluence.models.content_descendant;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachment;
import com.pampushko.confluence.models.child_content.comment.ChildComment;
import com.pampushko.confluence.models.child_content.page.ChildPage;
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
public class DescendantsResult extends BaseModel
{
	@SerializedName("page")
	ChildPage page;
	
	@SerializedName("attachment")
	ChildAttachment attachment;
	
	@SerializedName("comment")
	ChildComment comment;
	
	/**
	 * <br>
	 */
	@SerializedName("_expandable")
	DescendantResultExpandable expandable;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	DescendantResultLinks links;
}
