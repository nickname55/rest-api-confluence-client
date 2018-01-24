package com.pampushko.confluence.models;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 *
 */
@Data
public class ResponseData extends BaseModel
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private boolean authorized;
	private boolean valid;
	private ResponseErrorMessageContainer[] errors;
	private boolean successful;
}
