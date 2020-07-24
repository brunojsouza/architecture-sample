package br.com.souzabrunoj.domain.repository

import br.com.souzabrunoj.domain.model.GlobalData
import kotlinx.coroutines.flow.Flow

interface GlobalDataRepository {
     fun getGlobalData(): Flow<GlobalData>
}