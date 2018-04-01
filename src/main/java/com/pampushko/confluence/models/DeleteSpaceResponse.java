package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Ответ на удаление области
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class DeleteSpaceResponse extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("id")
	private String id;
	
	/**
	 * <br>
	 */
	@SerializedName("links")
	private Links links;
}
