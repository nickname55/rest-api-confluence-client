package com.pampushko.confluence.models.label;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Представление результирующего объекта возвращаемого функцией Confluence API: GET /rest/content/{id}/label
 * <br>
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class LabelResultList extends BaseModel
{
	/**
	 * Массив в котором хранятся результаты
	 */
	@SerializedName("results")
	private Label[] labels;
	
	/**
	 * Начальный индекс
	 * <br>
	 */
	@SerializedName("start")
	private long start;
	
	/**
	 * <br>
	 */
	@SerializedName("limit")
	private long limit;
	
	/**
	 * <br>
	 */
	@SerializedName("size")
	private long size;
	
	/**
	 * <br>
	 */
	@SerializedName("_links")
	LabelsLinks links;
	
}
