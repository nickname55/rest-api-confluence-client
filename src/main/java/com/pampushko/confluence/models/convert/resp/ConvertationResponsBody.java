package com.pampushko.confluence.models.convert.resp;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ConvertationResponsBody extends BaseModel
{
	/**
	 * Пример: "&lt;p&gt;Some example body in storage format&lt;/p&gt;"
	 * <br>
	 */
	@SerializedName("value")
	String value;
	
	/**
	 * Пример: "storage"
	 * <br>
	 */
	@SerializedName("representation")
	String representation;
	
	/**
	 * Пример: { "base": "http://myhost:8080/confluence",	"context": "/confluence" }
	 * <br>
	 */
	@SerializedName("_links")
	ConvertationResponsBodyLinks links;
	
	/**
	 * Пример: { "content": "/rest/api/content/3604482"	}
	 * <br>
	 */
	@SerializedName("_expandable")
	ConvertationResponsBodyExpandable expandable;
}