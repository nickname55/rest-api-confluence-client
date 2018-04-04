package com.pampushko.confluence.models.content_property;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class CreatePropResponseContainerExpandable extends BaseModel
{
	/**
	 * Пример: "/rest/api/content/5210113"
	 * <br>
	 * Если мы обращаемся к свойствам контента, например, страницы,
	 * <br>
	 * то у нас заполнено это свойство в expandable,
	 * <br>
	 * Если же мы обращаемся к свойствам области (space),]
	 * <br>
	 * то content будет пустым, а заполнено будет свойство "space"
	 * <br>
	 */
	@SerializedName("content")
	String content;
	
	/**
	 * Пример: "/rest/api/space/GAT"
	 * <br>
	 * Если мы обращаемся к свойствам свойствам области (space),
	 * <br>
	 * то у нас заполнено это свойство в expandable,
	 * <br>
	 * Если же мы обращаемся к свойствам области (space),]
	 * <br>
	 * то content будет пустым, а заполнено будет свойство "space"
	 * <br>
	 */
	@SerializedName("space")
	String space;
	
}
