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
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ChildContentContainerLinks extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * <br>
	 */
	@SerializedName("base")
	String base;
	
	/**
	 * <br>
	 */
	@SerializedName("context")
	String context;
}
