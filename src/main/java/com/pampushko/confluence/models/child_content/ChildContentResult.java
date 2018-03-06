package com.pampushko.confluence.models.child_content;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.child_content.attachment.ChChildAttachment;
import com.pampushko.confluence.models.child_content.comment.ChChildComment;
import com.pampushko.confluence.models.child_content.page.ChChildPage;
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
	ChChildPage page;
	
	@SerializedName("attachment")
	ChChildAttachment attachment;
	
	@SerializedName("comment")
	ChChildComment comment;
	
	@SerializedName("_expandable")
	ChildContentExpandable expandable;
	
	@SerializedName("_links")
	ChildContentLinks links;
}
