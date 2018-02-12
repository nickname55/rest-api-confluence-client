package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.content.Content;
import com.pampushko.confluence.models.content.ContentContainter;
import com.pampushko.confluence.models.group.Group;
import com.pampushko.confluence.models.group.GroupResultList;
import com.pampushko.confluence.models.history.HistoryContainer;
import com.pampushko.confluence.models.macros.Macros;
import com.pampushko.confluence.models.search.SearchResultList;
import com.pampushko.confluence.models.user.UserResultList;
import com.pampushko.confluence.models.user_watch.WatchObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.*;

import java.util.Map;


/**
 * Класс описывающий Confluence REST API
 * <br>
 * В дальнейшем этот класс используется для создания retrofit адаптера
 * <br>
 */
public interface ConfluenceApi
{
	
	/**
	 * Возвращает список областей Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br>
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br>
	 */
	@GET("/wiki/rest/api/space")
	Call<SpaceResultList> getSpaces();
	
	/**
	 * Возвращает информацию об области Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key}
	 * <br>
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br>
	 */
	@GET("/wiki/rest/api/space/{key}")
	Call<Space> getSpaceByKey(@Path("key") String spaceKey,
	                          @QueryMap Map<String, String> params);
	
	/**
	 * Создаём новую область Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br>
	 *
	 * @param space
	 * 		- область {@code Space} для создания.
	 * 		<br>
	 *
	 * @return возвращаёмое значение {@code Call<Space>}, как подтверждение, что область действительно создана
	 * <br>
	 */
	@POST("/wiki/rest/api/space")
	Call<Space> createSpace(final @Body Space space);
	
	/**
	 * Удаляем область Confluence - {@code Space}
	 * <br>
	 * имеющую ключ {@code key}
	 * <br>
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 * <br>
	 */
	@DELETE("/wiki/rest/api/space/{key}")
	Call<NoContentResponse> deleteSpace(final @Path("key") String spaceKey);
	
	
	/**
	 * Создание приватной области, которая будет видна только пользователю создавшему её
	 * <br>
	 *
	 * @param space
	 * 		- область {@code Space} для создания
	 *
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос
	 */
	@POST("/wiki/rest/api/space/_private")
	Call<Space> createPrivateSpace(final @Body Space space);
	
	/**
	 * Обновление области (в настоящий момент можно обновить только name, description и homepage)
	 * <br>
	 *
	 * @param space
	 * 		- область {@code Space} для создания
	 * @param key
	 *
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос (полное представлеине области)
	 */
	@PUT("/wiki/rest/api/space/{key}")
	Call<Space> updateSpace(final @Body Space space,
	                        final @Path("key") String key);
	
	
	/**
	 * Получить список элементов контента из данной области
	 * <br>
	 *
	 * @param spaceKey
	 * @param params
	 *
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
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/group")
	Call<GroupResultList> getGroups(final @Query("start") int start,
	                                final @Query("limit") int limit);
	
	/**
	 * Получить группу по имени
	 * <br>
	 *
	 * @param groupName
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/group/{groupName}")
	Call<Group> getGroupsByName(final @Path("groupName") String groupName);
	
	/**
	 * Получить коллекцию пользователей состоящих в группе с заданным именем
	 * <br>
	 *
	 * @param groupName
	 * @param start
	 * @param limit
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/group/{groupName}/member")
	Call<UserResultList> getUsersFromGroupByGroupName(final @Path("groupName") String groupName,
	                                                  final @Query("start") int start,
	                                                  final @Query("limit") int limit);
	
	//----------------------------------------------------------------------------------------
	
	/**
	 * Выполнить поиск элементов при помощи CQL SearchService
	 * <br>
	 *
	 * @param cql
	 * 		the CQL query see advanced searching in confluence using CQL
	 * 		cqlcontext - the execution context for CQL functions, provides current space key and content id. If this is not provided some CQL functions will not be available.
	 * 		excerpt - the excerpt strategy to apply to the result, one of : indexed, highlight, none. This defaults to highlight.
	 * 		expand - the properties to expand on the search result, this may cause database requests for some properties
	 * 		start - the start point of the collection to return
	 * 		limit - the limit of the number of items to return, this may be restricted by fixed system limits
	 * 		includeArchivedSpaces - whether to include content in archived spaces in the result, this defaults to false
	 *
	 * @return Returns a full JSON representation of a list of search results
	 */
	@GET("/wiki/rest/api/search")
	Call<SearchResultList> search(final @Query("cql") String cql,
	                              final @QueryMap Map<String, String> params);
	
	
	//----------------------------------------------------------------------------------------
	//начало, Is watching content
	
	/**
	 * Текущий пользователь является наблюдателем контента с указанным contentId
	 * <br>
	 *
	 * @param contentId
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/user/watch/content/{contentId}")
	Call<WatchObject> isWatch(final @Path("contentId") String contentId);
	
	/**
	 * Является ли пользователь, имеющий указанный userKey, наблюдателем
	 * <br>
	 * контента (контент имеет идентификатор contentId)
	 * <br>
	 *
	 * @param contentId
	 * @param userKey
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/user/watch/content/{contentId}")
	Call<WatchObject> isWatchByKey(final @Path("contentId") String contentId,
	                               final @Query("key") String userKey);
	
	/**
	 * Является ли пользователь, имеющий указанное имя для входа (username),
	 * <br>
	 * наблюдателем контента (контент имеет идентификатор contentId)
	 * <br>
	 *
	 * @param contentId
	 * @param username
	 *
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
	 * <br>
	 * или публикует черновик, если в запросе присутствует идентификатор контента
	 * <br>
	 * Для случая публикации черновика,
	 * <br>
	 * будет создан новый элемент контента
	 * <br>
	 * и все метаданные из черновика будут перенесены во вновь созданный контент.
	 * <br>
	 *
	 * @param content
	 *
	 * @return
	 */
	@POST("wiki/rest/api/content")
	//готово
	Call<Content> createContent(final @Body Content content, final @QueryMap Map<String, String> param);
	
	
	
	/**
	 * Получить элемент контента по идентификатору этого элемента
	 *
	 * @param contentId dfv df
	 * @param params dfv d
	 *
	 * @return dfvdfv
	 */
	@GET("/wiki/rest/api/content/{contentId}")
	Call<PageResultItem> getContentById(@Path("contentId")	final String contentId,
	                                    @QueryMap	final Map<String, String> params);
	
	
	/**
	 * Получить версию контента по заданному индентификатору контента и номеру версии
	 * <br>
	 *
	 * @param contentId
	 * @param versionId
	 * @param params
	 *
	 * @return
	 */
	@GET("/wiki/rest/api/content/{contentId}/version/{versionId}") //готово
	Call<Version> getVersionOfContent(final @Path("contentId") String contentId,
	                                  final @Path("versionId") int versionId,
	                                  final @QueryMap Map<String, String> params);
	
	/**
	 *
	 * @param params
	 * @return
	 */
	@GET("/wiki/rest/api/content")
	//не готово
	Call<ContentContainter> getContent(@QueryMap Map<String, String> params);
	
	//@formatter:off
	/**
	 * Updates a piece of Content, including changes to content status
	 * <p>
	 * Чтобы обновить элемент контента, вы должны увеличить номер версии,
	 * <p>
	 * задавая номер версии, которую сейчас создаёте.
	 * <p>
	 * Свойство title может быть обновлено для всего контента.
	 * <p>
	 * Тело может быть обновлено для всего контента, у которого есть тело (не вложения!).
	 * <p>
	 * Например, чтобы обновить содержимое blogpost,
	 * <p>
	 * имеющего в настоящее время версию 1:
	 * <p>
	 * PUT /rest/api/content/456
	 * todo доделать вставку примеров кода в документацию! (сейчас код не форматирован а склеивается в одну строку)


	 *<blockquote><PRE>
{
  "version":
  {
    "number": 2
  },
  "title": "My new title",
  "type": "page",
  "body":
  {
    "storage":
    {
      "value": "&lt;p&gt;New page data.&lt;/p&gt;",
      "representation": "storage"
    }
  }
}
	 *</PRE></blockquote>
	 *


	 *
	 * Чтобы обновить страницу и одновременно изменить её страницу-родителя,
	 * установите в свойство ancestors
	 * первым значением родительскую страницу.
	 * Таким образом вы переместите текущую страницу
	 * и сделаете ее дочерней страницей от страницы с идентфикатором 789,
	 * как на примере ниже:
	 * <strong>PUT /rest/api/content/456</strong>
	 * <p><blockquote>
	 * <PRE>
	 *
{
    "version": {
        "number": 2
    },
    "ancestors": [
        {
            "id": 789
        }
    ],
    "type": "page",
    "body": {
        "storage": {
            "value": "<p>New page data.</p>",
            "representation": "storage"
        }
    }
}
	 *</PRE>
	 *</blockquote>
	 *
	 *<strong>Изменение статуса страницы</strong>
	 *
	 * Чтобы восстановить формат теста, который имеет статус "trashed" (помещенного в корзину содержимого)
	 * Вам необходимо установить для этого элемента контента увеличенную версию
	 * и его статус установить на текущий (<strong>current</strong>)
	 * Никакие другие изменения полей не будут выполнены
	 * при восстановлении элемента контента из корзины.
	 *<br>
	 * Пример запроса для восстановления из корзины:
	 * { "id": "557059", "status": "current", "version": { "number": 2 } }
	 *<br>
	 *Если контент, который вы обновляете, имеет черновик,
	 * то указание status=draft будет удаляте этот черновик,
	 * а тело элемента контента будет заменено на тело указанное вами в запросе.
	 *<br>
	 * Пример запроса на удаление черновика:
	 *<br>
	 *<strong>PUT: http://localhost:9096/confluence/rest/api/content/2149384202?status=draft</strong>
	 *<p><blockquote>
	 *<PRE>
{
    "id": "2149384202",
    "status": "current",
    "version": {
        "number": 4
    },
    "space": {
        "key": "TST"
    },
    "type": "page",
    "title": "page title",
    "body": {
        "storage": {
            "value": "<p>New page data.</p>",
            "representation": "storage"
        }
    }
}
	 *</PRE>
	 *</blockquote>
	 *
	 *<br>
	 * Обновление черновиков в настоящее время не поддерживается.
	 *<br>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>status (String) -- существующий статус для обновляемого контента</li>
	 *     <li>conflictPolicy (String) -- Default : <strong>abort</strong></li>
	 * </ul>
	 *<br>
	 * <strong>Пример</strong>
	 *
	 * <p><blockquote>
	 * <PRE>
{
    "id": "3604482",
    "type": "page",
    "status": "current",
    "title": "Example Content title",
    "space": {
        "key": "TST",
        "metadata": {}
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "ancestors": [],
    "operations": [],
    "children": {},
    "descendants": {},
    "body": {
        "storage": {
            "value": "<p>This is the updated text for the new page</p>",
            "representation": "storage"
        }
    },
    "metadata": {},
    "restrictions": {}
}

	 </PRE>
	 </blockquote>
	 
	 <p>
	 *
	 * <strong>Ответы</strong>
	 * 200 - application/json Returns a full JSON representation of a piece of content
	 
	 <p>
	 
	 
	 <blockquote>
	 <PRE>
{
    "id": "1234",
    "type": "page",
    "status": "current",
    "title": "Example Content title",
    "space": {
        "id": 11,
        "key": "TST",
        "name": "Example space",
        "description": {
            "plain": {
                "value": "This is an example space",
                "representation": "plain"
            }
        },
        "metadata": {},
        "_links": {
            "self": "http://myhost:8080/confluence/rest/api/space/TST"
        }
    },
    "version": {
        "by": {
            "type": "known",
            "username": "username",
            "userKey": "",
            "displayName": "Full Name",
            "_expandable": {
                "status": ""
            }
        },
        "when": "2017-12-11T03:52:47.153Z",
        "message": "change message for this edit",
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "ancestors": [
        {
            "id": "123",
            "type": "page",
            "status": "current",
            "ancestors": [],
            "operations": [],
            "children": {},
            "descendants": {},
            "body": {},
            "metadata": {},
            "restrictions": {},
            "_links": {
                "self": "http://myhost:8080/confluence/rest/api/content/123"
            }
        }
    ],
    "operations": [],
    "children": {},
    "descendants": {},
    "container": {
        "id": 11,
        "key": "TST",
        "name": "Example space",
        "description": {
            "plain": {
                "value": "This is an example space",
                "representation": "plain"
            }
        },
        "metadata": {},
        "_links": {
            "self": "http://myhost:8080/confluence/rest/api/space/TST"
        }
    },
    "body": {
        "view": {
            "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
            "representation": "view",
            "_expandable": {
                "content": "/rest/api/content/1234"
            }
        }
    },
    "metadata": {},
    "restrictions": {},
    "_links": {
        "collection": "/rest/api/content",
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/1234"
    }
}
	 </PRE>
	 </blockquote>
	 *
	 * <br>
	 * STATUS 400 -- if no space or no content type, or setup a wrong version type set to content, or status param is not draft and status content is current
	 * <br>
	 STATUS 404 -- if can not find draft with current content
	 * <br>
	 *
	 * @param contentId идентификатор контента
	 * @param params параметры
	 * @return обновлённый контент ??й
	 */
	//@formatter:on
	@PUT("/wiki/rest/api/content/{contentId}")
	Call<Content> updateContent(final @Body Content content,
	                            final @Path("contentId") String contentId,
	                            final @QueryMap Map<String, String> params);
	
	/**
	 * Удаляет контент имеющий указанный идентификатор
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор контента
	 *
	 * @return
	 */
	//готово
	@DELETE("/wiki/rest/api/content/{contentId}")
	Call<Response<Void>> deleteContentById(@Path(value = "contentId") final String contentId);
	
	/**
	 * Возвращает историю от выбранного элемента контента
	 * <br>
	 *
	 * @param contendId
	 * 		идентификатор контента
	 *
	 * @return коллекция истории контента
	 */
	//готово todo дописать документацию к методу
	@GET("/wiki/rest/api/content/{contentId}/history")
	Call<HistoryContainer> getContentHistory(final @Path("contentId") String contendId);
	
	/**
	 * Возвращает тело макроса (в storage формате) с указанным хешем.
	 * <br>
	 * Эта функция в основном используется для connect-приложений
	 * <br>
	 * которым необходимо тело макроса для того чтобы выполнить какую-то свою работу.
	 * <br>
	 * Хеш генерируется connect-ом во время рендеринга выполняемого локальным обработчиком макросов
	 * <br>
	 * и обычно сохраняет своё значение в пределах одного запроса
	 * <br>
	 * В целях оптимизации этот хеш обычно используется для нескольких запросов
	 * <br>
	 * Сбор макросов путём поиска по хешу должен считаться устаревшим,
	 * <br>
	 * и заменяется теперь при помощи поиска по macroId (смотрите ещё один такой же метод, как и текущий,
	 * <br>
	 * но принимающий параметр macroId)
	 * <br>
	 * Этот ресурс в настоящее время вызывается только из connect плагинов,
	 * <br>
	 * которые в конечном итоге? будут использовать ресурс
	 * #getContentById(com.atlassian.confluence.api.model.content.id.ContentId, java.util.List, Integer, String)
	 * <br>
	 * Чтобы сделать переход максимально безболезненным,
	 * <br>
	 * этот ресурс будет соответствовать ресурсу с генерированым хешем или сохраненным macroId.
	 * <br>
	 * Это позволит работать плагинам во время периода миграции.
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор контента
	 * @param version
	 * 		версия контента
	 * @param hash
	 * 		хеш макроса
	 *
	 * @return
	 */
	//готово
	@GET("/wiki/rest/api/content/{contentId}/history/{version}/macro/hash/{hash}")
	Call<Macros> getContentMacroBodyByHash(final @Path("contentId")String contentId,
	                                       final @Path("version")String version,
	                                       final @Path("hash")String hash);
	
	/**
	 * Возращает тело макроса (в storage формате) с указанным id.
	 * <br>
	 * Этот функция в основном используется connect-приложениями
	 * <br>
	 * которым необходимо тело макроса для того чтобы выполнить свою работу
	 * <br>
	 * Когда контент создан, если macroId не указан,
	 * <br>
	 * то Confluence будет генерировать случайный id.
	 * <br>
	 * Идентификатор (id) сохраняется, когда сохраняется контент
	 * <br>
	 * и может быть изменен Confluence, если имеются конфликтующие идентификаторы
	 * <br>
	 * Чтобы сохранить обратную совместимость, этот ресурс также будет матчить hash of the macro body,
	 * <br>
	 * даже если присутствует macroId.
	 * <br>
	 * Эта проверка станет излишней так как страницы получают macroId сгенерированный для них
	 * <br>
	 * и прозрачно распространяемый на все экземпляры (all instances).
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор контента
	 * @param version
	 * 		версия контента
	 * @param macroId
	 * 		идентификатор макроса
	 *
	 * @return контейнер, содержащий список элементов контента
	 */
	//готово
	@GET("/wiki/rest/api/content/{contentId}/history/{version}/macro/id/{macroId}")
	Call<Macros> getContentMacroBodyByMacroId(final @Path("contentId") String contentId,
	                                          final @Path("version") String version,
	                                          final @Path("macroId") String macroId);
	
	/**
	 * Получить список элементов контента,
	 * используя для запроса Confluence Query Language (CQL)
	 *
	 * @param cql
	 * 		текст запроса на Confluence Quiery Language
	 * @param params
	 * 		дополнительные параметры для поиска
	 *
	 * @return объект-контейнер, внутри которого находится коллекция найденных элементов контента
	 *
	 * @see <a href="https://developer.atlassian.com/display/CONFDEV/Advanced+Searching+using+CQL">
	 * Advanced searching using CQL
	 * </a>
	 * <br>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>cql (String) - задаётся отдельным параметром метода</li>
	 * <li>cqlcontext (String) - the context to execute a cql search in, this is the json serialized form of SearchContext</li>
	 * <li>expand (String) - a comma separated list of properties to expand on the content.</li>
	 * <li>start (int) - the start point of the collection to return</li>
	 * <li>limit (int, default:<strong>25</strong>) - the limit of the number of items to return, this may be restricted by fixed system limits </li>
	 * </ul>
	 */
	@GET("/wiki/rest/api/content/search")
	//не готово
	Call<ContentContainter> getContentSearch(final @Query("cql") String cql,
	                                         final @QueryMap Map<String, String> params);
	
	//-----------Content Конец ---------------
	//----------------------------------------------------------------------------------------
}
