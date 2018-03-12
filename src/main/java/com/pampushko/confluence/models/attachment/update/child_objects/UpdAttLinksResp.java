package com.pampushko.confluence.models.attachment.update.child_objects;

import com.google.gson.annotations.SerializedName;
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
public class UpdAttLinksResp
{
	/**
	 * Пример: "/wiki"
	 * <br>
	 */
	@SerializedName("context")
	String context;
	
	/**
	 * Пример: "https://java-java.atlassian.net/wiki/rest/api/content/att184451088"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
	/**
	 * Пример: "/download/attachments/5210113/1.json?version=1&modificationDate=1520866571978&cacheVersion=1&api=v2"
	 * <br>
	 */
	@SerializedName("download")
	String download;
	
	
	/**
	 * Пример: "/rest/api/content"
	 * <br>
	 */
	@SerializedName("collection")
	String collection;
	
	/**
	 * Пример: "/spaces/4654313/pages/5210113/Change+Item?preview=%2F5210113%2F184451088%2F1.json"
	 * <br>
	 */
	@SerializedName("webui")
	String webui;
	
	/**
	 * Пример: "https://java-java.atlassian.net/wiki"
	 * <br>
	 */
	@SerializedName("base")
	String base;
}
