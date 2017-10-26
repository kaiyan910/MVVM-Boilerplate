package com.kennah.mvvmboilerplate.di.module

import com.kennah.mvvmboilerplate.GithubApi
import com.kennah.mvvmboilerplate.di.scope.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @AppScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @AppScope
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(logger)
        return client.build()
    }

    @Provides
    @AppScope
    fun provideConvertFactory(): Converter.Factory = JacksonConverterFactory.create()

    @Provides
    @AppScope
    fun provideRetrofit(@Named("server") server: String, okHttpClient: OkHttpClient, factory: Converter.Factory): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(server)
            addConverterFactory(factory)
            client(okHttpClient)
        }.build()
    }

    @Provides
    @AppScope
    fun provideApi(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)
}