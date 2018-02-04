package com.pampushko.confluence.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Base64;

/**
 * Класс для создании сконфигурированного объекта Retrofit
 * <br />
 */
@Slf4j
public class RetrofitCreator
{
	Retrofit getRetrofitRestAdapter(Confluence confluence)
	{
		final String username = confluence.username;
		final String password = confluence.password;
		
		//HTTP Basic authentication для REST API Confluence
		final String credentials = username + ":" + password;
		//кодируем в base64.
		final String encodedCredentials = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
		
		//создаем gson-билдер
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").disableHtmlEscaping().create();
		
		//создаем интерсептор для логирования
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		
		//создаем http-клиента OkHttp и добавляем в него интерсептор (чтобы добавить нужные нам заголовки к
		// каждому из посылаемых нами запросов)
		OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor()
		{
			@Override
			public Response intercept(Chain chain) throws IOException
			{
				Request request = chain.request().newBuilder().addHeader("Accept", "application/json").addHeader("Authorization", encodedCredentials).addHeader("X-Atlassian-Token", "nocheck").addHeader("User-Agent", "curl/7.47.0").build();
				return chain.proceed(request);
			}
		}).addInterceptor(interceptor).build();
		//создаем экземпляр Ретрофита - добавляем к ретрофиту созданный нами ранее Http-клиент
		Retrofit retrofit = new Retrofit.Builder()
				
				.baseUrl(confluence.baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(httpClient).build();
		
		return retrofit;
	}
}
