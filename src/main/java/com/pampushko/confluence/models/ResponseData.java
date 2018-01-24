package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Data
@Slf4j
public class ResponseData extends BaseModel
{
	private boolean authorized;
	private boolean valid;
	private ResponseErrorMessageContainer[] errors;
	private boolean successful;
}
