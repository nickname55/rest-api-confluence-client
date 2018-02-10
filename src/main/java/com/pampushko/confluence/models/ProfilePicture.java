package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Картинка профиля пользователя
 * <br>
 */
@Slf4j
public class ProfilePicture extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("path")
	String path;
	
	/**
	 * <br>
	 */
	@SerializedName("width")
	int width;
	
	/**
	 * <br>
	 */
	@SerializedName("height")
	int height;
	
	/**
	 * <br>
	 */
	@SerializedName("isDefault")
	boolean isDefault;
}
