package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Возвращаемый Confluence REST API список областей (Spaces)
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
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
