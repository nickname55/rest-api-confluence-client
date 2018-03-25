package com.pampushko.confluence.models.content_property;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class PropResponse extends BaseModel
{
	/**
	 * Пример: "221184001"
	 * <br>
	 */
	@SerializedName("id")
	String id;
	
	/**
	 * Пример: "hello"
	 * <br>
	 */
	@SerializedName("key")
	String key;
	
	/**
	 * Пример: "this is value"
	 * <br>
	 */
	@SerializedName("value")
	String value;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("version")
	Version version;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_expandable")
	CreatePropResponseContainerExpandable expandable;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	PropResponseContainerLinks links;
}
