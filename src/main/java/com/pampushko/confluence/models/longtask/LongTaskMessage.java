package com.pampushko.confluence.models.longtask;

import com.google.gson.annotations.SerializedName;
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
public class LongTaskMessage extends BaseModel
{
	/**
	 * Пример: ""
	 * <br>
	 */
	@SerializedName("translation")
	String translation;
	
	/**
	 * todo проверить, действительно возвращается массив строк или это может быть массив каких-то объектов?
	 */
	@SerializedName("args")
	String[] args;
}
