package com.pampushko.confluence.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 *
 */
public class Main
{
	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args)
	{
		test();
	}
	
	private static void test()
	{
		log.error("Hello, error!");
	}
	
}
