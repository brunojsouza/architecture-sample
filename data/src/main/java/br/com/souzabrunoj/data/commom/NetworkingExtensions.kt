package br.com.souzabrunoj.data.commom

import br.com.souzabrunoj.data.model.BaseResponse
import br.com.souzabrunoj.data.model.error.NetworkingConnectionException
import br.com.souzabrunoj.data.model.error.NetworkingError
import br.com.souzabrunoj.data.util.fromJson
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

fun Throwable.toNetworkingError(): NetworkingError {
    return when (this) {
        is HttpException -> this.toNetworkingError()
        is ConnectException -> NetworkingError(message = this.toErrorDescription())
        is UnknownHostException -> NetworkingError(message = this.toErrorDescription())
        else -> NetworkingError(message = this.message, originalError = this)
    }
}

private fun HttpException.toNetworkingError(): NetworkingError {
    val errorResponse = response()?.errorBody()?.string()?.run { fromJson<BaseResponse>(this) }
    return NetworkingError(
        message = message(),
        errorCode = errorResponse?.getErrorCode(),
        httpCode = code(),
        errorDescription = errorResponse?.getMessage() ?: code().toHttpCodeDescriptionIfNeeded(),
        httpErrorDescription = message,
        originalError = this
    )
}

private fun Throwable.toErrorDescription(): String {
    return when (this) {
        is NetworkingConnectionException -> "Connection error"
        is UnknownHostException -> "Unknown error"
        else -> "Generic error"
    }
}

private fun Int.toHttpCodeDescriptionIfNeeded(): String? {
    return when (this) {
        in 0..499 -> "Message here"
        in 500..599 -> "Message here"
        else -> null
    }
}