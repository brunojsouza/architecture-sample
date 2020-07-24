package br.com.souzabrunoj.architecturesample.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {

    fun <T : Any> run(
        useCase: () -> Flow<T>,
        onSuccess: (T) -> Unit,
        onError: ((Throwable) -> Unit) = {}
    ) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.invoke()

                result.collect {
                    withContext(Dispatchers.Main) { onSuccess(it) }
                }
            }
        } catch (err: Exception) {
            onError(err)
        }

    }

    fun <T> runAsync(
        useCase: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: ((Throwable) -> Unit) = {}
    ) = viewModelScope.async(Dispatchers.IO) {
        try {
            val result = useCase()
            withContext(Dispatchers.Main) { onSuccess(result) }
        } catch (err: Exception) {
            withContext(Dispatchers.Main) { onError(err) }
        }
    }
}