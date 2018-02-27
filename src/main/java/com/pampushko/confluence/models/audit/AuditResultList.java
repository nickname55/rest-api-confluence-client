package com.pampushko.confluence.models.audit;

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
public class AuditResultList extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("results")
	Audit[] results;
	
	/**
	 * <br>
	 */
	@SerializedName("start")
	long start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	long limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	AuditLinks links;
}
