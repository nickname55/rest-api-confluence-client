package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * todo согласовать этот объект с _Links
 */
@Getter
@Setter
@EqualsAndHashCode
@Slf4j
public class Links extends BaseModel
{
	/**
	 * <br>
	 */
	@SerializedName("status")
	private String status;
}
