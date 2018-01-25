package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * todo согласовать этот объект с _Links
 */
@Data
@Slf4j
public class Links extends BaseModel
{
	private String status;
}
