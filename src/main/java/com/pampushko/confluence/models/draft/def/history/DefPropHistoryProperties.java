package com.pampushko.confluence.models.draft.def.history;

import com.google.gson.annotations.SerializedName;
import com.pampushko.confluence.models.BaseModel;
import com.pampushko.confluence.models.draft.DraftRef;
import com.pampushko.confluence.models.draft.DraftTypeAndRefObj;
import com.pampushko.confluence.models.draft.DraftTypeObject;
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
public class DefPropHistoryProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("previousVersion")
	DraftTypeAndRefObj previousVersion;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("nextVersion")
	DraftTypeAndRefObj nextVersion;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("lastUpdated")
	DraftTypeAndRefObj lastUpdated;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("latest")
	DraftTypeObject latest;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("createdBy")
	DraftRef createdBy;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("createdDate")
	DraftTypeObject createdDate;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("contributors")
	DefPropHistoryPropertiesContributors contributors;
}
