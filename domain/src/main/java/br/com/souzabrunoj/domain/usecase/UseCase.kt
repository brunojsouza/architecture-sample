package br.com.souzabrunoj.domain.usecase

import android.os.Parcelable
import br.com.souzabrunoj.domain.commom.Either
import br.com.souzabrunoj.domain.commom.Error
import br.com.souzabrunoj.domain.commom.Failure
import br.com.souzabrunoj.domain.commom.Success
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out Type, in Params> where Type : Any {

    protected abstract suspend fun run(params: Params): Either<Failure, Type>

    suspend fun execute(params: Params): Either<Failure, Type> {
        return withContext(Dispatchers.IO) {
            run(params).run {
                when (this) {
                    is Error -> Error(Failure.ServiceError(a.message))
                    is Success -> this
                }
            }
        }
    }

    @Parcelize
    class None : Parcelable
}