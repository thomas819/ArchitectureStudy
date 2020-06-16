package com.example.architecturestudy.di

import com.example.architecturestudy.data.remote.api.Api
import com.example.architecturestudy.data.remote.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideAuthApi(
            @Named("unauthorized") okHttpClient: OkHttpClient,
            callAdapter: CallAdapter.Factory,
            converter: Converter.Factory): AuthApi = Retrofit.Builder()
            .baseUrl("https://github.com")
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()
            .create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideApi(
            @Named("authorized")
            okHttpClient: OkHttpClient, callAdapter: CallAdapter.Factory, converter: Converter.Factory): Api =
            Retrofit
                    .Builder()
                    .baseUrl("https://api.github.com")
                    .client(okHttpClient)
                    .addCallAdapterFactory(callAdapter)
                    .addConverterFactory(converter)
                    .build()
                    .create(Api::class.java)

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}
