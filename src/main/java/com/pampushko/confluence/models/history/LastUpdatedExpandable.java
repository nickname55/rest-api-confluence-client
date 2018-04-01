package com.pampushko.confluence.models.history;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class LastUpdatedExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("collaborators")
	String collaborators;
	
	/**
	 * <br>
	 */
	@SerializedName("content")
	String content;
}
