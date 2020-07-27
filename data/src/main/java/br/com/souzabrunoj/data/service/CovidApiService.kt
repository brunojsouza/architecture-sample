package br.com.souzabrunoj.data.service

import br.com.souzabrunoj.data.model.GlobalResponse
import retrofit2.http.GET

interface CovidApiService {

    @GET("summarys")
    suspend fun getSummary(): GlobalResponse
}