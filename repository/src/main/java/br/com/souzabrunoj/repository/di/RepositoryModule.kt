package br.com.souzabrunoj.repository.di

import br.com.souzabrunoj.domain.repository.GlobalDataRepository
import br.com.souzabrunoj.repository.GlobalDataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GlobalDataRepository> { GlobalDataRepositoryImpl(get()) }
}