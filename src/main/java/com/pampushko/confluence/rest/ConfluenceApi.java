package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.attachment.create.CreateAttResponseContainer;
import com.pampushko.confluence.models.attachment.update.UpdAttRequest;
import com.pampushko.confluence.models.attachment.update.UpdAttResponse;
import com.pampushko.confluence.models.audit.Audit;
import com.pampushko.confluence.models.audit.AuditResultList;
import com.pampushko.confluence.models.audit.RetentionPeriod;
import com.pampushko.confluence.models.child_content.ChildContentContainer;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachment;
import com.pampushko.confluence.models.child_content.comment.ChildComment;
import com.pampushko.confluence.models.child_content.page.ChildPage;
import com.pampushko.confluence.models.content.Content;
import com.pampushko.confluence.models.content.ContentContainter;
import com.pampushko.confluence.models.content.ContentResultList;
import com.pampushko.confluence.models.content_descendant.DescendantsResult;
import com.pampushko.confluence.models.content_property.PropListResponseContainer;
import com.pampushko.confluence.models.content_property.PropResponse;
import com.pampushko.confluence.models.content_property.PropertyOfContent;
import com.pampushko.confluence.models.content_property.PropertyOfContentWithVersion;
import com.pampushko.confluence.models.content_restriction.RestrictionResponseContainer;
import com.pampushko.confluence.models.content_restriction.restriction.Restriction;
import com.pampushko.confluence.models.convert.ConvertationResponsBody;
import com.pampushko.confluence.models.convert.req.ContentBody;
import com.pampushko.confluence.models.draft.Draft;
import com.pampushko.confluence.models.group.Group;
import com.pampushko.confluence.models.group.GroupResultList;
import com.pampushko.confluence.models.history.HistoryContainer;
import com.pampushko.confluence.models.label.Label;
import com.pampushko.confluence.models.label.LabelResultList;
import com.pampushko.confluence.models.macros.Macros;
import com.pampushko.confluence.models.search.SearchResultList;
import com.pampushko.confluence.models.user.UserResultList;

import com.pampushko.confluence.models.user_watch.WatchObject;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.*;

import java.util.List;
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
	//начало, Add content watcher
	
	//@formatter:off
	/**
	 * Функция добавляет пользователя, указанного вами, к списку наблюдателей элемента контента,
	 * <br>
	 * который вы указываете через contentId.
	 * <br>
	 * Пользователь не является обязательным параметром.
	 * <br>
	 * Если пользователь не указан, то будет использоваться текущий пользователь (отравитель запроса)
	 * <br>
	 * В противном случае, вы можете указать пользователя либо с помощью user key
	 * <br>
	 * или с помощью имени пользователя (username).
	 * <br>
	 * <br>
	 * <em>Обратите внимание, что только администраторы Confluence могут добавлять в наблюдатели не только себя, но и других пользователей системы.
	 * </em>
	 * <br>
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>POST http://example.com/rest/api/user/watch/content/131213</li>
	 * <li>POST http://example.com/rest/api/user/watch/content/131213?username=jblogs</li>
	 * <li>POST http://example.com/rest/api/user/watch/content/131213?key=ff8080815a58e24c015a58e263710000</li>
	 * </ul>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 * <li>key (String) -- Optional -- userkey по которому система найдёт пользователя, которого мы хотим добавить наблюдатели</li>
	 * <li>username (String) -- Optional -- username по которому система найдёт пользователя, которого мы хотим добавить в наблюдатели</li>
	 * <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 204</strong> -- application/json, такой ответ будет получен, если пользователь успешно добавлен в наблюдатели указанногов вами элементам контента
	 * <br>
	 * <strong>STATUS 404</strong> -- такой код будет возвращён, если для укзанного идентификатора контента соответствующий элемент контента не найден.
	 * <br>
	 * Или если пользователь выполняющий запрос не имеет достаточных прав доступа для выполнения операции.
	 * <br>
	 *
	 * @return
	 */
	@POST("/wiki/rest/api/user/watch/content/{contentId}")
	Call<Void> addWatcher(final @Path("contentId") String contentId);
	//@formatter:on
	
	
	//конец, Add content watcher
	//----------------------------------------------------------------------------------------
	
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
	 * @param contentId
	 * 		идентификатор контента
	 * @param params
	 * 		коллекция дополнительных параметров
	 *
	 * @return Call<PageResultItem> обертка для результата запроса (содержит внутри себя элемент контента)
	 */
	@GET("/wiki/rest/api/content/{contentId}")
	Call<PageResultItem> getContentById(@Path("contentId")    final String contentId,
	                                    @QueryMap    final Map<String, String> params);
	
	
	/**
	 * Получить версию контента по заданному индентификатору контента и номеру версии
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param versionId
	 * 		версия элемента контента
	 * @param params
	 * 		коллекция дополнительных параметров
	 *
	 * @return запрошенная версия контента
	 */
	@GET("/wiki/rest/api/content/{contentId}/version/{versionId}")
	//готово
	Call<Version> getVersionOfContent(final @Path("contentId") String contentId,
	                                  final @Path("versionId") int versionId,
	                                  final @QueryMap Map<String, String> params);
	
	//@formatter:off
	/**
	 * Returns a paginated list of Content.
	 * <br>
	 * Example request URI(s):
	 * <br>
	 * <strong>
http://example.com/rest/api/content?spaceKey=TST&title=Cheese&expand=space,body.view,version,container
	 <br>
http://example.com/rest/api/content?type=blogpost&spaceKey=TST&title=Bacon&postingDay=2014-02-13&expand=space,body.view,version,container
	 * </strong>
	 *
	 * <br>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>type (String, default:<strong>page</strong>) - the content type to return. Valid values: page, blogpost.</li>
	 * <li>spaceKey (String) - the space key to find content under</li>
	 * <li>title (String) - the title of the page to find. Required for page type.</li>
	 * <li>status (String) - list of statuses the content to be found is in. Defaults to current is not specified. If set to 'any', content in 'current' and 'trashed' status will be fetched. Does not support 'historical' status for now</li>
	 * <li>postingDay (String) - the posting day of the blog post. Required for blogpost type. Format: yyyy-mm-dd. Example: 2013-02-13</li>
	 * <li>
	 *    expand (String) - a comma separated list of properties to expand on the content. Default value: history,space,version.
	 * </li>
	 * <li>start (int) - the start point of the collection to return</li>
	 * <li>limit (int, default:<strong>25</strong>) - the limit of the number of items to return, this may be restricted by fixed system limits</li>
	 * @param params
	 * @return
	 */
	@GET("/wiki/rest/api/content")
	//не готово
	Call<ContentResultList> getContent(@QueryMap Map<String, String> params);
	//@formatter:on
	
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
	Call<Macros> getContentMacroBodyByHash(final @Path("contentId") String contentId,
	                                       final @Path("version") String version,
	                                       final @Path("hash") String hash);
	
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
	
	
	//-----------Audit Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
     * Fetch a paginated list of AuditRecord instances dating back to a certain time
     * <br>
     * <strong>Дополнительные параметры</strong>
     * <ul>
     * <li>startDate (String) -- </li>
     * <li>endDate (String) -- </li>
     * <li>start (int) -- where to start within results set</li>
     * <li>limit (int) -- Default : <strong>1000</strong> -- the maximum results to fetch</li>
     * <li>searchString (String) -- </li>
     * </ul>
     * <br>
     * <strong>Пример</strong>	 * @return
     */
	@GET("/wiki/rest/api/audit")
	Call<AuditResultList> getAudit(final @QueryMap Map<String, String> params);
	
	/**
     * Store record
     * <br>
     *
     * @param audit
     *
     * @return
     */
	@POST("/wiki/rest/api/audit")
	Call<Audit> createAudit(final @Body Audit audit);
	
	/**
     * <br>
     * <strong>Дополнительные параметры</strong>
     * <ul>
     * <li>startDate (String) -- </li>
     * <li>endDate (String) -- </li>
     * <li>searchString (String) -- </li>
     * <li>format (String) -- Default: <strong>csv</strong> -- </li>
     * </ul>
     * <br>
     * <strong>Responses</strong>
     * <ul>
     * <li>application/zip</li>
     * <li>text/csv</li>
     * </ul>
     *
     * @param params
     *
     * @return
     */
	@Streaming
	@GET("/wiki/rest/api/audit/export")
	Call<ResponseBody> exportAudit(@Header("Accept") String acceptHeader, final @QueryMap Map<String, String> params);
	
	/**
     * Получаем текущий период хранения (Fetches the current retention period)
     * <p>
     * <strong>Responses</strong>
     * application/json
     *
     * @return
     */
	@GET("/wiki/rest/api/audit/retention")
	Call<RetentionPeriod> getRetentionPeriodOfAudit();
	
	/**
     * Устанавливаем текущий период хранения (Set the retention period to a new value.)
     * <p>
     * Can throw ServiceException if the retention period is too long
     *
     * @param newRetentionPeriod
     *
     * @return
     */
	@PUT("/wiki/rest/api/audit/retention")
	Call<RetentionPeriod> setRetentionPeriodOfAudit(final @Body RetentionPeriod newRetentionPeriod);
	
	/**
     * Fetch a paginated list of AuditRecord instances dating back to a certain time
     * <br>
     * <strong>Дополнительные параметры</strong>
     * <ul>
     * <li>number (long) -- Default: <strong>3</strong> -- the amount of time periods</li>
     * <li>units (String) -- the units to use for the time periods eg. 'days', 'months' etc</li>
     * <li>start (int) -- where to start within results set</li>
     * <li>limit (int) -- Default: <strong>1000</strong> -- the maximum results to fetch</li>
     * <li>searchString (String) -- </li>
     * </ul>
     * <br>
     * <p>
     * <strong>Responses</strong>
     * application/json
     *
     * @param params
     *
     * @return
     */
	@GET("/wiki/rest/api/audit/since")
	Call<AuditResultList> getAuditSince(final @QueryMap Map<String, String> params);
	//-----------Audit Конец ---------------
	//----------------------------------------------------------------------------------------
	
	
	//----------- content/{id}/child Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * Возвращает map прямых (непосредственных) дочерних элементов (child) для некоторого элемента контента.
	 * <p>
	 * Контент может иметь несколько типов дочерних элементов,
	 * <p>
	 * которые могут также являться страницами, но кроме того это могут быть комментарии
	 * <p>
	 * и вложения.
	 * <p>
	 * ContentType дочерних элементов, которые будут возвращены запросом,
	 * <p>
	 * описывается в query параметре запроса - expand
	 * <p>
	 * Этот параметр может включать развёртывание множества дочерних типов.
	 * <p>
	 * Если в параметр expand не включены никакие типы,
	 * <p>
	 * возвращаемая map будет просто перечислять дочерние типы,
	 * <p>
	 * доступные для развёртывания для элемента контента Content,
	 * <p>
	 * на который (элемент контента) указывает параметр @Path - contentId.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child</li>
	 *     <li>http://example.com/rest/api/content/1234/child?expand=page.body.VIEW</li>
	 *     <li>http://example.com/rest/api/content/1234/child?expand=page&start=20&limit=10</li>
	 * </ul>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов</li>
	 *     <li>parentVersion (int) -- Default: <strong>0</strong> -- int, представляющий собой версию контента, для этой версии контента мы и будем получать дочерние элементы</li>
	 *     <li>start (int) -- </li>
	 *     <li>limit (int) -- Default: <strong>25</strong> -- </li>
	 * </ul>
	 * <br>
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- возвращает JSON-map,
	 * представляющую собой несколько упорядоченных наборов дочерних элементов контента
	 * <p>
	 * с ключами по типу содержимого
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "type": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2017-12-11T03:52:47.431Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 * </PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 * или если пользователь выполняющий запрос, не имеет разрешения на просмотр содержимого.
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры запроса
	 * @return набор дочерних элементов
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/child")
	Call<ChildContentContainer> getChild(final @Path("contentId") String contentId,
	                                     final @QueryMap Map<String, String> params);
	
	//@formatter:off
	/**
	 * Метод возвращает непосредственные дочерние элементы для данного элемента контента.
	 * <p>
	 * Отобранные дочерние элементы будут ограничены одним типом.
	 * <p>
	 * Тип контента (или типы) - ContentType - возвращаемых дочерних элементов,
	 * <p>
	 * задаётся параметром "type" заданным в пути (path) запроса.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/page</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/page?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&limit=10</li>
	 * </ul>
	 *
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов</li>
	 *     <li>parentVersion (int) -- Default: <strong>0</strong> -- int, представляющий собой версию контента, для этой версии контента мы и будем получать дочерние элементы</li>
	 *     <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 *     <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <br>
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- возвращает JSON-map,
	 * представляющую собой несколько упорядоченных наборов дочерних элементов контента
	 * <p>
	 * с ключами по типу содержимого
	 *
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "type": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2017-12-11T03:52:47.431Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 </PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param type тип дочерних элементов (мы отберем дочерние элементы для элемента контента и отфильтруем по нужному нам типу, элементов других типов в ответе не будет)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/child/{type}")
	Call<ChildContentContainer> getChildByType(final @Path("contentId") String contentId,
	                                           final @Path("type") String type,
	                                           final @QueryMap Map<String, String> params);
	
	//@formatter:off
	/**
	 * Метод возвращает непосредственные дочерние элементы для данного элемента контента.
	 * <p>
	 * Отобранные дочерние элементы будут ограничены одним типом.
	 * <p>
	 * Тип контента (или типы) - ContentType - возвращаемых дочерних элементов,
	 * <p>
	 * задаётся параметром "type" заданным в пути (path) запроса.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/page</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/page?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&limit=10</li>
	 * </ul>
	 *
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов</li>
	 *     <li>parentVersion (int) -- Default: <strong>0</strong> -- int, представляющий собой версию контента, для этой версии контента мы и будем получать дочерние элементы</li>
	 *     <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 *     <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <br>
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- возвращает JSON-map,
	 * представляющую собой несколько упорядоченных наборов дочерних элементов контента
	 * <p>
	 * с ключами по типу содержимого
	 *
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "type": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2017-12-11T03:52:47.431Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 </PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/child/page")
	Call<ChildPage> getChildPage(final @Path("contentId") String contentId,
	                             final @QueryMap Map<String, String> params);
	
	
	//@formatter:off
	/**
	 * Метод возвращает непосредственные дочерние элементы для данного элемента контента.
	 * <p>
	 * Отобранные дочерние элементы будут ограничены одним типом.
	 * <p>
	 * Тип контента (или типы) - ContentType - возвращаемых дочерних элементов,
	 * <p>
	 * задаётся параметром "type" заданным в пути (path) запроса.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/page</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/page?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&limit=10</li>
	 * </ul>
	 *
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов</li>
	 *     <li>parentVersion (int) -- Default: <strong>0</strong> -- int, представляющий собой версию контента, для этой версии контента мы и будем получать дочерние элементы</li>
	 *     <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 *     <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <br>
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- возвращает JSON-map,
	 * представляющую собой несколько упорядоченных наборов дочерних элементов контента
	 * <p>
	 * с ключами по типу содержимого
	 *
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "type": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2017-12-11T03:52:47.431Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 </PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/child/attachment")
	Call<ChildAttachment> getChildAttachment(final @Path("contentId") String contentId,
	                                         final @QueryMap Map<String, String> params);
	
	
	//@formatter:off
	/**
	 * Возвращает комментарии для заданного элемента контента.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&limit=10</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?location=footer&location=inline&location=resolved</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?expand=extensions.inlineProperties,extensions.resolution</li>
	 * </ul>
	 * <p>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов. Мы также можем указать некоторые расширения (extensions) такие как extensions.inlineProperties (для получения inline-свойств специфичных для комментариев) или можем указать extensions.resolution для получения resolution status для каждого комментария в результатах</li>
	 *     <li>parentVersion (int) -- Default: <strong>0</strong> -- int, представляющий собой версию контента, для этой версии контента мы и будем получать дочерние элементы</li>
	 *     <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 *     <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 *     <li>location (String) -- Optional -- Default: <strong>""</strong> -- расположение комментариев. Возможные значения : "inline", "footer", "resolved". Вы можете несколько параметров location. Результатом выборки будут комментарии, соответствующие любому значению из указанного вами списка местоположений.</li>
	 *     <li>depth (String) -- Optional -- Default: <strong>""</strong> -- Возможные значения: <strong>""</strong> (ROOT only) и <strong>"all"</strong> </li>
	 * </ul>
	 *
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- возвращает JSON-map,
	 * представляющую собой несколько упорядоченных наборов дочерних элементов контента
	 * <p>
	 * с ключами по типу содержимого
	 *
	 *<blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "type": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2017-12-11T03:52:47.431Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 *</PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/child/comment")
	Call<ChildComment> getChildComment(final @Path("contentId") String contentId,
	                                   final @QueryMap Map<String, String> params);
	
	
	//----------- content/{id}/child Конец ---------------
	//----------------------------------------------------------------------------------------
	
	
	//----------- content/{id}/child/attachment Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * <strong>
	 * Здесь выдержки из официальной документации к текущему эндпоинту Confluence
	 * <br>
	 * c моими небольшими комментариями:
	 * </strong>
	 * <br>
	 * Функция добавляет одно или несколько вложений todo (проверить по поводу нескольких)
	 * к объекту Content в Confluence.
	 * <br>
	 * Также к вложению можно добавить дополнительный комментарий (он будет потом отображаться при просмотре вложения, например в истории)
	 * <br>
	 * Комментарии необязательны, но если они включены в запрос, то комментариев должно быть столько же
	 * сколько и файлов (по количеству)
	 * <br>
	 * И комментарии должны следовать в том же порядке, что и файлы.
	 * <br>
	 * Ресурс в API Confluence ожидает multipart post.
	 * <br>
	 * Media-type multipart/form-data определён в RFC 1867.
	 * <br>
	 * Большинство клиентских библиотек имеют классы, которые упрощают работу с multipart post,
	 * <br>
	 * Retrofit, который мы используем в качестве клиента, тоже это делает при помощи классов MultipartBody.Part и RequestBody.
	 * <br>
	 * Чтобы защититься от атак XSRF (поскольку этот эндпоинт принимает multipart/form-data)
	 * <br>
	 * в нем присутствует защита (XSRF protection).
	 * <br>
	 * Это означает, что вы должны отправить заголовок X-Atlassian-Token: nocheck в своём запросе,
	 * <br>
	 * иначе этот запрос будет заблокирован.
	 * <br>
	 * (сейчас мы отправляем такой заголовок для всех запросов из нашего клиента)
	 * <br>
	 * <strong>Важно:
	 * Имя параметра multipart/form-data, который содержит вложения,
	 * должно быть "file"
	 * <br>
	 * </strong>
	 * <hr>
	 * <strong>
	 * Примеры:
	 * </strong>
	 * <p>
	 * Простой пример для добавления вложения с именем "myfile.txt" к контейнеру с идентификатором
	 * "123" и включенным комментарием:
	 * <PRE>
	 * curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: nocheck" -F "file=@myfile.txt" -F "comment=This is my File" http://myhost/rest/api/content/123/child/attachment
	 * </PRE>
	 * <p>
	 * Пример добавления вложения с именем "myfile.txt" к контейнеру с идентификатором "123",
	 * с добавлением комментария,
	 * и с установкой флага minorEdits в значение true:
	 * <PRE>
	 * curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: nocheck" -F "file=@myfile.txt" -F "minorEdit=true" -F "comment=This is my File" http://myhost/rest/api/content/123/child/attachment
	 * </PRE>
	 * <p>
	 * Пример присоединения только файла - без комментария:
	 * <PRE>
	 * curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: nocheck" -F "file=@myfile.txt" http://myhost/rest/api/content/123/child/attachment
	 * </PRE>
	 * <p>
	 * Пример запрашиваемого URI:
	 * <PRE>
	 * http://example.com/rest/api/content/1234/child/attachment
	 * </PRE>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>status (String) -- Default: <strong>current</strong> -- строка, содержащая статус контейнера к которому мы хотим добавить вложение, поддерживаются 2-ва значения: current или draft</li>
	 * </ul>
	 *
	 * <p>
	 *
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json
	 *
	 *<blockquote><PRE>
{
    "results": [
        {
            "id": "att5678",
            "type": "attachment",
            "status": "current",
            "title": "myfile.txt",
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
                "when": "2017-12-11T03:52:47.483Z",
                "message": "change message for this edit",
                "number": 2,
                "minorEdit": false,
                "hidden": false
            },
            "ancestors": [],
            "operations": [],
            "children": {},
            "descendants": {},
            "container": {
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
                    "when": "2017-12-11T03:52:47.483Z",
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
                    "self": "http://myhost:8080/confluence/rest/api/content/1234"
                }
            },
            "body": {},
            "metadata": {
                "comment": "This is my File",
                "mediaType": "text/plain"
            },
            "restrictions": {},
            "_links": {
                "self": "http://myhost:8080/confluence/rest/api/content/att5678"
            }
        }
    ],
    "size": 1,
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence"
    }
}
	 *</PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 403</strong> -- такой статус вы получите, если вложения отключены или вы не имеете разрешения на добавление вложения к указанному вами контенту
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, запрашиваемый контент не найден,
	 * у пользователя нет разрешения на просмотр, или если размер вложения превышает максимально допустимый (установленный в настройках Confluence)
	 * <br>
	 * @param parentContentId идентификатор страницы к которой мы добавляем контент
	 * @param fileBodyAndFileName параметр содержащий тела добавляемых файлов вложений и имена этих файлов
	 * @param comment комментарий (или, возможно, набор комментариев <strong>в том же количестве и том же порядке, что и вложения</strong>), которые мы добавляем к нашим вложениям
	 * @param params другие параметры, передаваемые в запросе
	 *
	 * @return специальный-объект контейнер, содержащий коллекцию с информацией о добавленных вложениях
	 */
	//@formatter:on
	@Multipart
	@POST("/wiki/rest/api/content/{contentId}/child/attachment")
	Call<CreateAttResponseContainer> createAttachment(final @Path("contentId") String parentContentId,
	                                                  @Part MultipartBody.Part fileBodyAndFileName,
	                                                  @Part("comment") String comment,
	                                                  final @QueryMap Map<String, String> params);
	
	//@formatter:off
	/**
	 * Функция обновляет не-двоичные данные вложения
	 * <br>
	 * (не содержимое самого файла вложения, а различные сопутствующие данные)
	 * <br>
	 * Эту функцию можно использовать для обновления
	 * <ul>
	 *     <li>имени файла-вложения</li>
	 *     <li>media-type</li>
	 *     <li>комментария</li>
	 *     <li>родительского контейнера вложения</li>
	 * </ul>
	 * <p>
	 * <strong>Примеры URI запроса:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/attachment/5678</li>
	 * </ul>
	 *
	 * <br>
	 * <h2><strong>Request</strong></h2>
	 * <strong>Пример</strong>
	 * <blockquote><PRE>
{
    "id": "att5678",
    "type": "attachment",
    "status": "current",
    "title": "new_file_name.txt",
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "ancestors": [],
    "operations": [],
    "children": {},
    "descendants": {},
    "body": {},
    "metadata": {},
    "restrictions": {}
}
	 * </PRE></blockquote>
	 * <br>
	 *<h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json
	 *
	 * <blockquote><PRE>
{
    "id": "att5678",
    "type": "attachment",
    "status": "current",
    "title": "myfile.txt",
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
        "when": "2017-12-11T03:52:47.421Z",
        "message": "change message for this edit",
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "ancestors": [],
    "operations": [],
    "children": {},
    "descendants": {},
    "container": {
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
            "when": "2017-12-11T03:52:47.421Z",
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
            "self": "http://myhost:8080/confluence/rest/api/content/1234"
        }
    },
    "body": {},
    "metadata": {
        "comment": "This is my File",
        "mediaType": "text/plain"
    },
    "restrictions": {},
    "_links": {
        "collection": "/rest/api/content",
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/att5678"
    }
}
	 </PRE></blockquote>
	 *
	 * <p>
	 * <strong>STATUS 400</strong> -- такой статус вы получите, если id вложения (attachment id) или версия вложения - не валидны
	 * <br>
	 * <p>
	 * <strong>STATUS 403</strong> -- такой статус вы получите, если вам не разрешено обновлять вложение или помещать это вложение в другой контейнер
	 * <br>
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует вложения с таким идентификатором, который вы указали (attachment id)
	 * <br>
	 * <p>
	 * <strong>STATUS 409</strong> -- такой статус вы получите, если версия прилагаемого вложения, не совпадает с точной версией вложения (с номером версии вложения который хранится в базе данных Confluence)
	 * <br>
	 * @param parentContentId идентификатор контейнера в котором находится вложение (это может быть страница, например)
	 * @param attachmentId идентификатор вложения
	 * @param params дополнительные параметры, которые мы передаем в запросе
	 * @return
	 */
	//@formatter:on
	@PUT("/wiki/rest/api/content/{contentId}/child/attachment/{attachmentId}")
	Call<UpdAttResponse> updateAttachment(final @Path("contentId") String parentContentId,
	                                      final @Path("attachmentId") String attachmentId,
	                                      final @Body UpdAttRequest body,
	                                      final @QueryMap Map<String, String> params);
	
	
	//@formatter:off
	/**
	 * <strong>
	 * Здесь выдержки из официальной документации к текущему эндпоинту Confluence
	 * <br>
	 * c моими небольшими комментариями:
	 * </strong>
	 * <br>
	 * Функция обновляет двоичные данные вложения (тело вложенного файла)
	 * <p>
	 * <br>
	 * И также, возможно, комментарий и поле minor edit todo уточнить, зачем нужно поле minor edit
	 * Комментарий будет потом отображаться при просмотре вложения, например в истории
	 * <br>
	 * Эта функция добавляет новую версию вложения, содержащую новые двоичные данные,
	 * новое имя файла и новый тип содержимого.
	 * При обновлении двоичных данных, комментарий связанный с файлом
	 * with the field that specifies if it's a minor edit can be updated as well, but are not required.
	 * <p>
	 * Если обновление считается незначительным <strong>(minor edit)</strong>,
	 * то уведомления не будут отправляться наблюдателям подписанным на этот контент.
	 * <p>
	 * Этот ресурс в API Confluence ожидает multipart post.
	 * <br>
	 * Media-type multipart/form-data определён в RFC 1867.
	 * <br>
	 * Большинство клиентских библиотек имеют классы, которые упрощают работу с multipart post,
	 * <br>
	 * Retrofit, который мы используем в качестве клиента, тоже это делает при помощи классов MultipartBody.Part и RequestBody.
	 * <br>
	 * Чтобы защититься от атак XSRF (поскольку этот эндпоинт принимает multipart/form-data)
	 * <br>
	 * в нем присутствует защита (XSRF protection).
	 * <br>
	 * Это означает, что вы должны отправить заголовок X-Atlassian-Token: nocheck в своём запросе,
	 * <br>
	 * иначе этот запрос будет заблокирован.
	 * <br>
	 * (сейчас мы отправляем такой заголовок для всех запросов из нашего клиента)
	 * <br>
	 * <strong>Важно:
	 * Имя параметра multipart/form-data, который содержит вложения,
	 * должно быть "file"
	 * <br>
	 * </strong>
	 * <hr>
	 * <strong>
	 * Примеры:
	 * </strong>
	 * <p>
	 * Простой пример для добавления файла с именем "myfile.txt" к вложению с идентификатором
	 * "456", находящемуся в контейнере с идентификатором "123", с обновляемым комментарием,
	 * с ключом minorEdit установленным в true:
	 * <PRE>
	 * curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: nocheck" -F "file=@myfile.txt" -F "minorEdit=true" -F "comment=This is my updated File" http://myhost/rest/api/content/123/child/attachment/456/data
	 * </PRE>
	 * <p>
	 * Пример добавления загрузки того же файла, но без комментария
	 * <PRE>
	 * curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: nocheck" -F "file=@myfile.txt" http://myhost/rest/api/content/123/child/attachment/456/data
	 * </PRE>
	 * <p>
	 * <p>
	 * Пример запрашиваемого URI:
	 * <PRE>
	 * http://example.com/rest/api/content/1234/child/attachment/5678/data
	 * </PRE>
	 * <p>
	 * <h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json
	 * <p>
	 * <blockquote><PRE>
{
    "results": [
        {
            "id": "att5678",
            "type": "attachment",
            "status": "current",
            "title": "myfile.txt",
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
                "when": "2018-03-05T02:39:02.582Z",
                "message": "change message for this edit",
                "number": 2,
                "minorEdit": false,
                "hidden": false
            },
            "ancestors": [],
            "operations": [],
            "children": {},
            "descendants": {},
            "container": {
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
                    "when": "2018-03-05T02:39:02.582Z",
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
                    "self": "http://myhost:8080/confluence/rest/api/content/1234"
                }
            },
            "body": {},
            "metadata": {
                "comment": "This is my File",
                "mediaType": "text/plain"
            },
            "restrictions": {},
            "_links": {
                "self": "http://myhost:8080/confluence/rest/api/content/att5678"
            }
        }
    ],
    "size": 1,
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence"
    }
}
	 * </PRE></blockquote>
	 * <p>
	 * <p>
	 * <strong>STATUS 400</strong> -- такой статус вы получите, если идентификатор вложения не валиден <strong>следует обратить внимание что id вложения должен иметь префикс att, например att1353453</strong>
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если по указанному идентификатору не удалось найти вложение
	 * <br>
	 *
	 *
	 * todo проверить все параметры и возвращаемые значения в методе!
	 * @param parentContentId
	 * 		идентификатор страницы к которой мы добавляем контент
	 * @param fileBody
	 * 		параметр содержащий тела добавляемых файлов вложений и имена этих файлов
	 * @param comment
	 * 		комментарий (или, возможно, набор комментариев <strong>в том же количестве и том же порядке, что и вложения</strong>), которые мы добавляем к нашим вложениям
	 * @param params
	 * 		другие параметры, передаваемые в запросе
	 *
	 * @return специальный-объект контейнер, содержащий коллекцию с информацией о добавленных вложениях
	 */
	//@formatter:on
	@Multipart
	@POST("/wiki/rest/api/content/{contentId}/child/attachment/{attachmentId}/data")
	Call<UpdAttResponse> updateAttachmentFileBody(final @Path("contentId") String parentContentId,
	                                              final @Path("attachmentId") String attachmentId,
	                                              final @Part MultipartBody.Part fileBody,
	                                              final @Part("comment") String comment,
	                                              final @QueryMap Map<String, String> params);
	
	//----------- content/{id}/child/attachment Конец ---------------
	//----------------------------------------------------------------------------------------
	
	
	//----------- content/{id}/descendant Начало ---------------
	//----------------------------------------------------------------------------------------
	//@formatter:off
	/**
	 * Возвращает map дочерних элементов (descendants) для указанного вами элемента контента
	 * <br>
	 * Контент может иметь несколько типов дочерних элементов, например,
	 * <br>
	 * страница может иметь потомков, которые также являются страницами,
	 * <br>
	 * но также она может иметь в виде дочерних элементов - комментарии и вложения.
	 * <br>
	 * <br>
	 * ContentType дочерних элементов возвращается, если указан параметр http-запроса "expand"
	 * <br>
	 * Параметр "expand" может включать expands для нескольких типов дочерних элементов
	 * <br>
	 * Если в параметр "expand" не включены никакие типы,
	 * <br>
	 * то возвращаемое отображение (map) будет просто перечислять типы дочерних элементов,
	 * <br>
	 * которые могут быть expanded для элемента на контента, на который мы указываем path-параметром "contentId"
	 * <br>
	 * В настоящее время поддерживаемыми descendants являются comment descendants относящиеся к non-comment Content.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>http://example.com/rest/api/content/1234/descendant</li>
	 * <li>http://example.com/rest/api/content/1234/descendant?expand=comment.body.VIEW</li>
	 * <li>http://example.com/rest/api/content/1234/descendant?expand=comment</li>
	 * </ul>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов <br>
	 *         (<strong>добавлен в качестве отдельного параметра в текущий метод. Это параметр final @Query("expand") String expand</strong>)</li>
	 * </ul>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает JSON map, представляющую собой несколько упорядоченных
	 * <br>
	 * коллекций дочерних элементов (descendants) указанного элемента контента. С ключом по типу содержимого
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "typeq": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2018-03-05T02:39:02.546Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 * </PRE></blockquote>
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если по указанному идентификатору элемент контента не найден, или же, если пользователь не имеет разрешения на просмотр содержимого
	 * <br>
	 *
	 * @param expand разделяемый запятыми список, состоящий из свойств потомков (descendants) перечисляя свойства в списке, мы указываем, что хотим их развернуть (expand)
	 *
	 * @return несколько упорядоченных коллекций дочерних элементов (descendants) указанного элемента контента. С ключом по типу содержимого.
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/descendant")
	Call<DescendantsResult> getContentDescendants(final @Path("contentId") String parentContentId,
	                                              final @Query("expand") String expand);
	
	
	//@formatter:off
	/**
	 * Возвращает direct descendants (непосредственных потомков) для указанного вами элемента контента,
	 * <br>
	 * Дочерние элементы ограничены определённым типом (это path-параметр "type")
	 * <br>
	 * Currently the only supported descendants are comment descendants of non-comment Content.
	 * <br>
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>http://example.com/rest/api/content/1234/descendant/comment</li>
	 * <li>http://example.com/rest/api/content/1234/descendant/comment?expand=body.VIEW</li>
	 * <li>http://example.com/rest/api/content/1234/descendant/comment?start=20&limit=10</li>
	 * </ul>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- разделённый запятыми список свойств, для разворачивания (expand) дочерних элементов <br>
	 *         (<strong>добавлен в качестве отдельного параметра в текущий метод. Это параметр final @Query("expand") String expand</strong>)</li>
	 *     <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 *     <li>limit (int) -- Optional -- Default: <strong>25</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает JSON map, представляющую собой несколько упорядоченных
	 * <br>
	 * коллекций дочерних элементов (descendants) указанного элемента контента. С ключом по типу содержимого
	 * <blockquote><PRE>
{
    "page": {
        "results": [
            {
                "id": "1234",
                "typeq": "page",
                "status": "current",
                "title": "Example Content title",
                "links": {},
                "space": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "history": null,
                "version": {
                    "by": {
                        "type": "known",
                        "username": "username",
                        "displayName": "Full Name",
                        "userKey": "",
                        "status": null
                    },
                    "when": "2018-03-05T02:39:02.546Z",
                    "message": "change message for this edit",
                    "number": 2,
                    "minorEdit": false,
                    "hidden": false,
                    "content": null
                },
                "ancestors": [
                    {
                        "id": "123",
                        "type": "page",
                        "status": "current",
                        "links": {},
                        "space": null,
                        "history": null,
                        "version": null,
                        "ancestors": [],
                        "operations": [],
                        "children": {},
                        "descendants": {},
                        "container": null,
                        "body": {},
                        "metadata": {},
                        "extensions": {},
                        "restrictions": {}
                    }
                ],
                "operations": [],
                "children": {},
                "descendants": {},
                "container": {
                    "id": 11,
                    "key": "TST",
                    "name": "Example space",
                    "icon": null,
                    "description": {
                        "plain": {
                            "representation": "plain",
                            "value": "This is an example space",
                            "webresource": null
                        }
                    },
                    "homepage": null,
                    "links": {},
                    "metadata": {}
                },
                "body": {
                    "view": {
                        "representation": "view",
                        "value": "&lt;p&gt;&lt;h1&gt;Example&lt;/h1&gt;Some example content body&lt;/p&gt;",
                        "webresource": null,
                        "content": null
                    }
                },
                "metadata": {},
                "extensions": {},
                "restrictions": {}
            }
        ],
        "size": 1
    }
}
	 * </PRE></blockquote>
	 * <p>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если по указанному идентификатору элемент контента не найден, или же, если пользователь не имеет разрешения на просмотр содержимого
	 * <br>
	 *
	 * @param expand разделяемый запятыми список, состоящий из свойств потомков (descendants) перечисляя свойства в списке, мы указываем, что хотим их развернуть (expand)
	 *
	 * @return несколько упорядоченных коллекций дочерних элементов (descendants) указанного элемента контента. С ключом по типу содержимого.
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/descendant/{type}")
	Call<ContentResultList> getContentDescendantsByType(final @Path("contentId") String parentContentId,
	                                                    final @Path("type") String type,
	                                                    final @Query("expand") String expand,
	                                                    final @QueryMap Map<String, String> params);
	//----------- content/{id}/descendant Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/{id}/label Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Возвращает список меток, для указанного элемента контента.
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>http://example.com/rest/api/content/1234/label</li>
	 * <li>http://example.com/rest/api/content/1234/label?prefix=global&start=0&limit=200</li>
	 * </ul>
	 * <p>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 * <li>prefix (String) -- префиксы для фильтрации меток с помощью Label.Prefix (смотрите дополнительно)</li>
	 * <li>start (int) -- Optional -- Default: <strong>0</strong> -- индекс первого элемента в результирующем возвращаемом наборе элементов</li>
	 * <li>limit (int) -- Optional -- Default: <strong>200</strong> -- сколько элементов из результирующего возвращаемого набора вы хотите получить (после начального индекса, после start)</li>
	 * </ul>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает список меток в JSON-формате (меток привязанных к элементу контента, id которого мы указали в запросе)
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или если пользователь выполняющий запрос не имеет достаточных прав доступа для просмотра контента.
	 *
	 * @param contentId
	 * 		идентификатор элемента контента, метки этого элемента контента мы хотим получить
	 *
	 * @return объект содержащий список меток
	 */
	@GET("/wiki/rest/api/content/{contentId}/label")
	Call<LabelResultList> getLabels(final @Path("contentId") String contentId);
	
	//@formatter:off
	/**
	 * Функция добавляет список меток к указанному элементу контента.
	 * <br>
	 * Тело запроса представляет собой JSON-представление списка меток.
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * <strong>Пример</strong>
	 * <blockquote><PRE>
[
    {
        "prefix": "global",
        "name": "label1"
    },
    {
        "prefix": "global",
        "name": "label2"
    }
]
	 * </PRE></blockquote>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает список меток в JSON-формате (меток привязанных к элементу контента, id которого мы указали в запросе)
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или если пользователь выполняющий запрос не имеет достаточных прав доступа для просмотра контента.
	 *
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем метки
	 * @param labels список объектов Label, которые при отправке запроса конвертируется в JSON-список
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@POST("/wiki/rest/api/content/{contentId}/label")
	Call<LabelResultList> addLabels(final @Path("contentId") String contentId,
	                                final @Body List<Label> labels);
	
	/**
	 * Удаляет метки (?) для указанного при помощи id элемента контента
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 204</strong> -- пустой ответ, возвращается при успешном удалении
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если у пользователя есть разрешение на просмотр, но отсутствует разрешение на редактирование контента.
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или если пользователь выполняющий запрос не имеет достаточных прав доступа для просмотра контента.
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор интересующего нас элемента контента
	 * @param labelName
	 * 		имя метки, которую мы хотим удалить
	 *
	 * @return todo описать возвращаемое значение
	 */
	@DELETE("/wiki/rest/api/content/{contentId}/label")
	Call<Object> deleteLabels(final @Path("contentId") String contentId,
	                          @Query(value = "name", encoded = false) String labelName);
	
	/**
	 * Удаляет метки (?) для указанного при помощи id элемента контента,
	 * <br>
	 * Отличается от метода {@link #deleteLabels(String, String)} тем,
	 * <br>
	 * что при вызове текущего метода нельзя передать в строке-значение параметра labelName символ "/"
	 * <br>
	 * (то есть нельзя указать имя метки, если она содержит такой символ).
	 * <br>
	 * Выполнить это не позволяют ограничения безопасности.
	 * <br>
	 * В данном случае предлагается вместо текущего метода, модификацию {@link #deleteLabels(String, String)}
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 204</strong> -- пустой ответ, возвращается при успешном удалении
	 * <br>
	 * <strong>STATUS 400</strong> -- возвращается, если вы пытаетесь удалить метку с символом "/" в имени метки.
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если у пользователя есть разрешение на просмотр, но отсутствует разрешение на редактирование контента.
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или если пользователь выполняющий запрос не имеет достаточных прав доступа для просмотра контента.
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор интересующего нас элемента контента
	 * @param labelName
	 * 		имя метки, которую мы хотим удалить
	 *
	 * @return todo описать возвращаемое значение
	 */
	@DELETE("/wiki/rest/api/content/{contentId}/label/{labelName}")
	Call<Object> deleteLabelsWithoutQueryParam(final @Path("contentId") String contentId,
	                                           final @Path("labelName") String labelName);
	//----------- content/{id}/label Конец ---------------
	//----------------------------------------------------------------------------------------
	
	
	//----------- content/{id}/property Начало ---------------
	//----------------------------------------------------------------------------------------
	
	
	//@formatter:off
	/**
	 * Функция возвращает свойства для указанного элемента контента
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>http://example.com/rest/api/content/1234/property/example-property-key?expand=content,version</li>
	 * </ul>
	 * <br>
	 *
	 *<br>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- Default : <strong>version</strong> -- список свойств, с запятыми в качестве разделителя, для того чтобы вы могли указать какое содержимое вы хотите видеть в ответе на запрос.</li>
	 *     <li>start (int) -- the start point of the collection to return</li>
	 *     <li>limit (int) -- Default : <strong>10</strong> -- the limit of the number of items to return, this may be restricted by fixed system limits</li>
	 * </ul>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает список свойств контента в JSON-формате (для контента, id которого мы указали в запросе)
	 * <br>
	 * <blockquote><PRE>
{
    "results": [
        {
            "content": {
                "id": "1234",
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
                    "self": "http://myhost:8080/confluence/rest/api/content/1234"
                }
            },
            "key": "example-property-key",
            "value": {
                "anything": "goes"
            },
            "version": {
                "number": 2,
                "minorEdit": false,
                "hidden": false
            },
            "_links": {
                "self": "http://myhost:8080/confluence/rest/api/content/1234/property/example-property-key"
            }
        }
    ],
    "size": 1,
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence"
    }
}
	 * </PRE></blockquote>
	 *
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или если пользователь выполняющий запрос не имеет достаточных прав доступа для просмотра контента.
	 *
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента относятся свойства (properties)
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/property")
	Call<PropListResponseContainer> getContentProperties(final @Path("contentId") String contentId);
	
	//@formatter:off
	/**
	 * Функция возвращает свойства для указанного элемента контента
	 * <p>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 * <li>http://example.com/rest/api/content/1234/property/example-property-key?expand=content,version</li>
	 * </ul>
	 * <br>
	 *
	 *<br>
	 * <strong>Дополнительные параметры</strong>
	 * <ul>
	 *     <li>expand (String) -- Default : <strong>version</strong> -- список свойств, с запятыми в качестве разделителя, для того чтобы вы могли указать какое содержимое вы хотите видеть в ответе на запрос.</li>
	 * </ul>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает полный список свойств контента в JSON-формате (для контента, id которого мы указали в запросе)
	 * <br>
	 * <blockquote><PRE>
{
    "content": {
        "id": "1234",
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
            "self": "http://myhost:8080/confluence/rest/api/content/1234"
        }
    },
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/1234/property/example-property-key"
    }
}
	 * </PRE></blockquote>
	 *
	 * <strong>STATUS 404</strong> -- возвращается, если не существует элемента контента, соответствующего указанному нами идентификатору, или нет свойства с заданным ключом (key), или если пользователь отправляющий запрос не имеет разрешения на просмотр данного контента.
	 *
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента относятся свойства (properties)
	 * @param propKey ключ, принадлежащий свойству (property) элемента контента
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@GET("/wiki/rest/api/content/{contentId}/property/{propKey}")
	Call<PropResponse> findByKeyContentProperties(final @Path("contentId") String contentId,
	                                              final @Path("propKey") String propKey);
	
	
	//@formatter:off
	/**
	 * Функция обновляет свойство элемента контента.
	 * <br>
	 * Тело запроса представляет собой JSON-представление свойства элемента контента.
	 * <br>
	 * Оно должно включать идентификаторо свойства и номер новой версии.
	 * <br>
	 * Попытка создать новое свойство, если заданный номер версии равен 1,
	 * <br>
	 * Выглядит как: {link #create(com.atlassian.confluence.api.model.content.id.ContentId, String, com.atlassian.confluence.api.model.content.JsonContentProperty)}.
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * <strong>Пример</strong>
	 * <blockquote><PRE>
{
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    }
}
	 * </PRE></blockquote>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает полное JSON-представление элемента контента
	 * <br>
	 * <blockquote><PRE>
{
    "content": {
        "id": "1234",
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
            "self": "http://myhost:8080/confluence/rest/api/content/1234"
        }
    },
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/1234/property/example-property-key"
    }
}
	 </PRE></blockquote>
	 * <strong>STATUS 400</strong> -- возвращается, если заданное свойство имеет не совпадающий с указанным в path идентификатор (ContentId), или если свойство имеет ключ (key), не совпдаающий с указанным в path ключом (key), или значение отсутствует, или значение имеет слишком большую длину.
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если у пользователя нет разрешения на редактирование содержимого с данным ContentId
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если нет элемента контента с указанным id, или если нет свойства с указанным ключом (key), или пользователь, выполняющий запрос, не имеет разрешения на просмотр данного элемента контента.
	 * <br>
	 * <strong>STATUS 409</strong> -- возвращается, если данная версия не соответствует ожидаемой целевой версии для обновляемого свойства.
	 * <br>
	 * <strong>STATUS 413</strong> -- возвращается, если значение имеет слишком большую длину.
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @param propKey ключ, принадлежащий свойству (property) элемента контента
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@PUT("/wiki/rest/api/content/{contentId}/property/{propKey}")
	Call<PropResponse> updateContentProperties(final @Path("contentId") String contentId,
	                                           final @Path("propKey") String propKey,
	                                           final @Body PropertyOfContentWithVersion body);
	
	
	//@formatter:off
	/**
	 * Функция удаляет свойство заданного элемента контента
	 * <br>
	 * </PRE></blockquote>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 204</strong> -- возвращается, если данное свойство успешно удалено
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если свойство с указанным ключом не найдено
	 * <br>
	 * <strong>STATUS 404</strong> -- возвращается, если нет контента с данным идентификатором (contentId)
	 * или если отправляющий запрос пользователь не имеет достаточных прав доступа для просмотра указанного элемента контента.
	 *
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @param propKey ключ, принадлежащий свойству (property) элемента контента
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@DELETE("/wiki/rest/api/content/{contentId}/property/{propKey}")
	Call<Void> deleteContentProperties(final @Path("contentId") String contentId,
	                                   final @Path("propKey") String propKey);
	
	
	//@formatter:off
	/**
	 * Функция создаёт новое свойство для указанного элемента контента.
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * <strong>Пример</strong>
	 * <blockquote><PRE>
{
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    }
}
	 * </PRE></blockquote>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает полное JSON представление свойств контента
	 * <br>
	 * <blockquote><PRE>
{
    "content": {
        "id": "1234",
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
            "self": "http://myhost:8080/confluence/rest/api/content/1234"
        }
    },
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/1234/property/example-property-key"
    }
}
	 * </PRE></blockquote>
	 * <strong>STATUS 400</strong> -- возвращается, если заданное свойство имеет другой ContentId (a different ContentId to the one in the path), или если контент уже имеет значение с заданным ключом, или значение отсутствует, или значение имеет слишком большую длину.
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если пользователь выполняющий запрос не имеет достаточных прав доступа для редактирования контента с указанным ContentId.
	 * <br>
	 * <strong>STATUS 409</strong> -- возвращается, если свойство с таким ключом уже существует.
	 * <br>
	 * <strong>STATUS 413</strong> -- возвращается, если значение имеет слишком большую длину
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @param propKey ключ, принадлежащий свойству (property) элемента контента
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@POST("/wiki/rest/api/content/{contentId}/property/{propKey}")
	Call<PropResponse> createContentPropertiesWithKey(final @Path("contentId") String contentId,
	                                                  final @Path("propKey") String propKey,
	                                                  final @Body PropertyOfContent body);
	
	
	//@formatter:off
	/**
	 * Функция новое свойство для указанного элемента контента.
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * <strong>Пример</strong>
	 * <blockquote><PRE>
{
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    }
}
	 * </PRE></blockquote>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает полное JSON представление свойств контента
	 * <br>
	 * <blockquote><PRE>
{
    "content": {
        "id": "1234",
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
            "self": "http://myhost:8080/confluence/rest/api/content/1234"
        }
    },
    "key": "example-property-key",
    "value": {
        "anything": "goes"
    },
    "version": {
        "number": 2,
        "minorEdit": false,
        "hidden": false
    },
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence",
        "self": "http://myhost:8080/confluence/rest/api/content/1234/property/example-property-key"
    }
}
	 * </PRE></blockquote>
	 * <strong>STATUS 400</strong> -- возвращается, если заданное свойство имеет другой ContentId (a different ContentId to the one in the path), или если контент уже имеет значение с заданным ключом, или значение отсутствует, или значение имеет слишком большую длину.
	 * <br>
	 * <strong>STATUS 403</strong> -- возвращается, если пользователь выполняющий запрос не имеет достаточных прав доступа для редактирования контента с указанным ContentId.
	 * <br>
	 * <strong>STATUS 413</strong> -- возвращается, если значение имеет слишком большую длину
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @return todo описать возвращаемое значение
	 */
	//@formatter:on
	@POST("/wiki/rest/api/content/{contentId}/property")
	Call<PropResponse> createContentProperties(final @Path("contentId") String contentId,
	                                           final @Body PropertyOfContent body);
	
	
	//----------- content/{id}/property Конец ---------------
	//----------------------------------------------------------------------------------------
	
	
	//----------- content/{id}/restriction Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * Возвращает информацию обо всех ограничениях по операциям
	 * <br>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>expand (String, default:<strong>update.restrictions.user,read.restrictions.group,read.restrictions.user,update.restrictions.group</strong>) - список свойств, с запятыми-разделителями, для развёртывания (expand) свойств содержимого. Значение по умолчанию: group (?)</li>
	 *
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает JSON представление restriction (ограничений) сгруппированных по операциям
	 * <br>
	 * <blockquote><PRE>
{
    "id": "https://docs.atlassian.com/jira/REST/schema/map-of-operation-key-and-content-restriction#",
    "title": "Map of Operation Key-and-Content Restriction",
    "type": "object",
    "patternProperties": {
        ".+": {
            "$ref": "#/definitions/content-restriction"
        }
    },
    "definitions": {
        "anonymous": {
            "title": "Anonymous",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "type": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "content": {
            "title": "Content",
            "type": "object",
            "properties": {
                "id": {
                    "title": "Content Id",
                    "type": "object"
                },
                "type": {
                    "title": "Content Type",
                    "type": "object"
                },
                "status": {
                    "title": "Content Status",
                    "type": "object"
                },
                "title": {
                    "type": "string"
                },
                "space": {
                    "type": "array",
                    "items": {
                        "title": "Space",
                        "type": "object",
                        "properties": {
                            "id": {
                                "type": "integer"
                            },
                            "key": {
                                "type": "string"
                            },
                            "name": {
                                "type": "string"
                            },
                            "icon": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/icon"
                                }
                            },
                            "description": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "title": "Formatted Body",
                                        "type": "object",
                                        "properties": {
                                            "value": {
                                                "type": "string"
                                            },
                                            "webresource": {
                                                "type": "array",
                                                "items": {
                                                    "$ref": "#/definitions/web-resource-dependencies"
                                                }
                                            },
                                            "representation": {
                                                "$ref": "#/definitions/content-representation"
                                            }
                                        },
                                        "additionalProperties": false
                                    }
                                },
                                "additionalProperties": false
                            },
                            "homepage": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/content"
                                }
                            },
                            "type": {
                                "title": "Space Type",
                                "type": "object"
                            },
                            "metadata": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {}
                                },
                                "additionalProperties": false
                            }
                        },
                        "additionalProperties": false
                    }
                },
                "history": {
                    "type": "array",
                    "items": {
                        "title": "History",
                        "type": "object",
                        "properties": {
                            "previousVersion": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "nextVersion": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "lastUpdated": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "latest": {
                                "type": "boolean"
                            },
                            "createdBy": {
                                "$ref": "#/definitions/person"
                            },
                            "createdDate": {
                                "type": "string"
                            },
                            "contributors": {
                                "type": "array",
                                "items": {
                                    "title": "Contributors",
                                    "type": "object",
                                    "properties": {
                                        "publishers": {
                                            "type": "array",
                                            "items": {
                                                "title": "Contributor Users",
                                                "type": "object",
                                                "properties": {
                                                    "users": {
                                                        "type": "array",
                                                        "items": {
                                                            "$ref": "#/definitions/person"
                                                        }
                                                    },
                                                    "userKeys": {
                                                        "type": "array",
                                                        "items": {
                                                            "type": "string"
                                                        }
                                                    }
                                                },
                                                "additionalProperties": false
                                            }
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false,
                        "required": [
                            "latest"
                        ]
                    }
                },
                "version": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "ancestors": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operations": {
                    "type": "array",
                    "items": {
                        "title": "Operation Check Result",
                        "type": "object",
                        "properties": {
                            "operation": {
                                "$ref": "#/definitions/operation-key"
                            }
                        },
                        "additionalProperties": false
                    }
                },
                "children": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "descendants": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "container": {
                    "type": "array",
                    "items": {
                        "title": "Container",
                        "type": "object"
                    }
                },
                "body": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "title": "Content Body",
                            "type": "object",
                            "properties": {
                                "value": {
                                    "type": "string"
                                },
                                "webresource": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/web-resource-dependencies"
                                    }
                                },
                                "representation": {
                                    "$ref": "#/definitions/content-representation"
                                },
                                "content": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/content"
                                    }
                                }
                            },
                            "additionalProperties": false
                        }
                    },
                    "additionalProperties": false
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "extensions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "restrictions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/content-restriction"
                        }
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "content-representation": {
            "title": "Content Representation",
            "type": "object"
        },
        "content-restriction": {
            "title": "Content Restriction",
            "type": "object",
            "properties": {
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operation": {
                    "$ref": "#/definitions/operation-key"
                },
                "restrictions": {
                    "type": "array",
                    "items": {
                        "title": "Subject Restrictions",
                        "type": "object",
                        "properties": {
                            "user": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/user"
                                }
                            },
                            "group": {
                                "type": "array",
                                "items": {
                                    "title": "Group",
                                    "type": "object",
                                    "properties": {
                                        "name": {
                                            "type": "string"
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        },
        "html-string": {
            "title": "Html String",
            "type": "object"
        },
        "icon": {
            "title": "Icon",
            "type": "object",
            "properties": {
                "path": {
                    "type": "string"
                },
                "width": {
                    "type": "integer"
                },
                "height": {
                    "type": "integer"
                },
                "isDefault": {
                    "type": "boolean"
                }
            },
            "additionalProperties": false,
            "required": [
                "width",
                "height",
                "isDefault"
            ]
        },
        "known-user": {
            "title": "Known User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                },
                "status": {
                    "type": "array",
                    "items": {
                        "title": "User Status",
                        "type": "object"
                    }
                }
            },
            "additionalProperties": false
        },
        "operation-key": {
            "title": "Operation Key",
            "type": "object"
        },
        "person": {
            "title": "Person",
            "type": "object",
            "anyOf": [
                {
                    "$ref": "#/definitions/anonymous"
                },
                {
                    "$ref": "#/definitions/known-user"
                },
                {
                    "$ref": "#/definitions/unknown-user"
                },
                {
                    "$ref": "#/definitions/user"
                }
            ]
        },
        "unknown-user": {
            "title": "Unknown User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "user": {
            "title": "User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "version": {
            "title": "Version",
            "type": "object",
            "properties": {
                "by": {
                    "$ref": "#/definitions/person"
                },
                "when": {
                    "type": "string"
                },
                "message": {
                    "type": "string"
                },
                "number": {
                    "type": "integer"
                },
                "minorEdit": {
                    "type": "boolean"
                },
                "hidden": {
                    "type": "boolean"
                },
                "syncRev": {
                    "type": "string"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "number",
                "minorEdit",
                "hidden"
            ]
        },
        "web-resource-dependencies": {
            "title": "Web Resource Dependencies",
            "type": "object",
            "properties": {
                "keys": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "contexts": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "uris": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "type": "string",
                                "format": "uri"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "tags": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/html-string"
                        }
                    },
                    "additionalProperties": false
                },
                "superbatch": {
                    "type": "array",
                    "items": {
                        "title": "Super Batch Web Resources",
                        "type": "object",
                        "properties": {
                            "uris": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "type": "array",
                                        "items": {
                                            "type": "string",
                                            "format": "uri"
                                        }
                                    }
                                },
                                "additionalProperties": false
                            },
                            "tags": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "$ref": "#/definitions/html-string"
                                    }
                                },
                                "additionalProperties": false
                            },
                            "metatags": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/html-string"
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        }
    },
    "additionalProperties": false
}
	 * </PRE></blockquote>
	 * @param contentId
	 * @return
	 */
	@GET("/wiki/rest/api/content/{contentId}/restriction/byOperation")
	Call<RestrictionResponseContainer> getContentRestrictionByOperation(final @Path("contentId") String contentId);
	//@formatter:on
	
	//@formatter:off
	/**
	 * Возвращает информацию обо всех ограничениях для данной операции
	 * <br>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>expand (String, default:<strong>restrictions.user,restrictions.group</strong>) - список свойств (с разделитем-запятой между значениями) для развёртывания (expand) свойств содержимого. Значение по умолчанию: group (?)</li>
	 * <li>start (int) - старт разбиения на страницы (pagination start)</li>
	 * <li>limit (int, default:<strong>100</strong>) - ограничение (limit) для разбиения на страницы (pagination limit)</li>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * <strong>STATUS 200</strong> -- application/json, возвращает JSON представление restriction (ограничений) для данной операции
	 * <br>
	 * <blockquote><PRE>
   {
    "id": "https://docs.atlassian.com/jira/REST/schema/content-restriction#",
    "title": "Content Restriction",
    "type": "object",
    "properties": {
        "content": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/content"
            }
        },
        "operation": {
            "$ref": "#/definitions/operation-key"
        },
        "restrictions": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/subject-restrictions"
            }
        }
    },
    "definitions": {
        "anonymous": {
            "title": "Anonymous",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "type": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "content": {
            "title": "Content",
            "type": "object",
            "properties": {
                "id": {
                    "title": "Content Id",
                    "type": "object"
                },
                "type": {
                    "title": "Content Type",
                    "type": "object"
                },
                "status": {
                    "title": "Content Status",
                    "type": "object"
                },
                "title": {
                    "type": "string"
                },
                "space": {
                    "type": "array",
                    "items": {
                        "title": "Space",
                        "type": "object",
                        "properties": {
                            "id": {
                                "type": "integer"
                            },
                            "key": {
                                "type": "string"
                            },
                            "name": {
                                "type": "string"
                            },
                            "icon": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/icon"
                                }
                            },
                            "description": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "title": "Formatted Body",
                                        "type": "object",
                                        "properties": {
                                            "value": {
                                                "type": "string"
                                            },
                                            "webresource": {
                                                "type": "array",
                                                "items": {
                                                    "$ref": "#/definitions/web-resource-dependencies"
                                                }
                                            },
                                            "representation": {
                                                "$ref": "#/definitions/content-representation"
                                            }
                                        },
                                        "additionalProperties": false
                                    }
                                },
                                "additionalProperties": false
                            },
                            "homepage": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/content"
                                }
                            },
                            "type": {
                                "title": "Space Type",
                                "type": "object"
                            },
                            "metadata": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {}
                                },
                                "additionalProperties": false
                            }
                        },
                        "additionalProperties": false
                    }
                },
                "history": {
                    "type": "array",
                    "items": {
                        "title": "History",
                        "type": "object",
                        "properties": {
                            "previousVersion": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "nextVersion": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "lastUpdated": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/version"
                                }
                            },
                            "latest": {
                                "type": "boolean"
                            },
                            "createdBy": {
                                "$ref": "#/definitions/person"
                            },
                            "createdDate": {
                                "type": "string"
                            },
                            "contributors": {
                                "type": "array",
                                "items": {
                                    "title": "Contributors",
                                    "type": "object",
                                    "properties": {
                                        "publishers": {
                                            "type": "array",
                                            "items": {
                                                "title": "Contributor Users",
                                                "type": "object",
                                                "properties": {
                                                    "users": {
                                                        "type": "array",
                                                        "items": {
                                                            "$ref": "#/definitions/person"
                                                        }
                                                    },
                                                    "userKeys": {
                                                        "type": "array",
                                                        "items": {
                                                            "type": "string"
                                                        }
                                                    }
                                                },
                                                "additionalProperties": false
                                            }
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false,
                        "required": [
                            "latest"
                        ]
                    }
                },
                "version": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "ancestors": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operations": {
                    "type": "array",
                    "items": {
                        "title": "Operation Check Result",
                        "type": "object",
                        "properties": {
                            "operation": {
                                "$ref": "#/definitions/operation-key"
                            }
                        },
                        "additionalProperties": false
                    }
                },
                "children": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "descendants": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "container": {
                    "type": "array",
                    "items": {
                        "title": "Container",
                        "type": "object"
                    }
                },
                "body": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "title": "Content Body",
                            "type": "object",
                            "properties": {
                                "value": {
                                    "type": "string"
                                },
                                "webresource": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/web-resource-dependencies"
                                    }
                                },
                                "representation": {
                                    "$ref": "#/definitions/content-representation"
                                },
                                "content": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/content"
                                    }
                                }
                            },
                            "additionalProperties": false
                        }
                    },
                    "additionalProperties": false
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "extensions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "restrictions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "title": "Content Restriction",
                            "type": "object",
                            "properties": {
                                "content": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/content"
                                    }
                                },
                                "operation": {
                                    "$ref": "#/definitions/operation-key"
                                },
                                "restrictions": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/subject-restrictions"
                                    }
                                }
                            },
                            "additionalProperties": false
                        }
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "content-representation": {
            "title": "Content Representation",
            "type": "object"
        },
        "html-string": {
            "title": "Html String",
            "type": "object"
        },
        "icon": {
            "title": "Icon",
            "type": "object",
            "properties": {
                "path": {
                    "type": "string"
                },
                "width": {
                    "type": "integer"
                },
                "height": {
                    "type": "integer"
                },
                "isDefault": {
                    "type": "boolean"
                }
            },
            "additionalProperties": false,
            "required": [
                "width",
                "height",
                "isDefault"
            ]
        },
        "known-user": {
            "title": "Known User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                },
                "status": {
                    "type": "array",
                    "items": {
                        "title": "User Status",
                        "type": "object"
                    }
                }
            },
            "additionalProperties": false
        },
        "operation-key": {
            "title": "Operation Key",
            "type": "object"
        },
        "person": {
            "title": "Person",
            "type": "object",
            "anyOf": [
                {
                    "$ref": "#/definitions/anonymous"
                },
                {
                    "$ref": "#/definitions/known-user"
                },
                {
                    "$ref": "#/definitions/unknown-user"
                },
                {
                    "$ref": "#/definitions/user"
                }
            ]
        },
        "subject-restrictions": {
            "title": "Subject Restrictions",
            "type": "object",
            "properties": {
                "user": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/user"
                    }
                },
                "group": {
                    "type": "array",
                    "items": {
                        "title": "Group",
                        "type": "object",
                        "properties": {
                            "name": {
                                "type": "string"
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        },
        "unknown-user": {
            "title": "Unknown User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "user": {
            "title": "User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "version": {
            "title": "Version",
            "type": "object",
            "properties": {
                "by": {
                    "$ref": "#/definitions/person"
                },
                "when": {
                    "type": "string"
                },
                "message": {
                    "type": "string"
                },
                "number": {
                    "type": "integer"
                },
                "minorEdit": {
                    "type": "boolean"
                },
                "hidden": {
                    "type": "boolean"
                },
                "syncRev": {
                    "type": "string"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "number",
                "minorEdit",
                "hidden"
            ]
        },
        "web-resource-dependencies": {
            "title": "Web Resource Dependencies",
            "type": "object",
            "properties": {
                "keys": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "contexts": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "uris": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "type": "string",
                                "format": "uri"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "tags": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/html-string"
                        }
                    },
                    "additionalProperties": false
                },
                "superbatch": {
                    "type": "array",
                    "items": {
                        "title": "Super Batch Web Resources",
                        "type": "object",
                        "properties": {
                            "uris": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "type": "array",
                                        "items": {
                                            "type": "string",
                                            "format": "uri"
                                        }
                                    }
                                },
                                "additionalProperties": false
                            },
                            "tags": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "$ref": "#/definitions/html-string"
                                    }
                                },
                                "additionalProperties": false
                            },
                            "metatags": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/html-string"
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        }
    },
    "additionalProperties": false
}
	 * </PRE></blockquote>
	 * @param contendId
	 * @param operationKey
	 * @return
	 */
	@GET("/wiki/rest/api/content/{contentId}/restriction/byOperation/{operationKey}")
	Call<Restriction> getContentRestrictionForOperation(final @Path("contentId") String contendId,
	                                               final @Path("operationKey") String operationKey);
	//@formatter:on
	
	//----------- content/{id}/restriction Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/blueprint Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * Publish устаревшего черновика элемента контента, созданного из ConfluenceBlueprint
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>status (String, default:<strong>draft</strong>) - </li>
	 * <li>expand (String, default: <strong>body.storage,history,space,version,ancestors</strong>) - </li>
	 * <br>
	 *
	 * <blockquote><PRE>
{
    "id": "https://docs.atlassian.com/jira/REST/schema/content#",
    "title": "Content",
    "type": "object",
    "properties": {
        "id": {
            "$ref": "#/definitions/content-id"
        },
        "type": {
            "$ref": "#/definitions/content-type"
        },
        "status": {
            "$ref": "#/definitions/content-status"
        },
        "title": {
            "type": "string"
        },
        "space": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/space"
            }
        },
        "history": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/history"
            }
        },
        "version": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/version"
            }
        },
        "ancestors": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/content"
            }
        },
        "operations": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/operation-check-result"
            }
        },
        "children": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "descendants": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "container": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/container"
            }
        },
        "body": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "$ref": "#/definitions/content-body"
                }
            },
            "additionalProperties": false
        },
        "metadata": {
            "type": "object",
            "patternProperties": {
                ".+": {}
            },
            "additionalProperties": false
        },
        "extensions": {
            "type": "object",
            "patternProperties": {
                ".+": {}
            },
            "additionalProperties": false
        },
        "restrictions": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "$ref": "#/definitions/content-restriction"
                }
            },
            "additionalProperties": false
        }
    },
    "definitions": {
        "anonymous": {
            "title": "Anonymous",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "type": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "container": {
            "title": "Container",
            "type": "object"
        },
        "content": {
            "title": "Content",
            "type": "object",
            "properties": {
                "id": {
                    "$ref": "#/definitions/content-id"
                },
                "type": {
                    "$ref": "#/definitions/content-type"
                },
                "status": {
                    "$ref": "#/definitions/content-status"
                },
                "title": {
                    "type": "string"
                },
                "space": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/space"
                    }
                },
                "history": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/history"
                    }
                },
                "version": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "ancestors": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operations": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/operation-check-result"
                    }
                },
                "children": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "descendants": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "container": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/container"
                    }
                },
                "body": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/content-body"
                        }
                    },
                    "additionalProperties": false
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "extensions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "restrictions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/content-restriction"
                        }
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "content-body": {
            "title": "Content Body",
            "type": "object",
            "properties": {
                "value": {
                    "type": "string"
                },
                "webresource": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/web-resource-dependencies"
                    }
                },
                "representation": {
                    "$ref": "#/definitions/content-representation"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "content-id": {
            "title": "Content Id",
            "type": "object"
        },
        "content-representation": {
            "title": "Content Representation",
            "type": "object"
        },
        "content-restriction": {
            "title": "Content Restriction",
            "type": "object",
            "properties": {
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operation": {
                    "$ref": "#/definitions/operation-key"
                },
                "restrictions": {
                    "type": "array",
                    "items": {
                        "title": "Subject Restrictions",
                        "type": "object",
                        "properties": {
                            "user": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/user"
                                }
                            },
                            "group": {
                                "type": "array",
                                "items": {
                                    "title": "Group",
                                    "type": "object",
                                    "properties": {
                                        "name": {
                                            "type": "string"
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        },
        "content-status": {
            "title": "Content Status",
            "type": "object"
        },
        "content-type": {
            "title": "Content Type",
            "type": "object"
        },
        "history": {
            "title": "History",
            "type": "object",
            "properties": {
                "previousVersion": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "nextVersion": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "lastUpdated": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "latest": {
                    "type": "boolean"
                },
                "createdBy": {
                    "$ref": "#/definitions/person"
                },
                "createdDate": {
                    "type": "string"
                },
                "contributors": {
                    "type": "array",
                    "items": {
                        "title": "Contributors",
                        "type": "object",
                        "properties": {
                            "publishers": {
                                "type": "array",
                                "items": {
                                    "title": "Contributor Users",
                                    "type": "object",
                                    "properties": {
                                        "users": {
                                            "type": "array",
                                            "items": {
                                                "$ref": "#/definitions/person"
                                            }
                                        },
                                        "userKeys": {
                                            "type": "array",
                                            "items": {
                                                "type": "string"
                                            }
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "latest"
            ]
        },
        "html-string": {
            "title": "Html String",
            "type": "object"
        },
        "icon": {
            "title": "Icon",
            "type": "object",
            "properties": {
                "path": {
                    "type": "string"
                },
                "width": {
                    "type": "integer"
                },
                "height": {
                    "type": "integer"
                },
                "isDefault": {
                    "type": "boolean"
                }
            },
            "additionalProperties": false,
            "required": [
                "width",
                "height",
                "isDefault"
            ]
        },
        "known-user": {
            "title": "Known User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                },
                "status": {
                    "type": "array",
                    "items": {
                        "title": "User Status",
                        "type": "object"
                    }
                }
            },
            "additionalProperties": false
        },
        "operation-check-result": {
            "title": "Operation Check Result",
            "type": "object",
            "properties": {
                "operation": {
                    "$ref": "#/definitions/operation-key"
                }
            },
            "additionalProperties": false
        },
        "operation-key": {
            "title": "Operation Key",
            "type": "object"
        },
        "person": {
            "title": "Person",
            "type": "object",
            "anyOf": [
                {
                    "$ref": "#/definitions/anonymous"
                },
                {
                    "$ref": "#/definitions/known-user"
                },
                {
                    "$ref": "#/definitions/unknown-user"
                },
                {
                    "$ref": "#/definitions/user"
                }
            ]
        },
        "space": {
            "title": "Space",
            "type": "object",
            "properties": {
                "id": {
                    "type": "integer"
                },
                "key": {
                    "type": "string"
                },
                "name": {
                    "type": "string"
                },
                "icon": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/icon"
                    }
                },
                "description": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "title": "Formatted Body",
                            "type": "object",
                            "properties": {
                                "value": {
                                    "type": "string"
                                },
                                "webresource": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/web-resource-dependencies"
                                    }
                                },
                                "representation": {
                                    "$ref": "#/definitions/content-representation"
                                }
                            },
                            "additionalProperties": false
                        }
                    },
                    "additionalProperties": false
                },
                "homepage": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "type": {
                    "title": "Space Type",
                    "type": "object"
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "unknown-user": {
            "title": "Unknown User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "user": {
            "title": "User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "version": {
            "title": "Version",
            "type": "object",
            "properties": {
                "by": {
                    "$ref": "#/definitions/person"
                },
                "when": {
                    "type": "string"
                },
                "message": {
                    "type": "string"
                },
                "number": {
                    "type": "integer"
                },
                "minorEdit": {
                    "type": "boolean"
                },
                "hidden": {
                    "type": "boolean"
                },
                "syncRev": {
                    "type": "string"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "number",
                "minorEdit",
                "hidden"
            ]
        },
        "web-resource-dependencies": {
            "title": "Web Resource Dependencies",
            "type": "object",
            "properties": {
                "keys": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "contexts": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "uris": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "type": "string",
                                "format": "uri"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "tags": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/html-string"
                        }
                    },
                    "additionalProperties": false
                },
                "superbatch": {
                    "type": "array",
                    "items": {
                        "title": "Super Batch Web Resources",
                        "type": "object",
                        "properties": {
                            "uris": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "type": "array",
                                        "items": {
                                            "type": "string",
                                            "format": "uri"
                                        }
                                    }
                                },
                                "additionalProperties": false
                            },
                            "tags": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "$ref": "#/definitions/html-string"
                                    }
                                },
                                "additionalProperties": false
                            },
                            "metatags": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/html-string"
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        }
    },
    "additionalProperties": false
}
	 * </PRE></blockquote>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * application/json
	 */
	@POST("/wiki/rest/api/content/blueprint/instance/{draftId}")
	Call<Object> publishLegacyDraftOfBlueprint(final @Path("draftId") String draftId,
	                                           final @Body Draft draftBody);
	//@formatter:on
	
	//@formatter:off
	/**
	 * Publish shared черновик элемента контента, созданного из ConfluenceBlueprint
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>status (String, default:<strong>draft</strong>) - </li>
	 * <li>expand (String, default: <strong>body.storage,history,space,version,ancestors</strong>) - </li>
	 * <br>
	 *
	 * <blockquote><PRE>
{
    "id": "https://docs.atlassian.com/jira/REST/schema/content#",
    "title": "Content",
    "type": "object",
    "properties": {
        "id": {
            "$ref": "#/definitions/content-id"
        },
        "type": {
            "$ref": "#/definitions/content-type"
        },
        "status": {
            "$ref": "#/definitions/content-status"
        },
        "title": {
            "type": "string"
        },
        "space": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/space"
            }
        },
        "history": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/history"
            }
        },
        "version": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/version"
            }
        },
        "ancestors": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/content"
            }
        },
        "operations": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/operation-check-result"
            }
        },
        "children": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "descendants": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "container": {
            "type": "array",
            "items": {
                "$ref": "#/definitions/container"
            }
        },
        "body": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "$ref": "#/definitions/content-body"
                }
            },
            "additionalProperties": false
        },
        "metadata": {
            "type": "object",
            "patternProperties": {
                ".+": {}
            },
            "additionalProperties": false
        },
        "extensions": {
            "type": "object",
            "patternProperties": {
                ".+": {}
            },
            "additionalProperties": false
        },
        "restrictions": {
            "type": "object",
            "patternProperties": {
                ".+": {
                    "$ref": "#/definitions/content-restriction"
                }
            },
            "additionalProperties": false
        }
    },
    "definitions": {
        "anonymous": {
            "title": "Anonymous",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "type": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "container": {
            "title": "Container",
            "type": "object"
        },
        "content": {
            "title": "Content",
            "type": "object",
            "properties": {
                "id": {
                    "$ref": "#/definitions/content-id"
                },
                "type": {
                    "$ref": "#/definitions/content-type"
                },
                "status": {
                    "$ref": "#/definitions/content-status"
                },
                "title": {
                    "type": "string"
                },
                "space": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/space"
                    }
                },
                "history": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/history"
                    }
                },
                "version": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "ancestors": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operations": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/operation-check-result"
                    }
                },
                "children": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "descendants": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/content"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "container": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/container"
                    }
                },
                "body": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/content-body"
                        }
                    },
                    "additionalProperties": false
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "extensions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                },
                "restrictions": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/content-restriction"
                        }
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "content-body": {
            "title": "Content Body",
            "type": "object",
            "properties": {
                "value": {
                    "type": "string"
                },
                "webresource": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/web-resource-dependencies"
                    }
                },
                "representation": {
                    "$ref": "#/definitions/content-representation"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false
        },
        "content-id": {
            "title": "Content Id",
            "type": "object"
        },
        "content-representation": {
            "title": "Content Representation",
            "type": "object"
        },
        "content-restriction": {
            "title": "Content Restriction",
            "type": "object",
            "properties": {
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "operation": {
                    "$ref": "#/definitions/operation-key"
                },
                "restrictions": {
                    "type": "array",
                    "items": {
                        "title": "Subject Restrictions",
                        "type": "object",
                        "properties": {
                            "user": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/user"
                                }
                            },
                            "group": {
                                "type": "array",
                                "items": {
                                    "title": "Group",
                                    "type": "object",
                                    "properties": {
                                        "name": {
                                            "type": "string"
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        },
        "content-status": {
            "title": "Content Status",
            "type": "object"
        },
        "content-type": {
            "title": "Content Type",
            "type": "object"
        },
        "history": {
            "title": "History",
            "type": "object",
            "properties": {
                "previousVersion": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "nextVersion": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "lastUpdated": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/version"
                    }
                },
                "latest": {
                    "type": "boolean"
                },
                "createdBy": {
                    "$ref": "#/definitions/person"
                },
                "createdDate": {
                    "type": "string"
                },
                "contributors": {
                    "type": "array",
                    "items": {
                        "title": "Contributors",
                        "type": "object",
                        "properties": {
                            "publishers": {
                                "type": "array",
                                "items": {
                                    "title": "Contributor Users",
                                    "type": "object",
                                    "properties": {
                                        "users": {
                                            "type": "array",
                                            "items": {
                                                "$ref": "#/definitions/person"
                                            }
                                        },
                                        "userKeys": {
                                            "type": "array",
                                            "items": {
                                                "type": "string"
                                            }
                                        }
                                    },
                                    "additionalProperties": false
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "latest"
            ]
        },
        "html-string": {
            "title": "Html String",
            "type": "object"
        },
        "icon": {
            "title": "Icon",
            "type": "object",
            "properties": {
                "path": {
                    "type": "string"
                },
                "width": {
                    "type": "integer"
                },
                "height": {
                    "type": "integer"
                },
                "isDefault": {
                    "type": "boolean"
                }
            },
            "additionalProperties": false,
            "required": [
                "width",
                "height",
                "isDefault"
            ]
        },
        "known-user": {
            "title": "Known User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                },
                "status": {
                    "type": "array",
                    "items": {
                        "title": "User Status",
                        "type": "object"
                    }
                }
            },
            "additionalProperties": false
        },
        "operation-check-result": {
            "title": "Operation Check Result",
            "type": "object",
            "properties": {
                "operation": {
                    "$ref": "#/definitions/operation-key"
                }
            },
            "additionalProperties": false
        },
        "operation-key": {
            "title": "Operation Key",
            "type": "object"
        },
        "person": {
            "title": "Person",
            "type": "object",
            "anyOf": [
                {
                    "$ref": "#/definitions/anonymous"
                },
                {
                    "$ref": "#/definitions/known-user"
                },
                {
                    "$ref": "#/definitions/unknown-user"
                },
                {
                    "$ref": "#/definitions/user"
                }
            ]
        },
        "space": {
            "title": "Space",
            "type": "object",
            "properties": {
                "id": {
                    "type": "integer"
                },
                "key": {
                    "type": "string"
                },
                "name": {
                    "type": "string"
                },
                "icon": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/icon"
                    }
                },
                "description": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "title": "Formatted Body",
                            "type": "object",
                            "properties": {
                                "value": {
                                    "type": "string"
                                },
                                "webresource": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/definitions/web-resource-dependencies"
                                    }
                                },
                                "representation": {
                                    "$ref": "#/definitions/content-representation"
                                }
                            },
                            "additionalProperties": false
                        }
                    },
                    "additionalProperties": false
                },
                "homepage": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                },
                "type": {
                    "title": "Space Type",
                    "type": "object"
                },
                "metadata": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {}
                    },
                    "additionalProperties": false
                }
            },
            "additionalProperties": false
        },
        "unknown-user": {
            "title": "Unknown User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "user": {
            "title": "User",
            "type": "object",
            "properties": {
                "profilePicture": {
                    "$ref": "#/definitions/icon"
                },
                "displayName": {
                    "type": "string"
                },
                "username": {
                    "type": "string"
                }
            },
            "additionalProperties": false
        },
        "version": {
            "title": "Version",
            "type": "object",
            "properties": {
                "by": {
                    "$ref": "#/definitions/person"
                },
                "when": {
                    "type": "string"
                },
                "message": {
                    "type": "string"
                },
                "number": {
                    "type": "integer"
                },
                "minorEdit": {
                    "type": "boolean"
                },
                "hidden": {
                    "type": "boolean"
                },
                "syncRev": {
                    "type": "string"
                },
                "content": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/content"
                    }
                }
            },
            "additionalProperties": false,
            "required": [
                "number",
                "minorEdit",
                "hidden"
            ]
        },
        "web-resource-dependencies": {
            "title": "Web Resource Dependencies",
            "type": "object",
            "properties": {
                "keys": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "contexts": {
                    "type": "array",
                    "items": {
                        "type": "string"
                    }
                },
                "uris": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "type": "array",
                            "items": {
                                "type": "string",
                                "format": "uri"
                            }
                        }
                    },
                    "additionalProperties": false
                },
                "tags": {
                    "type": "object",
                    "patternProperties": {
                        ".+": {
                            "$ref": "#/definitions/html-string"
                        }
                    },
                    "additionalProperties": false
                },
                "superbatch": {
                    "type": "array",
                    "items": {
                        "title": "Super Batch Web Resources",
                        "type": "object",
                        "properties": {
                            "uris": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "type": "array",
                                        "items": {
                                            "type": "string",
                                            "format": "uri"
                                        }
                                    }
                                },
                                "additionalProperties": false
                            },
                            "tags": {
                                "type": "object",
                                "patternProperties": {
                                    ".+": {
                                        "$ref": "#/definitions/html-string"
                                    }
                                },
                                "additionalProperties": false
                            },
                            "metatags": {
                                "type": "array",
                                "items": {
                                    "$ref": "#/definitions/html-string"
                                }
                            }
                        },
                        "additionalProperties": false
                    }
                }
            },
            "additionalProperties": false
        }
    },
    "additionalProperties": false
}
	 * </PRE></blockquote>
	 * <br>
	 * <h2><strong>Responses:</strong></h2>
	 * application/json
	 */
	@PUT("/wiki/rest/api/content/blueprint/instance/{draftId}")
	Call<Object> publishSharedDraftOfBlueprint(final @Path("draftId") String draftId,
	                                           final @Body Draft draftBody);
	//@formatter:on
	
	//----------- content/blueprint Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- contentbody/convert/{to} Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * Функция выполняет преобразования между различными представления тела контента (Converts between content body representation).
	 * <br>
	 * Не все виды представлений могут быть выполнены в/из другие форматы.
	 * <br>
	 * Поддерживаемые преобразования:
	 * <br>
	 * <table border="1">
	 *     <tr>
	 *         <th>Source Representation</th>
	 *         <th>Destination Representation Supported</th>
	 *     </tr>
	 *     <tr>
	 *         <td>storage</td>
	 *         <td>view, export_view, styled_view, editor</td>
	 *     </tr>
	 *     <tr>
	 *         <td>editor</td>
	 *         <td>storage</td>
	 *     </tr>
	 *     <tr>
	 *         <td>view</td>
	 *         <td>None</td>
	 *     </tr>
	 *     <tr>
	 *         <td>export_view</td>
	 *         <td>None</td>
	 *     </tr>
	 *     <tr>
	 *         <td>styled_view</td>
	 *         <td>None</td>
	 *     </tr>
	 * </table>
	 * <br>
	 *<br>
	 *<em>Пример запроса на удаление черновика:</em>
	 *<br>
	 *<strong>POST: http://example.com/rest/api/contentbody/convert/view</strong>
	 * <br>
	 * <h2><strong>Request:</strong></h2>
	 * Дополнительные параметры:
	 * <ul>
	 * <li>expand (String, default:<strong></strong>) - </li>
	 * </ul>
	 * <em>Тело запроса:</em>
	 * <blockquote>
	 * <PRE>
{
    "value": "&lt;p&gt;Some example body in storage format&lt;/p&gt;",
    "representation": "storage"
}
	 * </PRE>
	 * </blockquote>
	 * <h2><strong>Responses</strong></h2>
	 * <strong>STATUS 200</strong> --  application/json
	 * <p>
	 * <blockquote><PRE>
{
    "value": "&lt;p&gt;Some example body in storage format&lt;/p&gt;",
    "representation": "storage",
    "_links": {
        "base": "http://myhost:8080/confluence",
        "context": "/confluence"
    },
    "_expandable": {
        "content": "/rest/api/content/3604482"
    }
}
	 * </PRE></blockquote>
	 * @param contentBody передаваемое для контвертации тело запроса
	 * @param toFormat формат в который мы хотим конвертировать
	 * @return результат конвертации
	 */
	@POST("/wiki/rest/api/contentbody/convert/{to}")
	Call<ConvertationResponsBody> convert(final @Body ContentBody contentBody,
	                                      final @Path("to") String toFormat);
	//@formatter:on
	//----------- contentbody/convert/{to} Конец ---------------
	//----------------------------------------------------------------------------------------
	
}