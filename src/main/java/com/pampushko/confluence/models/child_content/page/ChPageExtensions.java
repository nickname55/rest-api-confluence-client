package com.pampushko.confluence.models.child_content.page;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Модель для запроса контента из Confluence API
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Slf4j
public class ChPageExtensions extends BaseModel
{
	/**
	 * Значение
	 * <br>
	 */
	@SerializedName("position")
	@Builder.Default
	private String position = "none";
	
}
