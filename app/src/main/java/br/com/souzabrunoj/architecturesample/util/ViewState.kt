package br.com.souzabrunoj.architecturesample.util

import br.com.souzabrunoj.domain.commom.Failure

class ViewState<T>(
    val status: ViewStatus,
    val data: T? = null,
    val error: Throwable? = null,
    val failure: Failure? = null
)

enum class ViewStatus {
    LOADING, SUCCESS, ERROR, FAILURE
}
