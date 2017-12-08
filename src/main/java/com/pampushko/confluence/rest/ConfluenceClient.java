package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.SpaceResultList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
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
	 * возвратить список доступных областей
	 * <br />
	 */
	public SpaceResultList getSpaces() throws IOException
	{
		Call<SpaceResultList> spaces = confluenceApi.getSpaces();
		retrofit2.Response<SpaceResultList> execute = spaces.execute();
		SpaceResultList body = execute.body();
		return body;
	}
}
