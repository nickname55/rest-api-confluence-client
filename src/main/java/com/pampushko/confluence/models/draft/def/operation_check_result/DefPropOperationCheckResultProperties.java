package com.pampushko.confluence.models.draft.def.operation_check_result;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.DraftRef;
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
public class DefPropOperationCheckResultProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("operation")
	DraftRef operation;
	
	/**
	 * Пример: false
	 * <br>
	 */
	@SerializedName("additionalProperties")
	boolean additionalProperties;
}
