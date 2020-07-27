package br.com.souzabrunoj.repository.datasouces

import br.com.souzabrunoj.repository.data.GlobalDataResponse

interface GlobalDataSource {
    suspend fun getGlobalData(): GlobalDataResponse
}