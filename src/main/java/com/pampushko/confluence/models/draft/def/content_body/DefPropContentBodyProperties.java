package com.pampushko.confluence.models.draft.def.content_body;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.DraftRef;
import com.pampushko.confluence.models.draft.DraftTypeAndRefObj;
import com.pampushko.confluence.models.draft.DraftTypeObject;
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
public class DefPropContentBodyProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("value")
	DraftTypeObject value;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("webresource")
	DraftTypeAndRefObj webresource;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("representation")
	DraftRef representation;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("content")
	DraftTypeAndRefObj content;
}
