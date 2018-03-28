package com.pampushko.confluence.models.convert.req;

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
public class ContentBody extends BaseModel
{
	/**
	 * Пример: "<p>Some example body in storage format</p>"
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
}
