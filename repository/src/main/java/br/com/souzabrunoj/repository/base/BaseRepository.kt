package br.com.souzabrunoj.repository.base

import br.com.souzabrunoj.data.model.error.NetworkingError
import br.com.souzabrunoj.domain.commom.Either
import br.com.souzabrunoj.domain.commom.Error
import br.com.souzabrunoj.domain.commom.Failure
import retrofit2.HttpException

abstract class BaseRepository {
    protected suspend fun <R : Any?> doRequest(block: suspend () -> Either<Failure.ServiceError, R>) =
        try {
            block()
        } catch (error: Throwable) {
            when (error) {
                is NetworkingError -> Error(Failure.ServiceError(error.errorDescription ?: error.message, httpCode = error.httpCode))
                else -> Error(Failure.ServiceError(messageInternal = error.message, httpCode = (error as? HttpException)?.code()))
            }
        }
}