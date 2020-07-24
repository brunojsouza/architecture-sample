package br.com.souzabrunoj.architecturesample.ui.feature_b.home.view_model

import androidx.lifecycle.MutableLiveData
import br.com.souzabrunoj.architecturesample.extension.postError
import br.com.souzabrunoj.architecturesample.extension.postLoading
import br.com.souzabrunoj.architecturesample.extension.postSuccess
import br.com.souzabrunoj.architecturesample.ui.base.BaseViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_b.router.FeatureBRouter
import br.com.souzabrunoj.architecturesample.util.ViewState
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.domain.usecase.GlobalDataUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class FeatureBViewModel(
    private val router: FeatureBRouter
) : BaseViewModel(), KoinComponent {

    private val useCase: GlobalDataUseCase by inject()

    private val _globalDataState by lazy { MutableLiveData<ViewState<GlobalData>>() }
    val globalDateState = _globalDataState

    fun openFeatureA() {
        router.openFeatureA()
    }

    fun getGlobalData() {
        _globalDataState.postLoading()
        run(
            useCase = { useCase() },
            onSuccess = {
                _globalDataState.postSuccess(it)
            },
            onError = {
                _globalDataState.postError(it)
            }
        )
    }
}