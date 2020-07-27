package br.com.souzabrunoj.architecturesample.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.souzabrunoj.architecturesample.util.ViewState
import br.com.souzabrunoj.architecturesample.util.ViewStatus
import br.com.souzabrunoj.domain.commom.Failure

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    this.value = ViewState(ViewStatus.SUCCESS, data = data)
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable?) {
    this.value = ViewState(ViewStatus.ERROR, error = error)
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    this.value = ViewState(ViewStatus.LOADING)
}

fun <T> MutableLiveData<ViewState<T>>.postFailure(failure: Failure) {
    this.value = ViewState(ViewStatus.FAILURE, failure = failure)
}

fun <T> LiveData<ViewState<T>>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    onLoading: (() -> Unit)? = null,
    onSuccess: ((T) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null,
    onFailure: ((Failure) -> Unit)? = null
) {
    this.observe(lifecycleOwner, Observer { viewState ->

        when (this.value?.status) {
            ViewStatus.LOADING -> {
                onLoading?.invoke()
            }

            ViewStatus.SUCCESS -> {
                viewState.data?.let {
                    onSuccess?.invoke(it)
                }
            }

            ViewStatus.ERROR -> {
                viewState.error?.let {
                    onError?.invoke(it)
                }
            }

            ViewStatus.FAILURE -> {
                viewState.failure?.let {
                    onFailure?.invoke(it)
                }
            }
            else -> Unit
        }
    })
}