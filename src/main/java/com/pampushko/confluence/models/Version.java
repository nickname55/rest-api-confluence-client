package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Версия контента (например, версия страницы)
 * <br />
 * Нумерация версий начинается с 1
 * <br />
 */
@Slf4j
public class Version extends BaseModel
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
	String number;
	
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
	_VersionExpandable expandable;
	
	/**
	 * <br />
	 */
	@SerializedName("_links")
	_Links links;
	
}
