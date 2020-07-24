package br.com.souzabrunoj.architecturesample.application

import android.app.Application
import br.com.souzabrunoj.architecturesample.di.DIFactory

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        DIFactory.getInstance(this)
    }
}