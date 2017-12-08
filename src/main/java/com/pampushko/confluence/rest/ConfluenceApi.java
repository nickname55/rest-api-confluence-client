package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.SpaceResultList;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Класс описывающий Confluence REST API
 * <br />
 * В дальнейшем этот класс используется для создания retrofit адаптера
 * <br />
 */
public interface ConfluenceApi
{
	/**
	 * Список областей
	 * <br />
	 */
	@GET("/wiki/rest/api/space")
	Call<SpaceResultList> getSpaces();
}
