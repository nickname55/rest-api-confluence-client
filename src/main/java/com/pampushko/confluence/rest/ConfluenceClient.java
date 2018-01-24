package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.NoContentResponse;
import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

/**
 * Класс клиент для Atlassian Confluence
 * <br />
 */
class ConfluenceClient
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
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
	 * Возвращает список областей Confluence - {@code Space}
	 * <br />
	 * с кодом {@code key} и
	 * именем {@code name}.
	 * <br />
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
	 * @param space - область {@code Space} для создания.
	 * <br />
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
	 * @param space - область {@code Space} для создания.
	 * <br />
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
	 * Удаляем область Confluence - {@code Space}
	 * <br />
	 * имеющую ключ {@code key}
	 * <br />
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
}
