package com.pampushko.confluence.models.content_restriction;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.content_restriction.restriction.Restriction;
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
public class RestrictionResponseContainer extends BaseModel
{
	@SerializedName("read")
	Restriction read;
	
	@SerializedName("update")
	Restriction update;
	
	@SerializedName("_links")
	RestrictionResponseContainerLinks links;
}
