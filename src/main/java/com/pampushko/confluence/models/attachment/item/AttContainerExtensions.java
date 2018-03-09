package com.pampushko.confluence.models.attachment.item;

import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class AttContainerExtensions extends BaseModel
{
	/**
	 * Пример: "none"
	 * <p>
	 */
	String position;
}
