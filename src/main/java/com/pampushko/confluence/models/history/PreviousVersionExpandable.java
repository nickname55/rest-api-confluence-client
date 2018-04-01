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
public class PreviousVersionExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("collaborators")
	String collaborators;
	
	/**
	 * <br>
	 */
	@SerializedName("contend")
	String content;
}
