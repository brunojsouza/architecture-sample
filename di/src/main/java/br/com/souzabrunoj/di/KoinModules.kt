package br.com.souzabrunoj.di

import br.com.souzabrunoj.data.di.dataSourceModule
import br.com.souzabrunoj.domain.di.domainModule
import br.com.souzabrunoj.repository.di.repositoryModule

val koinModules = listOf(dataSourceModule, repositoryModule, domainModule)
