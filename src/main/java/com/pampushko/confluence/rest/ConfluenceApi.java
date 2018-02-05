package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.group.Group;
import com.pampushko.confluence.models.group.GroupResultList;
import com.pampushko.confluence.models.search.SearchResultList;
import com.pampushko.confluence.models.user.UserResultList;
import com.pampushko.confluence.models.user_watch.WatchObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.*;

import java.util.Map;


/**
 * Класс описывающий Confluence REST API
 * <br />
 * В дальнейшем этот класс используется для создания retrofit адаптера
 * <br />
 */
public interface ConfluenceApi
{
	//----------------------------------------------------------------------------------------
	
	/**
	 * Возвращает список областей Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br />
	 */
	@GET("/wiki/rest/api/space")
	Call<SpaceResultList> getSpaces();
	
	/**
	 * Возвращает информацию об области Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key}
	 * <br />
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br />
	 */
	@GET("/wiki/rest/api/space/{key}")
	Call<Space> getSpaceByKey(final @Path("key") String spaceKey,
	                          final @QueryMap Map<String, String> params);
	
	/**
	 * Создаём новую область Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
	 *
	 * @param space - область {@code Space} для создания.
	 *              <br />
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
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 * <br />
	 */
	@DELETE("/wiki/rest/api/space/{key}")
	Call<NoContentResponse> deleteSpace(final @Path("key") String spaceKey);
	
	
	/**
	 * Создание приватной области, которая будет видна только пользователю создавшему её
	 * <br />
	 *
	 * @param space - область {@code Space} для создания
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос
	 */
	@POST("/wiki/rest/api/space/_private")
	Call<Space> createPrivateSpace(final @Body Space space);
	
	/**
	 * Обновление области (в настоящий момент можно обновить только name, description и homepage)
	 * <br />
	 *
	 * @param space - область {@code Space} для создания
	 * @param key
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос (полное представлеине области)
	 */
	@PUT("/wiki/rest/api/space/{key}")
	Call<Space> updateSpace(final @Body Space space,
	                        final @Path("key") String key);
	
	
	/**
	 * Получить список элементов контента из данной области
	 * <br />
	 *
	 * @param spaceKey
	 * @param params
	 * @return
	 */
	@GET("/wiki/rest/api/space/{key}/content")
	Call<ContentContainter> getSpaceContent(final @Path("key") String spaceKey,
	                                        final @QueryMap Map<String, String> params);
	
	/**
	 * Получить список групп (разбитый на страницы)
	 *
	 * @param start
	 * @param limit
	 * @return
	 */
	@GET("/wiki/rest/api/group")
	Call<GroupResultList> getGroups(final @Query("start") int start,
	                                final @Query("limit") int limit);
	
	/**
	 * Получить группу по имени
	 * <br />
	 *
	 * @param groupName
	 * @return
	 */
	@GET("/wiki/rest/api/group/{groupName}")
	Call<Group> getGroupsByName(final @Path("groupName") String groupName);
	
	/**
	 * Получить коллекцию пользователей состоящих в группе с заданным именем
	 * <br />
	 *
	 * @param groupName
	 * @param start
	 * @param limit
	 * @return
	 */
	@GET("/wiki/rest/api/group/{groupName}/member")
	Call<UserResultList> getUsersFromGroupByGroupName(final @Path("groupName") String groupName,
	                                                  final @Query("start") int start,
	                                                  final @Query("limit") int limit);
	
	//----------------------------------------------------------------------------------------
	
	/**
	 * Выполнить поиск элементов при помощи CQL SearchService
	 * <br />
	 *
	 * @param cql the CQL query see advanced searching in confluence using CQL
	 *            cqlcontext - the execution context for CQL functions, provides current space key and content id. If this is not provided some CQL functions will not be available.
	 *            excerpt - the excerpt strategy to apply to the result, one of : indexed, highlight, none. This defaults to highlight.
	 *            expand - the properties to expand on the search result, this may cause database requests for some properties
	 *            start - the start point of the collection to return
	 *            limit - the limit of the number of items to return, this may be restricted by fixed system limits
	 *            includeArchivedSpaces - whether to include content in archived spaces in the result, this defaults to false
	 * @return Returns a full JSON representation of a list of search results
	 */
	@GET("/wiki/rest/api/search")
	Call<SearchResultList> search(final @Query("cql") String cql,
	                              final @QueryMap Map<String, String> params);
	
	
	//----------------------------------------------------------------------------------------
	//начало, Is watching content
	
	/**
	 * Текущий пользователь является наблюдателем контента с указанным contentId
	 * <br />
	 * @param contentId
	 * @return
	 */
	@GET("/wiki/rest/api/user/watch/content/{contentId}")
	Call<WatchObject> isWatch(final @Path("contentId") String contentId);
	
	/**
	 * Является ли пользователь, имеющий указанный userKey, наблюдателем
	 * <br />
	 * контента (контент имеет идентификатор contentId)
	 * <br />
	 * @param contentId
	 * @param userKey
	 * @return
	 */
	@GET("/wiki/rest/api/user/watch/content/{contentId}")
	Call<WatchObject> isWatchByKey(final @Path("contentId") String contentId,
	                               final @Query("key") String userKey);
	
	/**
	 * Является ли пользователь, имеющий указанное имя для входа (username),
	 * <br />
	 * наблюдателем контента (контент имеет идентификатор contentId)
	 * <br />
	 * @param contentId
	 * @param username
	 * @return
	 */
	@GET("/wiki/rest/api/user/watch/content/{contentId}")
	Call<WatchObject> isWatchByUsername(final @Path("contentId") String contentId,
	                                    final @Query("username") String username);
	
	//конец, Is watching content
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//-----------Content Начало ---------------
	
	/**
	 * Создаёт новый элемент контента
	 * <br />
	 * или публикует черновик, если в запросе присутствует идентификатор контента
	 * <br />
	 * Для случая публикации черновика,
	 * <br />
	 * будет создан новый элемент контента
	 * <br />
	 * и все метаданные из черновика будут перенесены во вновь созданный контент.
	 * <br />
	 *
	 * @param content
	 * @return
	 */
	@POST("wiki/rest/api/content")
	//готово
	Call<Content> createContent(final @Body Content content,
	                            final @QueryMap Map<String, String> param);
	
	/**
	 * Получить элемент контента по идентификатору этого элемента
	 * <br />
	 *
	 * @param contentId
	 * @param params
	 * @return
	 */
	@GET("/wiki/rest/api/content/{contentId}")
	//готово
	Call<PageResultItem> getContentById(final @Path("contentId") String contentId,
	                                    final @QueryMap Map<String, String> params);
	
	/**
	 * Получить версию контента по заданному индентификатору контента и номеру версии
	 * <br />
	 *
	 * @param contentId
	 * @param versionId
	 * @param params
	 * @return
	 */
	//готово
	@GET("/wiki/rest/api/content/{contentId}/version/{versionId}")
	Call<Version> getVersionOfContent(final @Path("contentId") String contentId,
	                                  final @Path("versionId") int versionId,
	                                  final @QueryMap Map<String, String> params);
	
	@GET("/wiki/rest/api/content")
	Call<ContentContainter> getContent(@QueryMap Map<String, String> params);
	
	/**
	 * Updates a piece of Content, including changes to content status
	 *
	 * @param contentId
	 * @param params
	 * @return
	 */
	@PUT("/wiki/rest/api/content/{contentId}")
	Call<ContentContainter> getContent(final @Path("contentId") String contentId,
	                                   final @QueryMap Map<String, String> params);
	
	@DELETE("/wiki/rest/api/content/{contentId}")
	Call<ContentContainter> deleteContentById(final @Path("contentId") String contentId);
	
	@GET("/wiki/rest/api/content/{contentId}/history")
	Call<ContentContainter> getContentHistory(final @Path("contentId") String contendId);
	
	@GET("/wiki/rest/api/content/{contentId}/history/{version}/macro/hash/{hash}")
	Call<ContentContainter> getContentMacroBodyByHash(final @Path("contentId") String contentId,
	                                                  final @Path("version") String version,
	                                                  final @Path("hash") String hash);
	
	@GET("/wiki/rest/api/content/{contentId}/history/{version}/macro/id/{macroId}")
	Call<ContentContainter> getContentMacroBodyByMacroId(final @Path("contentId") String contentId,
	                                                     final @Path("version") String version,
	                                                     final @Path("macroId") String macroId);
	
	/**
	 * Получить список элементов контента,
	 * используя для запроса Confluence Query Language (CQL)
	 * @see <a href="https://developer.atlassian.com/display/CONFDEV/Advanced+Searching+using+CQL">
	 * Advanced searching using CQL
	 * </a>
	 * @param cql текст запроса на Confluence Quiery Language
	 * @param params дополнительные параметры для поиска
	 * @return объект-контейнер, внутри которого находится коллекция найденных элементов контента
	 */
	@GET("/wiki/rest/api/content/search")
	Call<ContentContainter> getContentSearch(final @Query("cql") String cql,
	                                         final @QueryMap Map<String, String> params);
	
	//-----------Content Конец ---------------
	//----------------------------------------------------------------------------------------
}
