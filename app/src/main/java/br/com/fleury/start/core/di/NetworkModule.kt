package br.com.fleury.start.core.di

import br.com.fleury.start.core.api.Constants
import br.com.fleury.start.core.api.IApi
import br.com.fleury.start.core.local.dao.UserDAO
import br.com.fleury.start.home.present.model.HomeModel
import br.com.fleury.start.home.present.model.IHomeModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

@Module
class NetworkModule {

    @Provides
    fun providesGson(): Gson =
        GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).create()

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    fun providesApi(retrofit: Retrofit): IApi = retrofit.create(IApi::class.java)

    @Provides
    fun providesHomeModel(api: IApi, userDAO: UserDAO): IHomeModel = HomeModel(api, userDAO)
}