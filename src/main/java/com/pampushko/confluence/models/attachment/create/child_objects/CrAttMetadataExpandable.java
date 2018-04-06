package com.pampushko.confluence.models.attachment.create.child_objects;

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
public class CrAttMetadataExpandable
{
	/**
	 * <br>
	 */
	@SerializedName("currentuser")
	String currentuser;
	
	/**
	 * <br>
	 */
	@SerializedName("properties")
	String properties;
	
	/**
	 * <br>
	 */
	@SerializedName("frontend")
	String frontend;
	
	/**
	 * <br>
	 */
	@SerializedName("likes")
	String likes;
}
