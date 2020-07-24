package br.com.souzabrunoj.architecturesample.di.module

import br.com.souzabrunoj.domain.repository.GlobalDataRepository
import br.com.souzabrunoj.repository.GlobalDataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { GlobalDataRepositoryImpl(get()) as GlobalDataRepository }
}