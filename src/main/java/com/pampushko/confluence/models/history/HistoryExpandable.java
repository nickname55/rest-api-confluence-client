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
@EqualsAndHashCode
public class HistoryExpandable extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("contributors")
	String contributors;
}
