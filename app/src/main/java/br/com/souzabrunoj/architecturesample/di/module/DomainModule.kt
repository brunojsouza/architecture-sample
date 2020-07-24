package br.com.souzabrunoj.architecturesample.di.module

import br.com.souzabrunoj.domain.usecase.GlobalDataUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GlobalDataUseCase(get()) }
}