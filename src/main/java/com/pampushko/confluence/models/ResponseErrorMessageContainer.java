package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Data
@Slf4j
public class ResponseErrorMessageContainer extends BaseModel
{
	private ResponseErrorMessage message;
}
