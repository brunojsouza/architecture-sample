package br.com.souzabrunoj.data.remote

import br.com.souzabrunoj.data.model.GlobalDataResponse
import br.com.souzabrunoj.data.service.BaseNetworking
import br.com.souzabrunoj.data.service.CovidApiService

class GlobalDataSourceImpl(private val apiCaller: CovidApiService) : GlobalDataSource,
    BaseNetworking() {

    override suspend fun getGlobalData(): GlobalDataResponse =
        safeApiCall { apiCaller.getSummary().globalDataResponse }
}