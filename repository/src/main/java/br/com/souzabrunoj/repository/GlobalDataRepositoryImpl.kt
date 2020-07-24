package br.com.souzabrunoj.repository

import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.domain.repository.GlobalDataRepository
import br.com.souzabrunoj.repository.data.GlobalDataSource
import kotlinx.coroutines.flow.Flow

class GlobalDataRepositoryImpl(private val dataSource: GlobalDataSource) : GlobalDataRepository {

    override fun getGlobalData(): Flow<GlobalData> = dataSource.getGlobalData()

}