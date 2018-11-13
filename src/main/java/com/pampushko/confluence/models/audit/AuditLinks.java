package com.pampushko.confluence.models.audit;

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
@EqualsAndHashCode
@Slf4j
public class AuditLinks
{
	/**
	 * <br>
	 */
	@SerializedName("base")
	String base; //"https://java-java.atlassian.net"
	
	/**
	 * <br>
	 */
	@SerializedName("context")
	String context; //""
	
	/**
	 * <br>
	 */
	@SerializedName("next")
	String next; //"/rest/api/audit?limit=2&start=2"
	
	/**
	 * <br>
	 */
	@SerializedName("self")
	String self; //"https://java-java.atlassian.net/rest/api/audit"
}
