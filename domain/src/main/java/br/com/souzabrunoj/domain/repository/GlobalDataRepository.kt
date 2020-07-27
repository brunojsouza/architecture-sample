package br.com.souzabrunoj.domain.repository

import br.com.souzabrunoj.domain.commom.Either
import br.com.souzabrunoj.domain.commom.Failure
import br.com.souzabrunoj.domain.model.GlobalData

interface GlobalDataRepository {
     suspend fun getGlobalData(): Either<Failure, GlobalData>
}