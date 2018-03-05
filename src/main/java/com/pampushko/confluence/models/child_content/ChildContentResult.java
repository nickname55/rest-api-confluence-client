package com.pampushko.confluence.models.child_content;

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
 * Класс модели для дочерних элементов некоторого элемента контета
 * <p>
 * Это могут быть комментарии, вложения, и дочерние страницы
 * <p>
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class ChildContentResult extends BaseModel
{
	@SerializedName("page")
	ChildPage page;
	
	@SerializedName("attachment")
	ChildAttachment attachment;
	
	@SerializedName("comment")
	ChildComment comment;
	
	@SerializedName("_expandable")
	ChildContentExpandable expandable;
	
	@SerializedName("_links")
	ChildContentLinks links;
}
