package br.com.souzabrunoj.architecturesample.di.module

import br.com.souzabrunoj.di.koinModules

val applicationModules = koinModules.plus(presentationModules)