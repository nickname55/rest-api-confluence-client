package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ChildCommentContainerLinks extends BaseModel
{
	/**
	 * Пример: "https://java-java.atlassian.net"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 * Пример: "https://java-java.atlassian.net/rest/api/content/5210113/child/comment?expand=page,attachment,comment"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
}
