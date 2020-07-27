package br.com.souzabrunoj.data.di

import br.com.souzabrunoj.data.remote.GlobalDataSourceImpl
import br.com.souzabrunoj.data.service.CovidApiService
import br.com.souzabrunoj.data.service.core.RequestInterceptor
import br.com.souzabrunoj.data.service.core.WebServiceFactory
import br.com.souzabrunoj.data.util.RequestWrapper
import br.com.souzabrunoj.data.util.RequestWrapperImpl
import br.com.souzabrunoj.repository.datasouces.GlobalDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    single { RequestWrapperImpl() } bind RequestWrapper::class
    single { RequestInterceptor() }
    single { WebServiceFactory.createOkHttpClient(get()) }
    single<CovidApiService> { WebServiceFactory.createWebService(get()) }
    single<GlobalDataSource> { GlobalDataSourceImpl(get()) }
}