package br.com.souzabrunoj.data.service.base

import br.com.souzabrunoj.data.service.SafeResult
import br.com.souzabrunoj.repository.common.toNetworkingError

abstract class BaseNetworking {
    suspend fun <R : Any> safeApiCall(block: suspend () -> R): R {
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
                is SafeResult.Error -> throw exception.toNetworkingError()
            }
        }
    }
}
