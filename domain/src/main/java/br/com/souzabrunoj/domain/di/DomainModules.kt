package br.com.souzabrunoj.domain.di

import br.com.souzabrunoj.domain.usecase.GlobalDataUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GlobalDataUseCase(get()) }
}