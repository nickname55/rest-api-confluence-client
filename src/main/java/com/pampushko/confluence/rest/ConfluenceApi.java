package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.NoContentResponse;
import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import retrofit2.Call;
import retrofit2.http.*;


/**
 * Класс описывающий Confluence REST API
 * <br />
 * В дальнейшем этот класс используется для создания retrofit адаптера
 * <br />
 */
public interface ConfluenceApi
{
	/**
	 * Возвращает список областей Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br />
	 */
	@GET("/wiki/rest/api/space")
	Call<SpaceResultList> getSpaces();
	
	/**
	 * Создаём новую область Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
	 * @param space - область {@code Space} для создания.
	 * <br />
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно создана
	 * <br />
	 */
	@POST("/wiki/rest/api/space")
	Call<Space> createSpace(final @Body Space space);
	
	/**
	 * Удаляем область Confluence - {@code Space}
	 * <br />
	 * имеющую ключ {@code key}
	 * <br />
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 * <br />
	 */
	@DELETE("/wiki/rest/api/space/{key}")
	Call<NoContentResponse> deleteSpace(final @Path("key") String key);
	
	
	/**
	 * Создание приватной области, которая будет видна только пользователю создавшему её
	 * <br />
	 * @param space - область {@code Space} для создания
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос
	 */
	@POST("/wiki/rest/api/space/_private")
	Call<Space> createPrivateSpace(final @Body Space space);
	
	/**
	 * Обновление области (в настоящий момент можно обновить только name, description и homepage)
	 * <br />
	 * @param space - область {@code Space} для создания
	 * @param key
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос (полное представлеине области)
	 */
	@PUT("/wiki/rest/api/space/{key}")
	Call<Space> updateSpace(final @Body Space space, final @Path("key") String key);
	
}
