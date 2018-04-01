package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Storage extends BaseModel
{
	/**
	 * markup или html
	 * <br>
	 */
	@SerializedName("value")
	private String value;
	
	/**
	 * Представление. Возможные значения: "view","page","storage".
	 * <br>
	 * Документация точного перечня всех значений не даёт
	 * <br>
	 * В большистве случаев используется {@literal "storage"}
	 * <br>
	 */
	@SerializedName("representation")
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
