package com.pampushko.confluence.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 *
 */
public class DeleteSpaceResponse extends BaseModel
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private String id;
	private Links links;
}
