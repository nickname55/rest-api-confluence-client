package com.pampushko.confluence.models.convert;

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
public class ConvertationResponsBodyLinks extends BaseModel
{
	/**
	 * Пример: "http://myhost:8080/confluence"
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * Пример: "/confluence"
	 * <br>
	 */
	@SerializedName("context")
	String context;
}