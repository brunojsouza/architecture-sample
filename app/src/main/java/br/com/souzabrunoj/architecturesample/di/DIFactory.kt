package br.com.souzabrunoj.architecturesample.di

import android.content.Context
import br.com.souzabrunoj.architecturesample.di.module.dataSourceModule
import br.com.souzabrunoj.architecturesample.di.module.domainModule
import br.com.souzabrunoj.architecturesample.di.module.presentationModules
import br.com.souzabrunoj.architecturesample.di.module.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DIFactory {
    fun getInstance(context: Context) {
        startKoin {
            modules(
                listOf(
                    dataSourceModule,
                    repositoryModule,
                    domainModule,
                    presentationModules
                )
            )
        }.androidContext(
            context
        )
    }
}