package com.pampushko.confluence.models.longtask;

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
public class LongTaskName
{
	/**
	 * Пример: "com.atlassian.confluence.impl.fabric.editor.amq.BatchUnsupportedContentScanRunner"
	 * <br>
	 */
	@SerializedName("key")
	String key;
	
	/**
	 * todo Проверить действительно ли здесь массив строк? или возможно массив объектов?
	 * <br>
	 */
	@SerializedName("args")
	String[] args;
}
