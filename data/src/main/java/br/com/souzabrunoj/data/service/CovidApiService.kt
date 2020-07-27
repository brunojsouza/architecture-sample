package br.com.souzabrunoj.data.service

import br.com.souzabrunoj.repository.data.GlobalResponse
import retrofit2.http.GET

interface CovidApiService {

    @GET("summary")
    suspend fun getSummary(): GlobalResponse
}