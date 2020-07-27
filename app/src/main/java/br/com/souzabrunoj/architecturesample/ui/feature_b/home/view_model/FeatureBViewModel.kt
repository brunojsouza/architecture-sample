package br.com.souzabrunoj.architecturesample.ui.feature_b.home.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.architecturesample.extension.postFailure
import br.com.souzabrunoj.architecturesample.extension.postLoading
import br.com.souzabrunoj.architecturesample.extension.postSuccess
import br.com.souzabrunoj.architecturesample.ui.feature_b.router.FeatureBRouter
import br.com.souzabrunoj.architecturesample.util.ViewState
import br.com.souzabrunoj.domain.commom.Failure
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.domain.usecase.GlobalDataUseCase
import br.com.souzabrunoj.domain.usecase.UseCase
import kotlinx.coroutines.launch

class FeatureBViewModel(private val router: FeatureBRouter, private val useCase: GlobalDataUseCase): ViewModel()  {

    private val _globalDataState by lazy { MutableLiveData<ViewState<GlobalData>>() }
    val globalDateState = _globalDataState

    fun openFeatureA() {
        router.openFeatureA()
    }

    fun getGlobalData() {
        _globalDataState.postLoading()
        viewModelScope.launch {
            useCase.execute(UseCase.None()).either(::handleGetGlobalDataFailure, ::handleGetGlobalDataSuccess)
        }
    }

    private fun handleGetGlobalDataFailure(failure: Failure) {
        _globalDataState.postFailure(failure)
    }

    private fun handleGetGlobalDataSuccess(response: GlobalData) {
        _globalDataState.postSuccess(response)
    }
}