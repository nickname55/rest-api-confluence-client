package com.pampushko.confluence.models.attachment.create;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.attachment.create.child_objects.CrAttItem;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachmentContainerLinks;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Объект-результат возвращаемый при создании нового вложения в Confluence
 * <p>
 * todo рассмотреть возможность объединения с пакетом models.child_content.attachment
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class CreateAttResponseContainer extends BaseModel
{
	/**
	 * <p>
	 */
	@SerializedName("results")
	CrAttItem[] results;
	
	/**
	 * <p>
	 */
	@SerializedName("size")
	long size;
	
	/**
	 * <p>
	 */
	@SerializedName("_links")
	ChildAttachmentContainerLinks links;
}
