package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import lombok.Data;

/**
 *
 */
@Data
public class BaseModel
{
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
