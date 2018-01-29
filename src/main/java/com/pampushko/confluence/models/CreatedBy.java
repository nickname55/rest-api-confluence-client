package com.pampushko.confluence.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.custom_deserialazers.ExpandablePropDeserializer;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class CreatedBy
{
	@SerializedName("type")
	String type;
	
	@SerializedName("username")
	String username;
	
	@SerializedName("userKey")
	String userKey;
	
	@SerializedName("accountId")
	String accountId;
	
	@SerializedName("profilePicture")
	@JsonAdapter(value = ExpandablePropDeserializer.class)
	ProfilePicture profilePicture;
	
	@SerializedName("displayName")
	String displayName;
	
	//-----------------------------------------------------------------
	/**
	 * <br />
	 * todo это объект?
	 */
	String operations;
	
	/**
	 * <br />
	 * todo это объект?
	 */
	String details;
	
	//-----------------------------------------------------------------
	
	@SerializedName("_expandable") //*
			_HistoryExpandable expandable;
	
	@SerializedName("_links")
	_Links links;
}
