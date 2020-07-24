package br.com.souzabrunoj.architecturesample.ui.feature_a.home.view_model

import br.com.souzabrunoj.architecturesample.ui.base.BaseViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_a.router.FeatureARouter

class FeatureAViewModel(private val router: FeatureARouter) : BaseViewModel() {

    fun openFeatureB() {
        router.openFeatureB()
    }

    fun fromHomeToSecondScreen() {
        router.fromHomeToSecondScreen()
    }
}