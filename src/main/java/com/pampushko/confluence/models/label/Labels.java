package com.pampushko.confluence.models.label;

import com.google.gson.annotations.SerializedName;
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
public class Labels
{
	@SerializedName("results")
	Label[] results;
	
	@SerializedName("start")
	long start;
	
	@SerializedName("limit")
	long limit;
	
	@SerializedName("size")
	long size;
	
	@SerializedName("_links")
	LabelsLinks links;
	
}
