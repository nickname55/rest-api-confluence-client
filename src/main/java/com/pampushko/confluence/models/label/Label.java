package com.pampushko.confluence.models.label;

import com.google.gson.annotations.SerializedName;
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
public class Label
{
	/**
	 * <p>
	 */
	@SerializedName("id")
	private String id;
	
	/**
	 * <p>
	 */
	@SerializedName("name")
	private String name;
	
	/**
	 * <p>
	 */
	@SerializedName("prefix")
	private String prefix;
}
