package com.pampushko.confluence.models.audit;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.Builder;
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
@Builder
@Slf4j
public class RetentionPeriod extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("number")
	long number;
	
	/**
	 * <br>
	 */
	@SerializedName("units")
	String units;
}
