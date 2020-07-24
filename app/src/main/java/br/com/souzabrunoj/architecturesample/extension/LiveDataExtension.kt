package br.com.souzabrunoj.architecturesample.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.souzabrunoj.architecturesample.util.Failure
import br.com.souzabrunoj.architecturesample.util.Loading
import br.com.souzabrunoj.architecturesample.util.Success
import br.com.souzabrunoj.architecturesample.util.ViewState

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    this.value = Success(data)
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable?) {
    this.value = Failure(error)
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    this.value = Loading()
}

fun <T> LiveData<ViewState<T>>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    onLoading: (() -> Unit)? = null,
    onSuccess: ((T) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null
) {
    this.observe(lifecycleOwner, Observer { viewState ->

        when (viewState) {

            is Loading -> {
                onLoading?.invoke()
            }

            is Success -> {
                viewState.data?.let {
                    onSuccess?.invoke(it)
                }
            }

            is Failure -> {
                viewState.error?.let {
                    onError?.invoke(it)
                }
            }

            else -> Unit
        }
    })

}