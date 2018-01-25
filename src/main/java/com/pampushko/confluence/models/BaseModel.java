package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Базовая модель
 * <br />
 */
@Data
@Slf4j
public class BaseModel
{
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
