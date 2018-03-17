package com.pampushko.confluence.models.label;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//@formatter:off
/**
 * Метка, которую добавляют к стараницам или вложениям
 * <p>
 * <strong>Пример:</strong>
 * <blockquote><PRE>
{
	"results":
	[
		{
		  "prefix":"global",
		  "name":"accounts",
		  "id":"74291093"
		}
	],
 
	"start":0,
	"limit":200,
	"size":1,
 
	"_links":
	{
	  "base":"https://np-int.atlassian.net/wiki",
	  "context":"/wiki",
	  "self":"https://np-int.atlassian.net/wiki/rest/api/content/74131547/label"
	}
}
 * </PRE></blockquote>
 *
 */
//@formatter:on
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Label extends BaseModel
{
	
	/**
	 * Пример: "global"
	 * <p>
	 */
	@SerializedName("prefix")
	private String prefix;
	
	/**
	 * Пример: "test1" (обычно значение совпадает со значением свойства label)
	 * <p>
	 */
	@SerializedName("name")
	private String name;
	
	/**
	 * Пример: "208666625"
	 * <p>
	 */
	@SerializedName("id")
	private String id;
	
	/**
	 * имя метки
	 * <p>
	 */
	@SerializedName("label")
	private String label;
	
	public Label(final String labelName)
	{
		this.name = labelName;
	}
}
