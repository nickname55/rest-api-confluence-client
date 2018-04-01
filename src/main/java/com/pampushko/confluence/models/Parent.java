package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Parent extends BaseModel
{
	/**
	 * id родительского элемента
	 */
	@SerializedName("id")
	private String id;
	
	/**
	 * Тип родительского элемента
	 */
	@SerializedName("type")
	private String type;
}
