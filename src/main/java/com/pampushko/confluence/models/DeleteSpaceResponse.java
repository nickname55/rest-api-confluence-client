package com.pampushko.confluence.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Ответ на удаление области
 */
@Data
@Slf4j
public class DeleteSpaceResponse extends BaseModel
{
	private String id;
	private Links links;
}
