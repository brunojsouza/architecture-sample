package br.com.souzabrunoj.architecturesample.di.module

import br.com.souzabrunoj.data.remote.GlobalDataSourceImpl
import br.com.souzabrunoj.data.remote.factory.WebServiceFactory
import br.com.souzabrunoj.data.service.CovidApiService
import br.com.souzabrunoj.data.util.RequestWrapper
import br.com.souzabrunoj.data.util.RequestWrapperImpl
import br.com.souzabrunoj.repository.data.GlobalDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {

    single { RequestWrapperImpl() } bind RequestWrapper::class
    single { WebServiceFactory.createOkHttpClient() }
    single { WebServiceFactory.createWebService(get()) as CovidApiService }

    single { GlobalDataSourceImpl(get()) as GlobalDataSource }
}