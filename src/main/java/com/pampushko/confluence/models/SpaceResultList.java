package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Возвращаемый Confluence REST API список областей (Spaces)
 * <br />
 */
@Data
public class SpaceResultList extends BaseModel
{
	//имя возвращаемой API коллекции в JSON
	@SerializedName("results")
	private Space[] spaces;
	
	public SpaceResultList(Space[] spaces)
	{
		this.spaces = spaces;
	}
}
