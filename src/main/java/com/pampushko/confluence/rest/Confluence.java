package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.audit.Audit;
import com.pampushko.confluence.models.audit.AuditResultList;
import com.pampushko.confluence.models.audit.RetentionPeriod;
import com.pampushko.confluence.models.child_content.ChildContentContainer;
import com.pampushko.confluence.models.enums.ContentType;
import com.pampushko.confluence.models.child_content.attachment.ChildAttachment;
import com.pampushko.confluence.models.child_content.comment.ChildComment;
import com.pampushko.confluence.models.child_content.page.ChildPage;
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
import com.pampushko.confluence.utils.FilesUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
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
		Map<String, String> params = new HashMap<String, String>()
		{{
		}};
		
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
	 * @param space
	 * 		- область {@code Space} для создания.
	 * 		<br>
	 *
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
	 * @param space
	 * 		- область {@code Space} для создания.
	 * 		<br>
	 *
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
	 * @param space
	 * 		- область {@code Space} для создания
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
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
	 *
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
	 *
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
	 *
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
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
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
	 * @param content
	 * 		экземпляр конента, который мы хотим обновить
	 *
	 * @return обновленный экземпляр контента
	 *
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
	 * @param contentId
	 * 		идентификатор контента
	 *
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
		} else
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
	 * <li>
	 * expand (String), Default: previousVersion, nextVersion, lastUpdated
	 * </li>
	 * </ul>
	 *
	 * @param contendId
	 * 		идентификатор контента
	 *
	 * @return коллекция истории контента
	 *
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
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param version
	 * 		версия элемента контента
	 * @param macroId
	 * 		идентификатор макроса
	 *
	 * @return макрос
	 *
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
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param version
	 * 		версия элемента контента
	 * @param hash
	 * 		хеш макроса
	 *
	 * @return макрос
	 *
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
	 *
	 * @return
	 *
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
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public AuditResultList getAudit(final Map<String, String> params) throws IOException
	{
		Call<AuditResultList> auditResultListCall = confluenceApi.getAudit(params);
		Response<AuditResultList> response = auditResultListCall.execute();
		AuditResultList body = response.body();
		return body;
	}
	
	/**
	 * Store record
	 * <br>
	 *
	 * @param audit
	 *
	 * @return
	 */
	public Audit createAudit(final Audit audit) throws IOException
	{
		Call<Audit> auditCall = confluenceApi.createAudit(audit);
		Response<Audit> response = auditCall.execute();
		Audit body = response.body();
		return body;
	}
	
	/**
	 * <br>
	 *
	 * @param params
	 *
	 * @return
	 */
	public void exportAudit(final String directoryName,
	                        final Map<String, String> params) throws IOException
	{
		String acceptHeader = "text/csv";
		Call<ResponseBody> exportAuditCall = confluenceApi.exportAudit(acceptHeader, params);
		
		exportAuditCall.enqueue(new Callback<ResponseBody>()
		{
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
			{
				if (response.isSuccessful())
				{
					log.debug("server contacted and has file");
					// получаем заголовок, содержащий в т.ч. имя файла для сохранения
					String contentDisposition = response.headers().get("Content-Disposition");
					//извлекаем имя файла из строки содержащейся в заголовке Content-Disposition
					String fileName = FilesUtils.getFileNameFromContentDispositionHeader(contentDisposition);
					//записываем содержимое тела ответа в директорию с именем directoryName, в файл fileName
					boolean writtenToDisk = FilesUtils.writeResponseBodyToDisk(response.body(), directoryName, fileName);
					
					
					log.debug("file download was a success? " + writtenToDisk);
				}
				else
				{
					log.debug("server contact failed");
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable)
			{
				log.error("error! filed to write file to disk!");
			}
		});
	}
	
	/**
	 * Получаем текущий период хранения (Fetches the current retention period)
	 * <p>
	 * <strong>Responses</strong>
	 * application/json
	 *
	 * @return
	 */
	public RetentionPeriod getRetentionPeriodOfAudit() throws IOException
	{
		Call<RetentionPeriod> retentionPeriodOfAuditCall = confluenceApi.getRetentionPeriodOfAudit();
		Response<RetentionPeriod> response = retentionPeriodOfAuditCall.execute();
		RetentionPeriod retentionPeriod = response.body();
		return retentionPeriod;
	}
	
	/**
	 * Устанавливаем текущий период хранения (Set the retention period to a new value.)
	 * <p>
	 * Can throw ServiceException if the retention period is too long (Retention period cannot be longer than 20 Years)
	 *
	 * @param newRetentionPeriod
	 *
	 * @return
	 */
	public RetentionPeriod setRetentionPeriodOfAudit(final RetentionPeriod newRetentionPeriod) throws IOException
	{
		Call<RetentionPeriod> retentionPeriodCall = confluenceApi.setRetentionPeriodOfAudit(newRetentionPeriod);
		Response<RetentionPeriod> response = retentionPeriodCall.execute();
		RetentionPeriod retentionPeriod = response.body();
		return retentionPeriod;
	}
	
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
	public AuditResultList getAuditSince(final Map<String, String> params) throws IOException
	{
		Call<AuditResultList> auditResultListCall = confluenceApi.getAuditSince(params);
		Response<AuditResultList> response = auditResultListCall.execute();
		AuditResultList body = response.body();
		return body;
	}
	
	////////////////////////////////////////////////////
	// Audit - STOP
	////////////////////////////////////////////////////
	
	
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
	public ChildContentContainer getChild(final String contentId,
	                                      final Map<String, String> params) throws IOException
	{
		Call<ChildContentContainer> childContentResultListCall = confluenceApi.getChild(contentId, params);
		Response<ChildContentContainer> response = childContentResultListCall.execute();
		ChildContentContainer body = response.body();
		return body;
	}
	
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
	ChildContentContainer getChildByType(final String contentId,
	                                     final ContentType type,
	                                     final Map<String, String> params) throws IOException
	{
		Call<ChildContentContainer> childContentResultListCall = confluenceApi.getChildByType(contentId, type.toString(), params);
		Response<ChildContentContainer> response = childContentResultListCall.execute();
		ChildContentContainer body = response.body();
		return body;
	}
	
	public ChildPage getChildPage(final String contentId,
	                              final Map<String, String> params) throws IOException
	{
		Call<ChildPage> childPageCall = confluenceApi.getChildPage(contentId, params);
		Response<ChildPage> response = childPageCall.execute();
		ChildPage body = response.body();
		return body;
	}
	
	public ChildComment getChildComment(final String contentId,
	                                    final Map<String, String> params) throws IOException
	{
		Call<ChildComment> childCommentCall = confluenceApi.getChildComment(contentId, params);
		Response<ChildComment> response = childCommentCall.execute();
		ChildComment body = response.body();
		return body;
	}
	
	public ChildAttachment getChildAttachment(final String contentId,
	                                final Map<String, String> params) throws IOException
	{
		Call<ChildAttachment> childAttachmentCall = confluenceApi.getChildAttachment(contentId, params);
		Response<ChildAttachment> response = childAttachmentCall.execute();
		ChildAttachment body = response.body();
		return body;
	}
	
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
//	ContentResultList getChildComment(final String contentId,
//	                                  final Map<String, String> params)
//	{
//		return null;
//	}
	
	
	//----------- content/{id}/child Конец ---------------
	//----------------------------------------------------------------------------------------
}
