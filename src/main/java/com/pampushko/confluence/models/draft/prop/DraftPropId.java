package com.pampushko.confluence.models.draft.prop;

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
public class DraftPropId extends BaseModel
{
	/**
	 * Пример: "#/definitions/content-id"
	 * <br>
	 */
	@SerializedName("id")
	DraftRef id;
}
