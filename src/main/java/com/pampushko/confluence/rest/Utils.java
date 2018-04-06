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
	/**
	 * Проверка на то что код равен 204
	 *
	 * @param code
	 * 		значение кода
	 *
	 * @return булево значение, если код равен 204, то true
	 */
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
	
	/**
	 * Проверка на то что код равен 200
	 * @param code значение кода
	 * @return булево значение, если код равен 200, то true
	 */
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
	 * @param userName значение имени пользователя
	 * @return отображаение с ключом username и значение переданным методу в качестве параметра userName
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
	 * @param userKey значение ключа пользователя
	 * @return отображаение с ключом key и значение переданным методу в качестве параметра userKey
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
