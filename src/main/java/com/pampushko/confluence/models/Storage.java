package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
@Data
public class Storage
{
	/**
	 * markup или html
	 * <br />
	 */
	private String value;
	
	/**
	 * Представление. Возможные значения: "view","page","storage".
	 * <br />
	 * Документация точного перечня всех значений не даёт
	 * <br />
	 * В большистве случаев используется {@literal "storage"}
	 * <br />
	 */
	private String representation = "storage";
	
	/**
	 * @see <a href="https://confluence.atlassian.com/display/DOC/Confluence+Storage+Format">
	 * Описание формата, который используется Confluence для хранения контента</a>
	 */
	public enum Representation
	{
		VIEW, PAGE, STORAGE, WIKI;
		
		@Override
		public String toString()
		{
			return name().toLowerCase();
		}
	}
	
}
