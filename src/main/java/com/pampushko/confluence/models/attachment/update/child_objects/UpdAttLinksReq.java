package com.pampushko.confluence.models.attachment.update.child_objects;

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
public class UpdAttLinksReq
{
	/**
	 * Пример: "https://java-java.atlassian.net/wiki/rest/api/content/5210113"
	 * <br>
	 */
	String self;
	
	/**
	 * Пример: "/x/AYBP"
	 * <br>
	 */
	String tinyui;
	
	/**
	 * Пример: "/pages/resumedraft.action?draftId=5210113"
	 * <br>
	 */
	String editui;
	
	/**
	 * Пример: "/spaces/4654313/pages/5210113/Change+Item"
	 * <br>
	 */
	String webui;
}
