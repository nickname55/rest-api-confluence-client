package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Slf4j
public class SpaceDescription extends BaseModel
{
	/**
	 * Объект, хранящий описание области
	 * <br />
	 */
	@SerializedName("plain")
	private Plain plain;
	
}
