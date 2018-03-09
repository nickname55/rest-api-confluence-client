package com.pampushko.confluence.models.attachment.item;

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
public class AttMetadataExpandable
{
	/**
	 * <p>
	 */
	@SerializedName("currentuser")
	String currentuser;
	
	/**
	 * <p>
	 */
	@SerializedName("properties")
	String properties;
	
	/**
	 * <p>
	 */
	@SerializedName("frontend")
	String frontend;
	
	/**
	 * <p>
	 */
	@SerializedName("likes")
	String likes;
}
