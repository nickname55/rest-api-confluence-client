package com.pampushko.confluence.models.content_restriction.restrictions;

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
public class RestrictionForGroupLinks extends BaseModel
{
	/**
	 * Пример: self : "https://java-java.atlassian.net/wiki/rest/experimental/group/jira-core-users"
	 * <br>
	 */
	@SerializedName("self")
	String self;
	
}
