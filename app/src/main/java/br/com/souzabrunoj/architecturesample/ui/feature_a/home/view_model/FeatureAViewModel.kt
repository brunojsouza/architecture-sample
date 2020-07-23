package br.com.souzabrunoj.architecturesample.ui.feature_a.home.view_model

import androidx.lifecycle.ViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_a.router.FeatureARouter

class FeatureAViewModel(private val router: FeatureARouter): ViewModel() {

    fun openFeatureB(){
        router.openFeatureB()
    }
}