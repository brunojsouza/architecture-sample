package br.com.souzabrunoj.domain.usecase

import br.com.souzabrunoj.domain.repository.GlobalDataRepository

class GlobalDataUseCase(private val repository: GlobalDataRepository) {
    operator fun invoke() = repository.getGlobalData()
}