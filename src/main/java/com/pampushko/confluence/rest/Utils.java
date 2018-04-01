package com.pampushko.confluence.rest;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Slf4j
public class Utils
{
	public static boolean codeIs204(final int code)
	{
		if (code == 204)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean codeIs200(final int code)
	{
		if (code == 200)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @param userName
	 *
	 * @return
	 */
	public static Map<String, String> createParamsUserName(final String userName)
	{
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("username", userName);
			}
		};
		return params;
	}
	
	/**
	 * @param userKey
	 *
	 * @return
	 */
	public static Map<String, String> createParamsUserKey(final String userKey)
	{
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				put("key", userKey);
			}
		};
		return params;
	}
	
}
