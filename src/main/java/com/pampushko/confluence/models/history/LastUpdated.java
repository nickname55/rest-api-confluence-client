package com.pampushko.confluence.models.history;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models._Links;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode
@Slf4j
public class LastUpdated extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("by")
	By by;
	
	/**
	 * <br />
	 */
	@SerializedName("when")
	String when;
	
	/**
	 * <br />
	 */
	@SerializedName("friendlyWhen")
	String friendlyWhen;
	
	/**
	 * <br />
	 */
	@SerializedName("message")
	String message;
	
	/**
	 * <br />
	 */
	@SerializedName("number")
	long number;
	
	/**
	 * <br />
	 */
	@SerializedName("minorEdit")
	boolean minorEdit;
	
	/**
	 * <br />
	 */
	@SerializedName("syncRev")
	String syncRev;
	
	/**
	 * <br />
	 */
	@SerializedName("confRev")
	String confRev;
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	LastUpdatedExpandable expandable;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
	
}
