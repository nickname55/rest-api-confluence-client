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
import com.pampushko.confluence.models.content_property.PropertyListResponseContainer;
import com.pampushko.confluence.models.content_property.PropertyResponse;
import com.pampushko.confluence.models.content_property.PropertyOfContent;
import com.pampushko.confluence.models.content_property.PropertyOfContentWithVersion;
import com.pampushko.confluence.models.content_restriction.RestrictionResponseContainer;
import com.pampushko.confluence.models.content_restriction.restriction.Restriction;
import com.pampushko.confluence.models.convert.resp.ConvertationResponsBody;
import com.pampushko.confluence.models.convert.req.ContentBody;
import com.pampushko.confluence.models.draft.Draft;
import com.pampushko.confluence.models.enums.ContentType;
import com.pampushko.confluence.models.group.Group;
import com.pampushko.confluence.models.group.GroupResultList;
import com.pampushko.confluence.models.history.HistoryContainer;
import com.pampushko.confluence.models.label.Label;
import com.pampushko.confluence.models.label.LabelResultList;
import com.pampushko.confluence.models.longtask.LongTask;
import com.pampushko.confluence.models.longtask.LongTaskListResultContainer;
import com.pampushko.confluence.models.macros.Macros;
import com.pampushko.confluence.models.search.SearchResultList;
import com.pampushko.confluence.models.user.User;
import com.pampushko.confluence.models.user.UserResultList;
import com.pampushko.confluence.models.user_watch.WatchObject;
import com.pampushko.confluence.utils.FilesUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
	String clientUserName;
	/**
	 * Пароль
	 * <br>
	 */
	String clientPassword;
	/**
	 * базовый URL вашего инстанса Confluence
	 * <br>
	 */
	String clientBaseUrl;
	
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
		
		public Builder userName(String confluenceUserName)
		{
			Confluence.this.clientUserName = confluenceUserName;
			return this;
		}
		
		public Builder password(String password)
		{
			Confluence.this.clientPassword = password;
			return this;
		}
		
		public Builder baseUrl(String baseUrl)
		{
			Confluence.this.clientBaseUrl = baseUrl;
			return this;
		}
		
		///////////////////////////////////////////////////
		
		/**
		 * настраиваем REST-адаптер, который будет использоваться с нашим Confluence REST API
		 * <br>
		 * И создаем реализацию API, которая соответствует описанию в интерфейсе {@link com.pampushko.confluence.rest.ConfluenceApi}
		 * <br>
		 *
		 * @return клиент для взаимодействия с Confluence
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
	 * @param spaceKey
	 * 		ключ области
	 * @param params
	 * 		дополнительные параметры
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 *
	 * @throws IOException
	 * 		ошибки сети
	 * 		<br>
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
	 * @param spaceKey
	 * 		ключ области
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br>
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public Space getSpaceByKey(final String spaceKey) throws IOException
	{
		//заглушка
		Map<String, String> params = new HashMap<>();
		
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
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		область {@code Space} для создания.
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно создана
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		область {@code Space} для создания
	 *
	 * @return - {@code Space} подтверждение, возвращаемое Confluence в ответе на запрос (полное представлеине области)
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * @param key
	 * 		ключ области
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * @param spaceKey
	 * 		ключ области
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект-контейнер, содержащий список элементов контента
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public ContentContainter getSpaceContent(final String spaceKey, final Map<String, String> params) throws IOException
	{
		Call<ContentContainter> spaceContentCall = confluenceApi.getSpaceContent(spaceKey, params);
		Response<ContentContainter> response = spaceContentCall.execute();
		ContentContainter body = response.body();
		return body;
	}
	
	/**
	 * Получить элемент контента по идентификатору этого элемента
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор контента
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект содержащий данные указанного элемента контента
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		идентификатор элемента контента
	 * @param versionNumber
	 * 		номер версии элемента контента, которую мы хотим получить
	 * @param params
	 * 		дополнительные параметры
	 *
	 * @return объект содержащий данные указанной нами версии элемента контента
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		индекс с которого мы начинаем получать элементы
	 * @param limit
	 * 		максимальное количество элементов в получаемом списке
	 *
	 * @return объект контейнер, содержащий список групп
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	GroupResultList getGroups(final int start, final int limit) throws IOException
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
	 * @param groupName
	 * 		имя группы
	 *
	 * @return объект, содержащий данные группы
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		индекс, с которого мы начинаем получать элементы
	 * @param limit
	 * 		количество элементов, которое мы хотим получить
	 *
	 * @return объект-контейнер, содержащий список групп
	 */
	GroupResultList getGroups(final String groupName, final int start, final int limit) throws IOException
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
	 * 		имя группы
	 * @param start
	 * 		индекс, начиная с корого мы хотим получать элементы
	 * @param limit
	 * 		максимальное количество элементов, которые мы хотим получить в ответе
	 *
	 * @return объект-контейнер, содержащий список объект представляющих пользователей
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		идентификатор контента
	 *
	 * @return объект, содержащий свойство с информацией является ли пользователь наблюдателем (true - является)
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * @param userKey
	 * 		ключ идентифицирующий пользователя
	 *
	 * @return объект, содержащий свойство, указывающее на то является ли пользователь наблюдателем (true = является)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	WatchObject watchByKey(final String contentId, final String userKey) throws IOException
	{
		Call<WatchObject> watchObjectCall = confluenceApi.isWatchByKey(contentId, userKey);
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
	 * 		идентификатор контента
	 * @param userName
	 * 		имя пользователя
	 *
	 * @return объект, содержащий свойство, показывающее, является ли пользователь наблюдателем (true = является)
	 *
	 * @throws IOException
	 * 		ошибка сети
	 */
	WatchObject watchByUserName(final String contentId, final String userName) throws IOException
	{
		Call<WatchObject> watchObjectCall = confluenceApi.isWatchByUsername(contentId, userName);
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
	 * 		объект содержащий данные для создания элемента контента в Confluence
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект содержащий данные уже созданного элемента контента в Confluence
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		объект содержащий данные для создания элемента контента в Confluence
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект содержащий данные уже созданного элемента контента в Confluence
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		ошибки сети
	 */
	public Content updateContent(final Content content,
	                             final String contentId) throws IOException
	{
		Map<String, String> params = new HashMap<String, String>();
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
	 * @return булево значение, указывающее на то что контент удален (true = удален, false - нет)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	boolean deleteContentById(final String contentId) throws IOException
	{
		Call<Void> responseCall = confluenceApi.deleteContentById(contentId);
		Response<Void> response = responseCall.execute();
		int code = response.code();
		//успешно удалили контент или не удалось выполнить запрос или найти контент по указанному contentId
		return Utils.codeIs204(code);
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
	 * 		ошибки сети
	 */
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
	 * 		ошибки сети
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
	 * 		ошибки сети
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
	 * 		коллекция дополнительных параметров
	 *
	 * @return объект-контейнер, содержащий коллекцию элементов контента
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		коллекция дополнительных параметров передаваемых в запросе
	 *
	 * @return объект-контейнер содержащий список объектов-представлений для записей аудита
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * 		объект с данными записи аудита
	 *
	 * @return объект с данными созданной записи аудита
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
	 * 		дополнительные параметры
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
	 * <br>
	 * <strong>Responses</strong>
	 * application/json
	 *
	 * @return объект содержащий данные о retention period
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * <br>
	 * Can throw ServiceException if the retention period is too long (Retention period cannot be longer than 20 Years)
	 *
	 * @param newRetentionPeriod
	 *
	 * @return объект содержащий информацию о retention perion
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * <br>
	 * <strong>Responses</strong>
	 * application/json
	 *
	 * @param params
	 * 		список дополнительных параметров запроса
	 *
	 * @return объект-контейнер, содержащий список записей аудита
	 *
	 * @throws IOException
	 * 		ошибки сети
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
	 * <br>
	 * Контент может иметь несколько типов дочерних элементов,
	 * <br>
	 * которые могут также являться страницами, но кроме того это могут быть комментарии
	 * <br>
	 * и вложения.
	 * <br>
	 * ContentType дочерних элементов, которые будут возвращены запросом,
	 * <br>
	 * описывается в query параметре запроса - expand
	 * <br>
	 * Этот параметр может включать развёртывание множества дочерних типов.
	 * <br>
	 * Если в параметр expand не включены никакие типы,
	 * <br>
	 * возвращаемая map будет просто перечислять дочерние типы,
	 * <br>
	 * доступные для развёртывания для элемента контента Content,
	 * <br>
	 * на который (элемент контента) указывает параметр @Path - contentId.
	 * <br>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child</li>
	 *     <li>http://example.com/rest/api/content/1234/child?expand=page.body.VIEW</li>
	 *     <li>http://example.com/rest/api/content/1234/child?expand=page&amp;start=20&amp;limit=10</li>
	 * </ul>
	 * <br>
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
	 * <br>
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
	 * <br>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 * или если пользователь выполняющий запрос, не имеет разрешения на просмотр содержимого.
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры запроса
	 * @return набор дочерних элементо
	 * @throws IOException ошибки сети
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
	 * <br>
	 * Отобранные дочерние элементы будут ограничены одним типом.
	 * <br>
	 * Тип контента (или типы) - ContentType - возвращаемых дочерних элементов,
	 * <br>
	 * задаётся параметром "type" заданным в пути (path) запроса.
	 * <br>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/page</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/page?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&amp;limit=10</li>
	 * </ul>
	 *
	 * <br>
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
	 * <br>
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
	 * <br>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 *
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param type тип дочерних элементов (мы отберем дочерние элементы для элемента контента и отфильтруем по нужному нам типу, элементов других типов в ответе не будет)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 * @throws IOException ошибки сети
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
	
	/**
	 * todo добавить документацию к методу
	 *
	 * @param contentId
	 * 		идентификатор контента
	 * @param params
	 * 		дополнительные парамеры запроса
	 *
	 * @return объект представляющий дочернюю страницу
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public ChildPage getChildPage(final String contentId,
	                              final Map<String, String> params) throws IOException
	{
		Call<ChildPage> childPageCall = confluenceApi.getChildPage(contentId, params);
		Response<ChildPage> response = childPageCall.execute();
		ChildPage body = response.body();
		return body;
	}
	
	/**
	 * todo добавить документацию к методу
	 *
	 * @param contentId
	 * 		идентификатор контента
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект представляющий собой дочернее вложение
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
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
	 * <br>
	 * <strong>Примеры URI запросов:</strong>
	 * <ul>
	 *     <li>http://example.com/rest/api/content/1234/child/comment</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?expand=body.view</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?start=20&limit=10</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?location=footer&amp;location=inline&amp;location=resolved</li>
	 *     <li>http://example.com/rest/api/content/1234/child/comment?expand=extensions.inlineProperties,extensions.resolution</li>
	 * </ul>
	 * <br>
	 * <br>
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
	 * <br>
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
	 * <br>
	 * <strong>STATUS 404</strong> -- такой статус вы получите, если не существует элемента контента
	 * с указанным вами идентификатором
	 * <br>
	 * @param contentId идентификатор элемента контента (для этого элемента контента мы получаем дочерние элементы)
	 * @param params дополнительные параметры
	 * @return набор дочерних элементов
	 * @throws IOException ошибки сети
	 */
	//@formatter:on
	public ChildComment getChildComment(final String contentId,
	                                    final Map<String, String> params) throws IOException
	{
		Call<ChildComment> childCommentCall = confluenceApi.getChildComment(contentId, params);
		Response<ChildComment> response = childCommentCall.execute();
		ChildComment body = response.body();
		return body;
	}
	
	//----------- content/{id}/child Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/{id}/child/attachment Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * При помощи этой функции мы можем у заданного элемента контента создать вложение.
	 * <br>
	 * <strong>
	 * Для того чтобы получить более подробные данные о данной функции Confluence API смотрите документацию {@link ConfluenceApi#createAttachment(String, MultipartBody.Part, String, Map)} (String, String, UpdAttRequest, Map)}
	 * </strong>	 *
	 *
	 * @param parentContentId
	 * 		идентификатор страницы к которой мы добавляем вложение
	 * @param fileBodyAndFileName
	 * 		обернутые в специальный объект тело файла и имя файла - для создания вложения
	 * @param comment
	 * 		комментарий (или, возможно, набор комментариев <strong>в том же количестве и том же порядке, что и вложения</strong>), которые мы добавляем к нашим вложениям
	 * @param params
	 * 		другие параметры, передаваемые в запросе
	 *
	 * @return todo дописать
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public CreateAttResponseContainer createAttachment(final String parentContentId,
	                                                   final MultipartBody.Part fileBodyAndFileName,
	                                                   final String comment,
	                                                   final Map<String, String> params) throws IOException
	{
		Call<CreateAttResponseContainer> call = confluenceApi.createAttachment(parentContentId, fileBodyAndFileName, comment, params);
		Response<CreateAttResponseContainer> response = call.execute();
		CreateAttResponseContainer body = response.body();
		return body;
	}
	
	/**
	 * При помощи этой фунции мы можем обновить различные сопровождающие вложение данные:
	 * <ul>
	 * <li>имени файла-вложения</li>
	 * <li>media-type</li>
	 * <li>комментария</li>
	 * <li>родительского контейнера вложения</li>
	 * </ul>
	 * <strong>
	 * Само вложение мы обновить не можем!
	 * <br>
	 * Если вы хотите обновить тело файла-вложения, то следует использовать метод {@link #updateAttachmentFileBody(String, String, MultipartBody.Part, String, Map)}
	 * </strong>
	 * <br>
	 * <br>
	 * <br>
	 * <strong>
	 * Для того чтобы получить более подробные данные о данной функции Confluence API смотрите документацию {@link ConfluenceApi#updateAttachment(String, String, UpdAttRequest, Map)}
	 * </strong>
	 *
	 * @param parentContentId
	 * 		идентификатор страницы к которой мы добавляем вложение
	 * @param attachmentId
	 * 		идентификатор вложения, над этим вложением мы хотим выполнить действие
	 * @param requestBody
	 * 		тело запроса, содержит JSON с некоторыми обязательными полями с обновляемыми данными вложения
	 * @param params
	 * 		другие параметры, передаваемые в запросе
	 *
	 * @return JSON объект
	 *
	 * @throws IOException
	 */
	public UpdAttResponse updateAttachment(final String parentContentId,
	                                       final String attachmentId,
	                                       final UpdAttRequest requestBody,
	                                       final Map<String, String> params) throws IOException
	{
		Call<UpdAttResponse> call = confluenceApi.updateAttachment(parentContentId, attachmentId, requestBody, params);
		Response<UpdAttResponse> response = call.execute();
		UpdAttResponse responseBody = response.body();
		return responseBody;
	}
	
	/**
	 * При помощи этой функции мы можем обновить (загрузить <strong>новую</strong> версию вложения).
	 * <br>
	 * <br>
	 * <strong>
	 * Для того чтобы получить более подробные данные о данной функции Confluence API смотрите документацию {@link ConfluenceApi#updateAttachmentFileBody(String, String, MultipartBody.Part, String, Map)} (String, String, UpdAttRequest, Map)}
	 * </strong>
	 * <br>
	 *
	 * @param parentContentId
	 * 		идентификатор страницы к которой мы добавляем вложение
	 * @param attachmentId
	 * 		идентфикатор вложения, над этим вложением мы хотим выполнить действие
	 * @param fileBody
	 * 		тело файла обернутое в {@link okhttp3.MultipartBody.Part}
	 * @param comment
	 * 		комментарий к новой версии файла-вложения
	 * @param params
	 * 		дополнительные параметры, передаваемые в запросе
	 *
	 * @return объект с данныи обновленного вложения
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public UpdAttResponse updateAttachmentFileBody(final String parentContentId,
	                                               final String attachmentId,
	                                               final MultipartBody.Part fileBody,
	                                               final String comment,
	                                               final Map<String, String> params) throws IOException
	{
		Call<UpdAttResponse> updAttResponseCall = confluenceApi.updateAttachmentFileBody(parentContentId, attachmentId, fileBody, comment, params);
		Response<UpdAttResponse> response = updAttResponseCall.execute();
		UpdAttResponse responseBody = response.body();
		return responseBody;
	}
	
	//----------- content/{id}/child/attachment Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/{id}/descendant Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Получить дочерние элементы для заданного элемента контента
	 * <br>
	 *
	 * @param parentContentId
	 * 		идентификатор родительского элемента контента
	 * @param expand
	 * 		дополнительные свойства, которые мы хотим "развернуть" в ответе на запрос
	 *
	 * @return todo дописать
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public DescendantsResult getContentDescendants(final String parentContentId,
	                                               final String expand) throws IOException
	{
		Call<DescendantsResult> contentDescendantCall = confluenceApi.getContentDescendants(parentContentId, expand);
		Response<DescendantsResult> response = contentDescendantCall.execute();
		DescendantsResult body = response.body();
		return body;
	}
	
	/**
	 * Получить дочерние элементы (отобранные по типу)
	 * <br>
	 *
	 * @param parentContentId
	 * 		идентификатор контента для которого мы хотим получить дочерние элементы
	 * @param type
	 * 		тип дочерних элементов, которые нас интересуют
	 * @param expand
	 * 		дополнительные свойства дочерних элементов, которые мы хотим видеть "развёрнутыми" в ответе
	 * @param params
	 * 		дополнительные параметры
	 *
	 * @return объект-контейнер содержащий список элементов контента
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public ContentResultList getContentDescendantsByType(final String parentContentId,
	                                                     final String type,
	                                                     final String expand,
	                                                     final Map<String, String> params) throws IOException
	{
		Call<ContentResultList> contentDescendantCall = confluenceApi.getContentDescendantsByType(parentContentId, type, expand, params);
		Response<ContentResultList> response = contentDescendantCall.execute();
		ContentResultList body = response.body();
		return body;
	}
	//----------- content/{id}/descendant Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/{id}/label Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * @param contentId
	 * 		идентификатор контента
	 *
	 * @return объект-контейнер, содержащий список меток
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public LabelResultList getLabels(final @Path("contentId") String contentId) throws IOException
	{
		Call<LabelResultList> labelsCall = confluenceApi.getLabels(contentId);
		Response<LabelResultList> response = labelsCall.execute();
		LabelResultList labelResultList = response.body();
		return labelResultList;
	}
	
	/**
	 * Добавляет метку к заданному контенту
	 * <br>
	 * Если метка уже присутствует, то ничего не происходит, но она возращается в списке добавленных.
	 * <br>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param labels
	 * 		список меток, которые мы хотим добавить к элементу контента
	 *
	 * @return объект-контейнер, содержащий список меток
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public LabelResultList addLabels(final String contentId,
	                                 final List<Label> labels) throws IOException
	{
		Call<LabelResultList> responseCall = confluenceApi.addLabels(contentId, labels);
		Response<LabelResultList> response = responseCall.execute();
		LabelResultList body = response.body();
		return body;
	}
	
	/**
	 * удаляем метку
	 *
	 * @param contentId
	 * 		идентификатор контента, для которого мы хотим удалить метку
	 * @param labelName
	 * 		имя метки, которую мы хотим удалить
	 *
	 * @return todo дописать/проверить
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public Object deleteLabels(final String contentId,
	                           final String labelName) throws IOException
	{
		Call<Object> responseCall = confluenceApi.deleteLabels(contentId, labelName);
		Response<Object> objectResponse = responseCall.execute();
		Object body = objectResponse.body();
		return body;
	}
	
	//----------- content/{id}/label Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/{id}/property Начало ---------------
	//----------------------------------------------------------------------------------------
	
	//@formatter:off
	/**
	 * Функция возвращает свойства для указанного элемента контента
	 * <br>
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
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public PropertyListResponseContainer getContentProperties(final String contentId) throws IOException
	{
		Call<PropertyListResponseContainer> contentPropertiesCall = confluenceApi.getContentProperties(contentId);
		Response<PropertyListResponseContainer> response = contentPropertiesCall.execute();
		PropertyListResponseContainer body = response.body();
		return body;
	}
	
	//@formatter:off
	/**
	 * Функция возвращает свойства для указанного элемента контента
	 * <br>
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
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public PropertyResponse findByKeyContentProperties(final String contentId, final String propKey) throws IOException
	{
		Call<PropertyResponse> findContentPropertiesCall = confluenceApi.findByKeyContentProperties(contentId, propKey);
		Response<PropertyResponse> response = findContentPropertiesCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
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
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public PropertyResponse updateContentProperties(final String contentId,
	                                                final String propKey,
	                                                final PropertyOfContentWithVersion propertyOfContentWithVersion) throws IOException
	{
		Call<PropertyResponse> call = confluenceApi.updateContentProperties(contentId, propKey, propertyOfContentWithVersion);
		Response<PropertyResponse> response = call.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
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
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public boolean deleteContentProperties(final String contentId, final String propKey) throws IOException
	{
		Call<Void> deleteContentPropertiesCall = confluenceApi.deleteContentProperties(contentId, propKey);
		Response<Void> response = deleteContentPropertiesCall.execute();
		int code = response.code();
		//успешно удалили контент или не удалось выполнить запрос или найти контент по указанному contentId
		return Utils.codeIs204(code);
	}
	
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
	 * <strong>STATUS 413</strong> -- возвращается, если значение имеет слишком большую длину
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @param propKey ключ, принадлежащий свойству (property) элемента контента
	 * @return todo описать возвращаемое значение
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public PropertyResponse createContentPropertiesWithKey(final String contentId,
	                                                       final String propKey,
	                                                       final PropertyOfContent propertyOfContent) throws IOException
	{
		Call<PropertyResponse> contentPropertiesCall = confluenceApi.createContentPropertiesWithKey(contentId, propKey, propertyOfContent);
		Response<PropertyResponse> response = contentPropertiesCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
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
	 * <strong>STATUS 409</strong> -- возвращается, если свойство с таким ключом уже существует.
	 * <br>
	 * <strong>STATUS 413</strong> -- возвращается, если значение имеет слишком большую длину
	 * <br>
	 * @param contentId идентификатор элемента контента, к этому элементу контента мы добавляем новые свойства (properties)
	 * @return todo описать возвращаемое значение
	 * @throws IOException ошибка сети
	 */
	//@formatter:on
	public PropertyResponse createContentProperties(final String contentId,
	                                                final PropertyOfContent propertyOfContent) throws IOException
	{
		Call<PropertyResponse> contentPropertiesCall = confluenceApi.createContentProperties(contentId, propertyOfContent);
		Response<PropertyResponse> response = contentPropertiesCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
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
	 * </ul>
	 * <strong>Responses:</strong>
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
	 * @param contentId идентификатор контента
	 * @return объект содержащий информацию об ограничениях
	 * @throws IOException ошибка сети
	 */
	public RestrictionResponseContainer getContentRestrictionByOperation(final String contentId) throws IOException
	{
		Call<RestrictionResponseContainer> contentRestrictionByOperationCall = confluenceApi.getContentRestrictionByOperation(contentId);
		Response<RestrictionResponseContainer> response = contentRestrictionByOperationCall.execute();
		RestrictionResponseContainer body = response.body();
		return body;
	}
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
	 * </ul>
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
	 * @param contendId идентификатор контента
	 * @param operationKey ключ операции
	 * @return объект содержащий информацию об ограничении для данной операции
	 * @throws IOException ошибки сети
	 */
	public Restriction getContentRestrictionForOperation(final String contendId,
	                                                     final String operationKey)throws IOException
	{
		Call<Restriction> contentRestrictionForOperationCall = confluenceApi.getContentRestrictionForOperation(contendId, operationKey);
		Response<Restriction> response = contentRestrictionForOperationCall.execute();
		Restriction body = response.body();
		return body;
	}
	//@formatter:on
	
	//----------- content/{id}/restriction Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- content/blueprint Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Publish legacy draft
	 * <br>
	 *
	 * @param draftId
	 * 		идентификатор черновика
	 * @param draftBody
	 * 		объект с данными тела черновика
	 *
	 * @return todo проверить и дописать
	 *
	 * @throws IOException
	 * 		ошибка сети
	 */
	public Object publishLegacyDraftOfBlueprint(final String draftId, final Draft draftBody) throws IOException
	{
		Call<Object> publishCall = confluenceApi.publishLegacyDraftOfBlueprint(draftId, draftBody);
		Response<Object> response = publishCall.execute();
		Object body = response.body();
		return body;
	}
	
	/**
	 * Publish shared draft
	 * <br>
	 *
	 * @param draftId
	 * 		идентификатор черновика
	 * @param draftBody
	 * 		объект с данными тела черновика
	 *
	 * @return проверить и дописать
	 *
	 * @throws IOException
	 * 		ошибка сети
	 */
	public Object publishSharedDraftOfBlueprint(final String draftId, final Draft draftBody) throws IOException
	{
		Call<Object> publishCall = confluenceApi.publishSharedDraftOfBlueprint(draftId, draftBody);
		Response<Object> response = publishCall.execute();
		Object body = response.body();
		return body;
	}
	
	//----------- content/blueprint Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- contentbody/convert/{to} Начало ---------------
	//----------------------------------------------------------------------------------------
	
	public ConvertationResponsBody convert(final ContentBody contentBody,
	                                       final String toFormat) throws IOException
	{
		Call<ConvertationResponsBody> conversationCall = confluenceApi.convert(contentBody, toFormat);
		Response<ConvertationResponsBody> response = conversationCall.execute();
		ConvertationResponsBody body = response.body();
		return body;
	}
	
	//----------- contentbody/convert/{to} Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//начало, Add content watcher
	
	/**
	 * Добавить пользователя, выполняющего запрос, в наблюдатели контента (контент определяется по contentId)
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#addWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean addCurrentUserToWatchers(final String contentId) throws IOException
	{
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<>();
		return addUserToWatchers(contentId, params);
	}
	//@formatter:on
	
	/**
	 * Добавить пользователя в наблюдатели контента. Пользователя найти по username.
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#addWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param username
	 * 		имя пользователя (login)
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean addWatcherByUserName(final String contentId, final String username) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserName(username);
		return addUserToWatchers(contentId, params);
	}
	
	/**
	 * Добавить пользователя в наблюдатели контента. Пользователя найти по userKey.
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#addWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param userKey
	 * 		ключ пользователя
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean addWatcherByUserKey(final String contentId, final String userKey) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserKey(userKey);
		return addUserToWatchers(contentId, params);
	}
	
	/**
	 * Добавляет пользователя к наблюдателям данного контента (по contentId)
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#addWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param params
	 * 		отображаение на основе которого генерируют параметры запроса
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	private boolean addUserToWatchers(final String contentId, Map<String, String> params) throws IOException
	{
		Call<Void> addWatcherCall = confluenceApi.addWatcher(contentId, params);
		Response<Void> response = addWatcherCall.execute();
		int code = response.code();
		//успешно добавили наблюдателя или не удалось добавить наблюдателя в список
		return Utils.codeIs204(code);
	}
	
	//конец, Add content watcher
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//начало, Remove content watcher
	
	/**
	 * Удалить пользователя, выполняющего запрос, из наблюдателей контента (контент определяется по contentId)
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#removeWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean removeCurrentUserFromWatchers(final String contentId) throws IOException
	{
		//пустой набор параметров - заглушка
		Map<String, String> params = new HashMap<>();
		
		return removeUserFromWatchers(contentId, params);
	}
	//@formatter:on
	
	/**
	 * Удалить пользователя из наблюдателей контента. Пользователя найти по username.
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#removeWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param userName
	 * 		имя пользователя (login)
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean removeWatcherByUserName(final String contentId, final String userName) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserName(userName);
		return removeUserFromWatchers(contentId, params);
	}
	
	/**
	 * Удалить пользователя из списка наблюдателей контента. Пользователя найти по userKey.
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#removeWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param userKey
	 * 		ключ пользователя
	 *
	 * @return если операция выполнена успешно то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	public boolean removeWatcherByUserKey(final String contentId, final String userKey) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserKey(userKey);
		return removeUserFromWatchers(contentId, params);
	}
	
	/**
	 * Удаляет пользователя из списка наблюдателей данного элемента контента (по contentId)
	 * <br>
	 * <strong>Более подробную документацию можно прочесть в методе : {@link ConfluenceApi#removeWatcher(String, Map)}</strong>
	 *
	 * @param contentId
	 * 		идентификатор элемента контента
	 * @param params
	 * 		отображение на основе которого генерируют параметры запроса
	 *
	 * @return если операция выполнена успешно - то true, в противном случае - false
	 *
	 * @throws IOException
	 * 		ошибки соединения по HTTP
	 */
	private boolean removeUserFromWatchers(final String contentId, Map<String, String> params) throws IOException
	{
		Call<Void> removeWatcherCall = confluenceApi.removeWatcher(contentId, params);
		Response<Void> response = removeWatcherCall.execute();
		int code = response.code();
		//успешно удалили наблюдателя или это сделать не удалось
		return Utils.codeIs204(code);
	}
	
	//конец, Remove content watcher
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//начало, Add space watcher
	
	/**
	 * Добавить пользователя к списку наблюдателей области
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param params
	 * 		дополнительные параметры
	 *
	 * @return булево значение указывающее на то добавлен ли наблюдатель (true - добавлен, false - не добавлен)
	 *
	 * @throws IOException
	 * 		ошибка соединения по HTTP
	 */
	private boolean addWatcherToSpace(final String spaceKey,
	                                  final Map<String, String> params) throws IOException
	{
		
		Call<Void> addWatcherCall = confluenceApi.addWatcherToSpace(spaceKey, params);
		Response<Void> response = addWatcherCall.execute();
		int code = response.code();
		//успешно добавили пользователя в список наблюдателей области или этого сделать не удалось
		return Utils.codeIs204(code);
	}
	
	/**
	 * Добавить пользователя в список наблюдателей области.
	 * <br>
	 * <strong>При это указать пользователя по userKey</strong>
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param watcherUserKey
	 * 		ключ идентифицирующий пользователя
	 *
	 * @return булево значение (true - успешно удалось добавить, false - добавить не удалось)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean addWatcherToSpaceByUserKey(final String spaceKey,
	                                          final String watcherUserKey) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserKey(watcherUserKey);
		return addWatcherToSpace(spaceKey, params);
	}
	
	/**
	 * Добавить пользователя к список наблюдатей области.
	 * <br>
	 * <strong>При этом указать пользователя по userName.</strong>
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param watcherUserName
	 * 		имя пользователя, которого мы хотим добавить в список наблюдателей
	 *
	 * @return булево значение (true - успешно добавили в список наблюдателей)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean addWatcherToSpaceByUserName(final String spaceKey,
	                                           final String watcherUserName) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserName(watcherUserName);
		return addWatcherToSpace(spaceKey, params);
	}
	
	/**
	 * Добавить текущего (отправляющего запрос) пользователя в список наблюдателей области.
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 *
	 * @return булево значение (true - успешно добавили пользователя)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean addCurrentUserToWatchersOfSpace(final String spaceKey) throws IOException
	{
		//объект-заглушка без параметров
		Map<String, String> params = new HashMap<>();
		
		return addWatcherToSpace(spaceKey, params);
	}
	
	//конец, Add space watcher
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//начало, Remove space watcher
	
	/**
	 * Удалить пользователя из списка наблюдателей области
	 * <br>
	 * Пользователя следует указать при помощи ключей key или username в отображении params
	 * <br>
	 * или можно не указывать, тогда будет взят текущий (отправляющий запрос) пользователь
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param params
	 * 		отображаение с дополнительными параметрами
	 *
	 * @return булево значение (true - операция по удалению прошла успешно)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	private boolean removeWatcherFromSpace(final String spaceKey, final Map<String, String> params) throws IOException
	{
		Call<Void> removeWatcherCall = confluenceApi.removeWatcherFromSpace(spaceKey, params);
		Response<Void> response = removeWatcherCall.execute();
		int code = response.code();
		return Utils.codeIs204(code);
	}
	
	/**
	 * Удалить пользователя (указанного по userKey) из списка наблюдателей области
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param userKey
	 * 		ключ пользователя
	 *
	 * @return булево значение (true - успешно удалили наблюдателя)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean removeWatcherFromSpaceByUserKey(final String spaceKey, final String userKey) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserKey(userKey);
		return removeWatcherFromSpace(spaceKey, params);
	}
	
	/**
	 * Удалить пользователя (указанного по userName) из списка наблюдателей области
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param userName
	 * 		имя пользователя (login)
	 *
	 * @return булево значение (true - успешно удалили наблюдателя)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean removeWatcherFromSpaceByUserName(final String spaceKey, final String userName) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserName(userName);
		return removeWatcherFromSpace(spaceKey, params);
	}
	
	/**
	 * Удалить текущего (отправляющего запрос) пользователя из списка наблюдателей области.
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 *
	 * @return булево значение (true - успешно удалили наблюдателя)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean removeCurrentUserFromWatchersOfSpace(final String spaceKey) throws IOException
	{
		Map<String, String> params = new HashMap<>();
		return removeWatcherFromSpace(spaceKey, params);
	}
	//конец, Remove space watcher
	//----------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------
	//начало, Is watching space
	
	/**
	 * Узнать находится ли текущий пользователь в списке наблюдателей области
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param params
	 * 		параметры запроса
	 *
	 * @return булево значение (true - пользователь является наблюдателем указанной области)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	private boolean isWatchSpace(final String spaceKey, Map<String, String> params) throws IOException
	{
		Call<WatchObject> watchCall = confluenceApi.isWatchSpace(spaceKey, params);
		Response<WatchObject> response = watchCall.execute();
		WatchObject body = response.body();
		return body.isWatching();
	}
	//@formatter:on
	
	/**
	 * Определить является ли текущий (отправляющий запрос) пользователь, наблюдателем области
	 *
	 * @param spaceKey
	 * 		ключ области
	 *
	 * @return булево значение статуса (является или не является наблюдателем)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean isCurrentUserWatchSpace(final String spaceKey) throws IOException
	{
		Map<String, String> params = new HashMap<>();
		boolean watchSpace = isWatchSpace(spaceKey, params);
		return watchSpace;
	}
	
	/**
	 * Определить статус нахождения в списке наблюдателей области, пользователя заданного при помощи userName
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param userName
	 * 		имя пользователя (login)
	 *
	 * @return булево значение статуса (является или не является наблюдателем)
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public boolean isWatchSpaceByUserName(final String spaceKey, final String userName) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserName(userName);
		boolean watchSpace = isWatchSpace(spaceKey, params);
		return watchSpace;
	}
	
	/**
	 * Определить статус нахождения в списке наблюдателей области, пользователя заданного при помощи userKey
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param userKey
	 * 		ключ пользователя
	 *
	 * @return булево значение статуса (является или не является наблюдателем)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public boolean isWatchSpaceByUserKey(final String spaceKey, final String userKey) throws IOException
	{
		Map<String, String> params = Utils.createParamsUserKey(userKey);
		boolean watchSpace = isWatchSpace(spaceKey, params);
		return watchSpace;
	}
	//конец, Is watching space
	//----------------------------------------------------------------------------------------
	
	//----------- user (Non-admin user operations), Начало ---------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Получаем информацию о пользователе
	 * <br>
	 *
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект содержащий информацию о пользователе
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public User getUser(final Map<String, String> params) throws IOException
	{
		Call<User> getUserCall = confluenceApi.getUser(params);
		Response<User> response = getUserCall.execute();
		User body = response.body();
		return body;
	}
	
	/**
	 * получить информацию о юзере-анонимусе
	 * <br>
	 *
	 * @return объект, содержащий информацию о пользователе
	 *
	 * @throws IOException
	 * 		ошибки HTTP соединения
	 */
	public User getAnonymous() throws IOException
	{
		Call<User> getAnonymousCall = confluenceApi.getAnonymous();
		Response<User> response = getAnonymousCall.execute();
		User body = response.body();
		return body;
	}
	
	/**
	 * Получаем информацию о пользователе, отправляющем запрос (текущем пользователе)
	 *
	 * @return объект, содержащий информацию о пользователе
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public User getCurrentUser() throws IOException
	{
		Call<User> getCurrentCall = confluenceApi.getCurrentUser();
		Response<User> response = getCurrentCall.execute();
		User body = response.body();
		return body;
	}
	
	/**
	 * Получаем список групп, в которые входит пользователь
	 * <br>
	 *
	 * @param params
	 * 		дополнительные параметры запроса
	 *
	 * @return объект, содержащий список групп
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public GroupResultList getUserGroups(final Map<String, String> params) throws IOException
	{
		Call<GroupResultList> getGroupsCall = confluenceApi.getUserGroups(params);
		Response<GroupResultList> response = getGroupsCall.execute();
		GroupResultList body = response.body();
		return body;
	}
	//----------- user (Non-admin user operations), Конец ---------------
	//----------------------------------------------------------------------------------------
	
	//----------- space/{spaceKey}/property (Manipulating space properties). Начало ----------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Получить свойство области
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param param
	 * 		дополнительные параметры запроса
	 *
	 * @return объект, содержащий список свойств области
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public PropertyListResponseContainer getSpaceProperties(final String spaceKey,
	                                                        final Map<String, String> param) throws IOException
	{
		Call<PropertyListResponseContainer> spacePropertyCall = confluenceApi.getSpaceProperties(spaceKey, param);
		Response<PropertyListResponseContainer> response = spacePropertyCall.execute();
		PropertyListResponseContainer body = response.body();
		return body;
	}
	
	/**
	 * Создать свойство области
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 *
	 * @return объект содержащий данные свойства области
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public PropertyResponse createSpaceProperty(final String spaceKey, final PropertyOfContent property) throws IOException
	{
		Call<PropertyResponse> spacePropertyCall = confluenceApi.createSpaceProperty(spaceKey, property);
		Response<PropertyResponse> response = spacePropertyCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
	/**
	 * Получить свойство области по указанному ключу
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param key
	 * 		ключ свойства области
	 *
	 * @return объект содержащий данные свойства области
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public PropertyResponse getSpacePropertyByKey(final String spaceKey, final String key) throws IOException
	{
		Call<PropertyResponse> spacePropertyByKeyCall = confluenceApi.getSpacePropertyByKey(spaceKey, key);
		Response<PropertyResponse> response = spacePropertyByKeyCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
	/**
	 * Обновить свойство области по указанному ключу
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param key
	 * 		ключ свойства области
	 *
	 * @return объект, содержащий данные о свойстве области
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public PropertyResponse updateSpacePropertyByKey(final String spaceKey, final String key, final PropertyOfContentWithVersion property) throws IOException
	{
		Call<PropertyResponse> updateSpacePropertyCall = confluenceApi.updateSpacePropertyByKey(spaceKey, key, property);
		Response<PropertyResponse> response = updateSpacePropertyCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	
	/**
	 * Удалить свойство области по указанному ключу
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param key
	 * 		ключ свойства области
	 *
	 * @return булево значение (true - свойство области успешно удалено)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public boolean deleteSpacePropertyByKey(final String spaceKey, final String key) throws IOException
	{
		Call<Void> deletespacepropertycall = confluenceApi.deleteSpacePropertyByKey(spaceKey, key);
		Response<Void> response = deletespacepropertycall.execute();
		int code = response.code();
		boolean result = Utils.codeIs204(code);
		return result;
	}
	
	/**
	 * Создать свойство области по указанному ключу
	 * <br>
	 *
	 * @param spaceKey
	 * 		ключ области
	 * @param key
	 * 		ключ свойства облатси
	 *
	 * @return объект, содержащий данные свойства области
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	PropertyResponse createSpacePropertyByKey(final String spaceKey, final String key, final PropertyOfContent property) throws IOException
	{
		Call<PropertyResponse> createSpacePropertyCall = confluenceApi.createSpacePropertyByKey(spaceKey, key, property);
		Response<PropertyResponse> response = createSpacePropertyCall.execute();
		PropertyResponse body = response.body();
		return body;
	}
	//----------- space/{spaceKey}/property (Manipulating space properties). Конец -----------
	//----------------------------------------------------------------------------------------
	
	//-----------  /rest/accessmode Начало ---------------------------------------------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * todo дописать
	 *
	 * @return todo проверить и дописать
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public Object getAccessModeStatus() throws IOException
	{
		Call<Object> accessModeStatusCall = confluenceApi.getAccessModeStatus();
		Response<Object> response = accessModeStatusCall.execute();
		Object body = response.body();
		return body;
	}
	//----------- /rest/accessmode Конец -----------------------------------------------------
	//----------------------------------------------------------------------------------------
	
	//-----------  longtask: REST wrapper for the LongTaskService. Начало --------------------
	//----------------------------------------------------------------------------------------
	
	/**
	 * Возвращает информацию обо всех отслеживаемых (tracked) длительных (long-running) задачах (task)
	 *
	 * @return объект-контейнер, содержащий список задач (list of long-running task)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public LongTaskListResultContainer getTasksList() throws IOException
	{
		Call<LongTaskListResultContainer> tasksListCall = confluenceApi.getTasksList();
		Response<LongTaskListResultContainer> response = tasksListCall.execute();
		LongTaskListResultContainer body = response.body();
		return body;
	}
	
	/**
	 * Возвращает информацию об одной отслеживаемой (tracked) длительной (long-running) задаче (task)
	 * <br>
	 *
	 * @return объект-представление задачи (long-running task)
	 *
	 * @throws IOException
	 * 		ошибки сети
	 */
	public LongTask getTask(final String taskId) throws IOException
	{
		Call<LongTask> getTaskCall = confluenceApi.getTask(taskId);
		Response<LongTask> response = getTaskCall.execute();
		LongTask body = response.body();
		return body;
	}
	//-----------   longtask: REST wrapper for the LongTaskService. Конец --------------------
	//----------------------------------------------------------------------------------------
}
