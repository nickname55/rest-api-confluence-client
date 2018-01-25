package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Ответ без контента
 * <br />
 */
@Data
@Slf4j
public class NoContentResponse extends BaseModel
{
	private int statusCode;
	private String message;
	private ResponseData data;
}
