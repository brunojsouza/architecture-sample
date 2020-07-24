package br.com.souzabrunoj.data.remote

import br.com.souzabrunoj.data.mapper.toGlobalData
import br.com.souzabrunoj.data.service.CovidApiService
import br.com.souzabrunoj.data.util.RequestWrapper
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.repository.data.GlobalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject

class GlobalDataSourceImpl(private val apiCaller: CovidApiService) : GlobalDataSource, KoinComponent {

    private val requestWrapper: RequestWrapper by inject()

    override fun getGlobalData(): Flow<GlobalData> = flow {
        emit( requestWrapper.wrapper {
            apiCaller.getSummary().globalDataResponse.toGlobalData()
        })
    }
}