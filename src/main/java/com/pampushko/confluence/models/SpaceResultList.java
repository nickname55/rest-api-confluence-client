package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Возвращаемый Confluence REST API список областей (Spaces)
 * <br />
 */
@Data
@Slf4j
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
