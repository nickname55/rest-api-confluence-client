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
public class Audit extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("author")
	Author author;
	
	/**
	 * <br>
	 */
	@SerializedName("remoteAddress")
	String remoteAddress;
	
	/**
	 * <br>
	 */
	@SerializedName("creationDate")
	long creationDate;
	
	/**
	 * <br>
	 */
	@SerializedName("summary")
	String summary;
	
	/**
	 * <br>
	 */
	@SerializedName("description")
	String description;
	
	/**
	 * <br>
	 */
	@SerializedName("category")
	String category;
	
	/**
	 * <br>
	 */
	@SerializedName("sysAdmin")
	boolean sysAdmin;
	
	/**
	 * <br>
	 */
	@SerializedName("affectedObject")
	AffectedObject affectedObject;
	
	/**
	 * <br>
	 */
	ChangedValue[] changedValues;
	
	/**
	 * <br>
	 */
	AssociatedObject[] associatedObjects;
	
}
