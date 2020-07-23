package br.com.souzabrunoj.service

import retrofit2.http.GET

interface CovidApiService {

    @GET("summary")
    suspend fun getSummary()
}