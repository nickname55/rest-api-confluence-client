package com.pampushko.confluence.models.history;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Expanded объкт для объекта By по результату запроса History of Content
 * <br />
 */
@Setter
@Getter
@EqualsAndHashCode
@Slf4j
public class _PrevVerExpandableHistory
{
	/**
	 * <br />
	 */
	@SerializedName("collaborators")
	String collaborators;
	
	/**
	 * <br />
	 */
	@SerializedName("content")
	String content;
}
