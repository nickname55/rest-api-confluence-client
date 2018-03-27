package com.pampushko.confluence.models.draft.def.history;

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
public class DefPropHistoryPropertiesContributorsItemsPropertiesPublishersItemsProperties extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("users")
	DefPropHistoryPropertiesContributorsItemsPropertiesPublishersItemsPropertiesUsers users;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("userKeys")
	DefPropHistoryPropertiesContributorsItemsPropertiesPublishersItemsPropertiesUserKeys userKeys;
	
}
