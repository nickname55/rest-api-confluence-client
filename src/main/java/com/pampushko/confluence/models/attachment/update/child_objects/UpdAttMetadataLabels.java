package com.pampushko.confluence.models.attachment.update.child_objects;

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
public class UpdAttMetadataLabels extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	UpdAttMetadataLabelResult[] results;
	
	/**
	 * Пример: 0
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * Пример: 200
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * Пример : 0
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("_links")
	UpdAttMetadataLabelLinks links;
}
