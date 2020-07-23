package br.com.souzabrunoj.architecturesample.ui.feature_b.home.view_model

import androidx.lifecycle.ViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_b.router.FeatureBRouter

class FeatureBViewModel(private val router: FeatureBRouter): ViewModel() {

    fun openFeatureA(){
        router.openFeatureA()
    }
}