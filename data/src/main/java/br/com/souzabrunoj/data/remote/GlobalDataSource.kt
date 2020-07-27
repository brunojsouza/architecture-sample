package br.com.souzabrunoj.data.remote

import br.com.souzabrunoj.data.model.GlobalDataResponse

interface GlobalDataSource {
    suspend fun getGlobalData(): GlobalDataResponse
}