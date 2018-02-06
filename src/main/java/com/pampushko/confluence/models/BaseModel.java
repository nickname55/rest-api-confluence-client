package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;

/**
 * Базовая модель
 * <br />
 */
public class BaseModel
{
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
