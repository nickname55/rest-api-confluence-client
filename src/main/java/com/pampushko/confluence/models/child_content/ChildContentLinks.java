package com.pampushko.confluence.models.child_content;

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
@EqualsAndHashCode
@Slf4j
public class ChildContentLinks extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * <p>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * <p>
	 */
	@SerializedName("context")
	String context;
}
