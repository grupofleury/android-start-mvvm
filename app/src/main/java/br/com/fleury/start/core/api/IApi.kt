package br.com.fleury.start.core.api

import br.com.fleury.start.core.local.entity.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface IApi {
    @GET("/v2/5c5477162f00005300bf747d")
    fun getUsers(): Deferred<Response<List<User>>>
}