package br.com.souzabrunoj.data.service

typealias Block<R> = suspend () -> R

abstract class BaseNetworking {
    suspend fun <R : Any> safeApiCall(block: Block<R>): R {
        var response: R? = null
        return try {
            response = block.invoke()
            SafeResult.Success(response)
        } catch (error: Throwable) {
            error.printStackTrace()
            SafeResult.Error(error, response)
        }.run {
            when (this) {
                is SafeResult.Success -> data
                is SafeResult.Error -> throw this.exception.toNetworkingError()
            }
        }
    }
}
