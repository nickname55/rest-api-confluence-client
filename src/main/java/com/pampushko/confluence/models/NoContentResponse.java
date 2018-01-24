package com.pampushko.confluence.models;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 *
 */
@Data
public class NoContentResponse extends BaseModel
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private int statusCode;
	private String message;
	private ResponseData data;
}
