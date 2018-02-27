package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.audit.AuditResultList;
import com.pampushko.confluence.models.content.Content;
import com.pampushko.confluence.models.content.ContentContainter;
import com.pampushko.confluence.models.content.ContentResultList;
import com.pampushko.confluence.models.group.Group;
import com.pampushko.confluence.models.group.GroupResultList;
import com.pampushko.confluence.models.history.HistoryContainer;
import com.pampushko.confluence.models.macros.Macros;
import com.pampushko.confluence.models.search.SearchResultList;
import com.pampushko.confluence.models.user.UserResultList;
import com.pampushko.confluence.models.user_watch.WatchObject;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс клиент для Atlassian Confluence
 * <br>
 */
@Slf4j
public class Confluence
{
	/**
	 * Имя пользователя
	 * <br>
	 */
	String username;
	/**
	 * Пароль
	 * <br>
	 */
	String password;
	/**
	 * базовый URL вашего инстанса Confluence
	 * <br>
	 */
	String baseUrl;
	
	private ConfluenceApi confluenceApi;
	
	private Confluence()
	{
	
	}
	
	public static Builder newBuilder()
	{
		return new Confluence().new Builder();
	}
	
	////////////////////////////////////////////////////////////////////////
	public class Builder
	{
		private Builder()
		{
		
		}
		
		public Builder username(String username)
		{
			Confluence.this.username = username;
			return this;
		}
		
		public Builder password(String password)
		{
			Confluence.this.password = password;
			return this;
		}
		
		public Builder baseUrl(String baseUrl)
		{
			Confluence.this.baseUrl = baseUrl;
			return this;
		}
		
		///////////////////////////////////////////////////
		
		/**
		 * настраиваем REST-адаптер, который будет использоваться с нашим Confluence REST API
		 * <br>
		 * И создаем реализацию API, которая соответствует описанию в интерфейсе {@link com.pampushko.confluence.rest.ConfluenceApi}
		 * <br>
		 *
		 * @return
		 */
		public Confluence build()
		{
			Retrofit retrofit = new RetrofitCreator().getRetrofitRestAdapter(Confluence.this);
			Confluence.this.confluenceApi = retrofit.create(ConfluenceApi.class);
			return Confluence.this;
		}
	}
	
	/**
	 * Возвращает информацию об области Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key}
	 * <br>
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br>
	 */
	public Space getSpaceByKey(final String spaceKey, final Map<String, String> params) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.getSpaceByKey(spaceKey, params);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
	/**
	 * Возвращает информацию об области Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key}
	 * <br>
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br>
	 */
	public Space getSpaceByKey(final String spaceKey) throws IOException
	{
		//заглушка
		Map<String, String> params = new HashMap<String, String>(){{}};
		
		Call<Space> spaceCall = confluenceApi.getSpaceByKey(spaceKey, params);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
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
	public SpaceResultList getSpaces() throws IOException
	{
		Call<SpaceResultList> spacesCall = confluenceApi.getSpaces();
		Response<SpaceResultList> response = spacesCall.execute();
		SpaceResultList body = response.body();
		return body;
	}
	
	/**
	 * Создаём новую область Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br>
	 *
	 * @param space - область {@code Space} для создания.
	 *              <br>
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно создана
	 * <br>
	 */
	public Space createSpace(final Space space) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.createSpace(space);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
	/**
	 * Создаём новую приватную (<strong>видимую только для создателя</strong>) область Confluence - {@code Space}
	 * <br>
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br>
	 * Но не ясно, чем этот способ создания отличается от обычного создания области,
	 * <br>
	 * т.к. область созданная обычным способом также доступна только для своего создателя
	 * <br>
	 * <strong>todo разобраться с назначением метода более подробно</strong>
	 * <br>
	 *
	 * @param space - область {@code Space} для создания.
	 *              <br>
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно создана
	 * <br>
	 */
	public Space createPrivateSpace(final Space space) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.createSpace(space);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
	/**
	 * Обновление области (в настоящий момент можно обновить только name, description и homepage)
	 * <br>
	 *
	 * @param space - область {@code Space} для создания
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос (полное представлеине области)
	 */
	public Space updateSpace(final Space space, final String key) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.updateSpace(space, key);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
	/**
	 * Удаляем область Confluence - {@code Space}
	 * <br>
	 * имеющую ключ {@code key}
	 * <br>
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 * <br>
	 */
	public NoContentResponse deleteSpace(final String key) throws IOException
	{
		Call<NoContentResponse> spaceCall = confluenceApi.deleteSpace(key);
		Response<NoContentResponse> response = spaceCall.execute();
		NoContentResponse body = response.body();
		return body;
	}
	
	/**
	 * Получить список элементов контента из данной области
	 * <br>
	 *
	 * @param key
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public ContentContainter getSpaceContent(final String key, final Map<String, String> params) throws IOException
	{
		Call<ContentContainter> spaceContentCall = confluenceApi.getSpaceContent(key, params);
		Response<ContentContainter> response = spaceContentCall.execute();
		ContentContainter body = response.body();
		return body;
	}
	
	/**
	 * Получить элемент контента по идентификатору этого элемента
	 * <br>
	 *
	 * @param contentId
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public PageResultItem getContentById(final String contentId, final Map<String, String> params) throws IOException
	{
		Call<PageResultItem> pageContentCall = confluenceApi.getContentById(contentId, params);
		Response<PageResultItem> response = pageContentCall.execute();
		PageResultItem body = response.body();
		return body;
	}
	
	/**
	 * Получить версию контента по заданному индентификатору контента и номеру версии
	 * <br>
	 *
	 * @param contentId
	 * @param versionNumber
	 * @param params
	 * @return
	 */
	Version getVersionOfContent(final String contentId, final int versionNumber, final Map<String, String> params) throws IOException
	{
		Call<Version> versionCall = confluenceApi.getVersionOfContent(contentId, versionNumber, params);
		Response<Version> response = versionCall.execute();
		Version body = response.body();
		return body;
	}
	
	
	/**
	 * Получить список групп (разбитый на страницы)
	 * <br>
	 *
	 * @param start
	 * @param limit
	 * @return
	 */
	GroupResultList getGetGroups(final int start, final int limit) throws IOException
	{
		Call<GroupResultList> groupResultListCall = confluenceApi.getGroups(start, limit);
		Response<GroupResultList> response = groupResultListCall.execute();
		GroupResultList body = response.body();
		return body;
	}
	
	/**
	 * Получить группу по имени
	 * <br>
	 *
	 * @return
	 */
	Group getGroupsByName(final String groupName) throws IOException
	{
		Call<Group> groupCall = confluenceApi.getGroupsByName(groupName);
		Response<Group> response = groupCall.execute();
		Group body = response.body();
		return body;
	}
	
	/**
	 * Получить список групп (разбитый на страницы)
	 *
	 * @param start
	 * @param limit
	 * @return
	 */
	GroupResultList getGetGroups(final String groupName, final int start, final int limit) throws IOException
	{
		Call<GroupResultList> groupResultListCall = confluenceApi.getGroups(start, limit);
		Response<GroupResultList> response = groupResultListCall.execute();
		GroupResultList body = response.body();
		return body;
	}
	
	
	/**
	 * Получить коллекцию пользователей состоящих в группе с заданным именем
	 * <br>
	 *
	 * @param groupName
	 * @param start
	 * @param limit
	 * @return
	 */
	UserResultList getUsersFromGroupByGroupName(String groupName, int start, int limit) throws IOException
	{
		Call<UserResultList> userResultListCall = confluenceApi.getUsersFromGroupByGroupName(groupName, start, limit);
		Response<UserResultList> response = userResultListCall.execute();
		UserResultList body = response.body();
		return body;
	}
	
	
	@lombok.Builder
	public static class SearchParams
	{
		/**
		 * the CQL query see advanced searching in confluence using CQL
		 */
		@lombok.Builder.Default
		String cql = "";
		
		/**
		 * the execution context for CQL functions, provides current space key and content id. If this is not provided some CQL functions will not be available.
		 */
		@lombok.Builder.Default
		String cqlcontext = "";
		
		/**
		 * the excerpt strategy to apply to the result, one of : indexed, highlight, none. This defaults to highlight.
		 */
		@lombok.Builder.Default
		String excerpt = "highlight";
		
		/**
		 * the properties to expand on the search result, this may cause database requests for some properties
		 */
		@lombok.Builder.Default
		String expand = "";
		
		/**
		 * the start point of the collection to return
		 */
		@lombok.Builder.Default
		int start = 0;
		
		/**
		 * the limit of the number of items to return, this may be restricted by fixed system limits
		 */
		@lombok.Builder.Default
		int limit = 25;
		
		/**
		 * whether to include content in archived spaces in the result, this defaults to false
		 */
		@lombok.Builder.Default
		boolean includeArchivedSpaces = false;
		
		//----------------------------------------------------------------------
		
	}
	
	//---------------------------------------------------------------------------
	
	/**
	 * Выполнить поиск элементов при помощи CQL SearchService
	 * <br>
	 *
	 * @return Returns a full JSON representation of a list of search results
	 * <br>
	 */
	SearchResultList search(final String cql) throws IOException
	{
		Call<SearchResultList> searchResultListCall = confluenceApi.search(cql, new HashMap<>());
		Response<SearchResultList> response = searchResultListCall.execute();
		SearchResultList body = response.body();
		return body;
	}
	
	/**
	 * Выполнить поиск элементов при помощи CQL SearchService
	 * <br>
	 *
	 * @return Returns a full JSON representation of a list of search results
	 * <br>
	 */
	SearchResultList search(final SearchParams params) throws IOException
	{
		Map<String, String> mapParams = new HashMap<String, String>()
		{
			{
				put("cql", params.cql);
				put("cqlcontext", params.cqlcontext);
				put("excerpt", params.excerpt);
				put("expand", params.expand);
				put("start", String.valueOf(params.start));
				put("limit", String.valueOf(params.limit));
				put("includeArchivedSpaces", String.valueOf(params.includeArchivedSpaces));
			}
		};
		Call<SearchResultList> searchResultListCall = confluenceApi.search(params.cql, mapParams);
		Response<SearchResultList> response = searchResultListCall.execute();
		SearchResultList body = response.body();
		return body;
	}
	//---------------------------------------------------------------------------
	
	/**
	 * Получить объект, содержащий информацию о том наблюдает ли пользователь
	 * <br>
	 * пославший запрос за контентом имеющим идентификатор contentId
	 * <br>
	 *
	 * @param contentId
	 * @return
	 * @throws IOException
	 */
	WatchObject watch(final String contentId) throws IOException
	{
		Call<WatchObject> watchObjectCall = confluenceApi.isWatch(contentId);
		Response<WatchObject> response = watchObjectCall.execute();
		WatchObject body = response.body();
		return body;
	}
	
	/**
	 * Получить объект, содержащий информацию о том наблюдает ли пользователь
	 * <br>
	 * имеющий указанный <strong>userkey</strong>
	 * <br>
	 * за контентом имеющим идентификатор contentId
	 * <br>
	 *
	 * @param userkey
	 * @return
	 * @throws IOException
	 */
	WatchObject watchByKey(final String contentId, final String userkey) throws IOException
	{
		Call<WatchObject> watchObjectCall = confluenceApi.isWatchByKey(contentId, userkey);
		Response<WatchObject> response = watchObjectCall.execute();
		WatchObject body = response.body();
		return body;
	}
	
	/**
	 * Получить объект, содержащий информацию о том наблюдает ли пользователь
	 * <br>
	 * имеющий указанный <strong>username</strong>
	 * <br>
	 * за контентом имеющим идентификатор contentId
	 * <br>
	 *
	 * @param contentId
	 * @return
	 * @throws IOException
	 */
	WatchObject watchByUsername(final String contentId, final String username) throws IOException
	{
		Call<WatchObject> watchObjectCall = confluenceApi.isWatchByUsername(contentId, username);
		Response<WatchObject> response = watchObjectCall.execute();
		WatchObject body = response.body();
		return body;
	}
	
	/**
	 * Параметры
	 * <ol>
	 * <li>status (string), Default: <strong>current</strong></li>
	 * <li>expand	(string), Default: body.storage,history,space,container.history,container.version,version,ancestors</li>
	 * </ol>
	 *
	 * @param content
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public Content createContent(final Content content, final Map<String, String> params) throws IOException
	{
		Call<Content> contentCall = confluenceApi.createContent(content, params);
		Response<Content> response = contentCall.execute();
		Content body = response.body();
		return body;
	}
	
	////////////////////////////////////////////////////
	// update content START
	////////////////////////////////////////////////////
	/**
	 * Параметры
	 * <ol>
	 * <li>status (string), Default: current</li>
	 * <li>expand	(string), Default: body.storage,history,space,container.history,container.version,version,ancestors</li>
	 * </ol>
	 *
	 * @param content
	 * @param params
	 * @return
	 * @throws IOException
	 */
	Content updateContent(final Content content,
	                      final String contentId,
	                      final Map<String, String> params) throws IOException
	{
		Call<Content> contentCall = confluenceApi.updateContent(content, contentId, params);
		Response<Content> response = contentCall.execute();
		Content body = response.body();
		return body;
	}
	
	/**
	 * Параметры
	 * <ol>
	 * <li>status (string), Default: current</li>
	 * <li>expand	(string), Default: body.storage,history,space,container.history,container.version,version,ancestors</li>
	 * </ol>
	 *
	 * @param content экземпляр конента, который мы хотим обновить
	 * @return обновленный экземпляр контента
	 * @throws IOException
	 */
	public Content updateContent(final Content content,
	                             final String contentId) throws IOException
	{
		Map<String, String> params = new HashMap<String, String>()
		{
			{
			
			}
		};
		Call<Content> contentCall = confluenceApi.updateContent(content, contentId, params);
		Response<Content> response = contentCall.execute();
		Content body = response.body();
		return body;
	}
	////////////////////////////////////////////////////
	// update content STOP
	////////////////////////////////////////////////////
	
	/**
	 * Удаляет контента имеющий указанный идентификатор
	 * <br>
	 *
	 * @param contentId идентификатор контента
	 * @return
	 */
	//готово
	boolean deleteContentById(final String contentId) throws IOException
	{
		Call<Response<Void>> responseCall = confluenceApi.deleteContentById(contentId);
		Response<Response<Void>> response = responseCall.execute();
		int code = response.code();
		if (code == 204) //успешно удалили контент
		{
			return true;
		}
		else
		{
			//не удалось выполнить запрос или найти контент по указанному contentId
			return false;
		}
	}
	
	/**
	 * Возвращает историю от выбранного элемента контента
	 * <br>
	 * Параметры:
	 * <ul>
	 *     <li>
	 *         expand (String), Default: previousVersion, nextVersion, lastUpdated
	 *     </li>
	 * </ul>
	 * @param contendId идентификатор контента
	 * @return коллекция истории контента
	 * @throws IOException
	 */
	//готово
	@GET("/wiki/rest/api/content/{contentId}/history")
	HistoryContainer getContentHistory(final String contendId) throws IOException
	{
		Call<HistoryContainer> contentContainterCall = confluenceApi.getContentHistory(contendId);
		Response<HistoryContainer> response = contentContainterCall.execute();
		HistoryContainer body = response.body();
		return body;
	}
	
	/**
	 * Получить тело макроса с заданным идентификатором макроса (macroId)
	 * <br>
	 * для заданного элемента контента (contentId)
	 * <br>
	 * Для указанной вами версии контента (version)
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента
	 * @param version версия элемента контента
	 * @param macroId идентификатор макроса
	 * @return макрос
	 * @throws IOException
	 */
	Macros getContentMacroBodyByMacroId(final String contentId,
	                                    final String version,
	                                    final String macroId) throws IOException
	{
		Call<Macros> contentContainterCall = confluenceApi.getContentMacroBodyByMacroId(contentId, version, macroId);
		Response<Macros> response = contentContainterCall.execute();
		Macros body = response.body();
		return body;
	}
	
	/**
	 * Получить тело макроса с заданным хешем (hash) макроса (вместо macroId, для совместимости)
	 * <br>
	 * для заданного элемента контента (contentId)
	 * <br>
	 * Для указанной вами версии контента (version)
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента
	 * @param version версия элемента контента
	 * @param hash хеш макроса
	 * @return макрос
	 * @throws IOException
	 */
	@Deprecated
	Macros getContentMacroBodyByHash(final String contentId,
	                                 final String version,
	                                 final String hash) throws IOException
	{
		Call<Macros> contentContainterCall = confluenceApi.getContentMacroBodyByHash(contentId, version, hash);
		Response<Macros> response = contentContainterCall.execute();
		Macros body = response.body();
		return body;
	}
	
	/**
	 * Returns a paginated list of Content.
	 * <br>
	 *
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public ContentResultList getContent(final Map<String, String> params) throws IOException
	{
		Call<ContentResultList> contentResultListCall = confluenceApi.getContent(params);
		Response<ContentResultList> response = contentResultListCall.execute();
		ContentResultList body = response.body();
		return body;
	}
	
	////////////////////////////////////////////////////
	// Audit - START
	////////////////////////////////////////////////////
	
	/**
	 * Fetch a paginated list of AuditRecord instances dating back to a certain time
	 * <br>
	 *
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public AuditResultList getAudit(final Map<String, String> params) throws IOException
	{
		Call<AuditResultList> auditResultListCall = confluenceApi.getAudit(params);
		Response<AuditResultList> response = auditResultListCall.execute();
		AuditResultList body = response.body();
		return body;
	}
	
	////////////////////////////////////////////////////
	// Audit - STOP
	////////////////////////////////////////////////////

}
