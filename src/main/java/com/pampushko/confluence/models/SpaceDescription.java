package com.pampushko.confluence.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Data
@Builder
@Slf4j
public class SpaceDescription extends BaseModel
{
	/**
	 * Объект, хранящий описание области
	 * <br />
	 */
	private Plain plain;
	
}
