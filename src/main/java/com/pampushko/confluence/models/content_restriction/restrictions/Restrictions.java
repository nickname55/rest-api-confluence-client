package com.pampushko.confluence.models.content_restriction.restrictions;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс ограничений, на просмотр/редактирование контента
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class Restrictions extends BaseModel
{
	@SerializedName("user")
	RestrictionsUserContainer user;
	
	@SerializedName("group")
	RestrictionsGroupContainer group;
}
