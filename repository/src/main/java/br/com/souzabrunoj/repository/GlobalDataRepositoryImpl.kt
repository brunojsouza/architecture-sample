package br.com.souzabrunoj.repository

import br.com.souzabrunoj.data.mapper.toGlobalData
import br.com.souzabrunoj.data.remote.GlobalDataSource
import br.com.souzabrunoj.domain.commom.Either
import br.com.souzabrunoj.domain.commom.Failure
import br.com.souzabrunoj.domain.commom.Success
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.domain.repository.GlobalDataRepository

class GlobalDataRepositoryImpl(private val dataSource: GlobalDataSource) : GlobalDataRepository,
    BaseRepository() {

    override suspend fun getGlobalData(): Either<Failure, GlobalData> =
        doRequest { Success(dataSource.getGlobalData().toGlobalData()) }

}