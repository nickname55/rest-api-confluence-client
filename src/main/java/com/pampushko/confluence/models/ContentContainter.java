package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Возвращаемый Confluence REST API список элементов контента
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Slf4j
public class ContentContainter extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("page")
	private Page page;
	
	/**
	 * <br>
	 */
	@SerializedName("blogpost")
	private Blogpost blogpost;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	private _Links links;
	
}
