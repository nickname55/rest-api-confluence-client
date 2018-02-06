package com.pampushko.confluence.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.custom_deserialazers.ExpandablePropDeserializer;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class CreatedBy extends BaseModel
{
	/**
	 * <br />
	 */
	@SerializedName("type")
	String type;
	
	/**
	 * <br />
	 */
	@SerializedName("username")
	String username;
	
	/**
	 * <br />
	 */
	@SerializedName("userKey")
	String userKey;
	
	/**
	 * <br />
	 */
	@SerializedName("accountId")
	String accountId;
	
	/**
	 * <br />
	 */
	@SerializedName("profilePicture")
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	ProfilePicture profilePicture;
	
	/**
	 * <br />
	 */
	@SerializedName("displayName")
	String displayName;
	
	//-----------------------------------------------------------------
	/**
	 * <br />
	 * todo это объект?
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br />
	 * todo это объект?
	 */
	@SerializedName("details")
	String details;
	
	//-----------------------------------------------------------------
	
	/**
	 * <br />
	 */
	@SerializedName("_expandable")
	_HistoryExpandable expandable;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
}
