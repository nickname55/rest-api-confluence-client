package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;

/**
 * Дополнительные свойства, которые мы при желании можете добавить к объекту Content,
 * <br>
 * если вы получаете объект Content в ответе
 * <br>
 */
@Slf4j
public class _ContentExpandable extends BaseModel
{
	/**
	 * todo добавил для функции getContent (это поле первоначально в этом классе отсутствовало)
	 * <br>
	 */
	@SerializedName("childTypes")
	String childTypes;
	
	
	/**
	 * <br>
	 */
	@SerializedName("container")
	String container;
	
	/**
	 * <br>
	 */
	@SerializedName("metadata")
	String metadata;
	
	/**
	 * <br>
	 */
	@SerializedName("extensions")
	String extensions;
	
	/**
	 * <br>
	 */
	@SerializedName("operations")
	String operations;
	
	/**
	 * <br>
	 */
	@SerializedName("children")
	String children;
	
	/**
	 * todo добавил для функции getContent (это поле первоначально в этом классе отсутствовало)
	 * <br>
	 */
	@SerializedName("restrictions")
	String restrictions;
	
	/**
	 * <br>
	 */
	@SerializedName("history")
	String history;
	
	/**
	 * <br>
	 */
	@SerializedName("ancestors")
	String ancestors;
	
	/**
	 * <br>
	 */
	@SerializedName("body")
	String body;
	
	/**
	 * <br>
	 */
	@SerializedName("version")
	String version;
	
	/**
	 * <br>
	 */
	@SerializedName("descendants")
	String descendants;
	
	/**
	 * <br>
	 */
	@SerializedName("space")
	String space;
	
}
