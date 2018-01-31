package com.pampushko.confluence.models;

import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Дополнительные свойства, которые мы при желании можете добавить к объекту Content,
 * <br />
 * если вы получаете объект Content в ответе
 * <br />
 */
@Slf4j
public class _ContentExpandable extends BaseModel
{
	/**
	 * <br />
	 */
	String container;
	
	/**
	 * <br />
	 */
	String metadata;
	
	/**
	 * <br />
	 */
	String extensions;
	
	/**
	 * <br />
	 */
	String operations;
	
	/**
	 * <br />
	 */
	String children;
	
	/**
	 * <br />
	 */
	String history;
	
	/**
	 * <br />
	 */
	String ancestors;
	
	/**
	 * <br />
	 */
	String body;
	
	/**
	 * <br />
	 */
	String version;
	
	/**
	 * <br />
	 */
	String descendants;
	
	/**
	 * <br />
	 */
	String space;
	
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
