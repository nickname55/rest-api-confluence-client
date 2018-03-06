package com.pampushko.confluence.models.child_content;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 */
@Slf4j
public enum ContentType
{
	PAGE("page"),
	COMMENT("comment"),
	ATTACHMENT("attachment");
	
	private String contentType;
	
	ContentType(String contentType)
	{
		this.contentType = contentType;
	}
}
