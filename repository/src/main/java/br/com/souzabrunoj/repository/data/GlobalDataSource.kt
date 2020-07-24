package br.com.souzabrunoj.repository.data

import br.com.souzabrunoj.domain.model.GlobalData
import kotlinx.coroutines.flow.Flow

interface GlobalDataSource {
    fun getGlobalData(): Flow<GlobalData>
}