package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.*;
import com.pampushko.confluence.models.group.GroupResultList;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * Класс клиент для Atlassian Confluence
 * <br />
 */
@Slf4j
public class ConfluenceClient
{
	/**
	 * Имя пользователя
	 * <br />
	 */
	String username;
	/**
	 * Пароль
	 * <br />
	 */
	String password;
	/**
	 * базовый URL вашего инстанса Confluence
	 * <br />
	 */
	String baseUrl;
	
	private ConfluenceApi confluenceApi;
	
	private ConfluenceClient()
	{
	
	}
	
	public static Builder newBuilder()
	{
		return new ConfluenceClient().new Builder();
	}
	
	////////////////////////////////////////////////////////////////////////
	public class Builder
	{
		private Builder()
		{
		
		}
		
		public Builder username(String username)
		{
			ConfluenceClient.this.username = username;
			return this;
		}
		
		public Builder password(String password)
		{
			ConfluenceClient.this.password = password;
			return this;
		}
		
		public Builder baseUrl(String baseUrl)
		{
			ConfluenceClient.this.baseUrl = baseUrl;
			return this;
		}
		
		///////////////////////////////////////////////////
		
		/**
		 * настраиваем REST-адаптер, который будет использоваться с нашим Confluence REST API
		 * <br />
		 * И создаем реализацию API, которая соответствует описанию в интерфейсе {@link com.pampushko.confluence.rest.ConfluenceApi}
		 * <br />
		 *
		 * @return
		 */
		public ConfluenceClient build()
		{
			Retrofit retrofit = new RetrofitCreator().getRetrofitRestAdapter(ConfluenceClient.this);
			ConfluenceClient.this.confluenceApi = retrofit.create(ConfluenceApi.class);
			return ConfluenceClient.this;
		}
	}
	
	/**
	 * Возвращает информацию об области Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key}
	 * <br />
	 *
	 * @return возвращаёмое значение {@code SpaceResultList} - массив из областей {@code Space}
	 * <br />
	 */
	public Space getSpaceByKey(final String spaceKey, final Map<String, String> params) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.getSpaceByKey(spaceKey, params);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
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
	public SpaceResultList getSpaces() throws IOException
	{
		Call<SpaceResultList> spacesCall = confluenceApi.getSpaces();
		Response<SpaceResultList> response = spacesCall.execute();
		SpaceResultList body = response.body();
		return body;
	}
	
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
	public Space createSpace(final Space space) throws IOException
	{
		Call<Space> spaceCall = confluenceApi.createSpace(space);
		Response<Space> response = spaceCall.execute();
		Space body = response.body();
		return body;
	}
	
	/**
	 * Создаём новую приватную (<strong>видимую только для создателя</strong>) область Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
	 * Но не ясно, чем этот способ создания отличается от обычного создания области,
	 * <br />
	 * т.к. область созданная обычным способом также доступна только для своего создателя
	 * <br />
	 * <strong>todo разобраться с назначением метода более подробно</strong>
	 * <br />
	 *
	 * @param space - область {@code Space} для создания.
	 *              <br />
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно создана
	 * <br />
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
	 * <br />
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
	 * <br />
	 * имеющую ключ {@code key}
	 * <br />
	 *
	 * @return возвращаёмое значение {@code Space}, как подтверждение, что область действительно удалена
	 * <br />
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
	 * <br />
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
	 * <br />
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
	 * <br />
	 *
	 * @param contentId
	 * @param versionNumber
	 * @param params
	 * @return
	 */
	Version getVersionOfContent(final String contentId, final int versionNumber,
	                            final Map<String, String> params) throws IOException
	{
		Call<Version> versionCall = confluenceApi.getVersionOfContent(contentId, versionNumber, params);
		Response<Version> response = versionCall.execute();
		Version body = response.body();
		return body;
	}
	
	
	/**
	 * Получить список групп (разбитый на страницы)
	 * @param start
	 * @param limit
	 * @return
	 */
	GroupResultList getGetGroups(final int start, final int limit) throws IOException
	{
		Call<GroupResultList> groupResultListCall = confluenceApi.getGetGroups(start, limit);
		Response<GroupResultList> response = groupResultListCall.execute();
		GroupResultList body = response.body();
		return body;
	}
	
}
