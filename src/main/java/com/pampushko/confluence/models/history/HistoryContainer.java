package com.pampushko.confluence.models.history;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.CreatedBy;
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
public class HistoryContainer extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("previousVersion")
	PreviousVersion previousVersion;
	
	/**
	 * <br />
	 */
	@SerializedName("lastUpdated")
	LastUpdated lastUpdated;
	
	/**
	 * <br />
	 */
	@SerializedName("latest")
	boolean latest;
	
	/**
	 * <br />
	 */
	@SerializedName("createdBy")
	CreatedBy createdBy;
	
	/**
	 * <br />
	 */
	@SerializedName("createdDate")
	String createdDate;
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	HistoryExpandable expandable;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
}
