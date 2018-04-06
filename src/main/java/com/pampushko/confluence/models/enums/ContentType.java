package com.pampushko.confluence.models.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * Различные типы контента, доступные при работе с Confluence
 * <br>
 */
@Slf4j
public enum ContentType
{
	page("page"),
	comment("comment"),
	attachment("attachment");
	
	private String contentType;
	
	ContentType(String contentType)
	{
		this.contentType = contentType;
	}
}
