package com.pampushko.confluence.models.draft;

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
public class DraftTypeObject extends BaseModel
{
	/**
	 * Пример: "string"
	 * <br>
	 */
	@SerializedName("type")
	String type;
}
