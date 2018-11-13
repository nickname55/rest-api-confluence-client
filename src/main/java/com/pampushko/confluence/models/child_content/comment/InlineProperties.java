package com.pampushko.confluence.models.child_content.comment;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@Slf4j
public class InlineProperties
{
	@SerializedName("originalSelection")
	String originalSelection;
	
	@SerializedName("markerRef")
	String markerRef;
}
