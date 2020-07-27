package br.com.souzabrunoj.domain.usecase

import br.com.souzabrunoj.domain.commom.Either
import br.com.souzabrunoj.domain.commom.Failure
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.domain.repository.GlobalDataRepository

class GlobalDataUseCase(private val repository: GlobalDataRepository) :
    UseCase<GlobalData, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, GlobalData> = repository.getGlobalData()
}