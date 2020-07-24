package br.com.souzabrunoj.architecturesample.application

import android.app.Application
import br.com.souzabrunoj.architecturesample.di.module.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            modules(applicationModules)
        }.androidContext(this)
    }
}