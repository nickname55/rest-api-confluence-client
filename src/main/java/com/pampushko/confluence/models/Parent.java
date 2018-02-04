package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 */
@Slf4j
@Data
public class Parent
{
	/**
	 * id родительского элемента
	 */
	private String id;
	
	/**
	 * Тип родительского элемента
	 */
	private String type;
}
