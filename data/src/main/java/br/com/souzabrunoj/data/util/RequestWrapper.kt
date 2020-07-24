package br.com.souzabrunoj.data.util

interface RequestWrapper {
    suspend fun <D> wrapper(call: suspend () -> D): D }

class RequestWrapperImpl : RequestWrapper {
    @Synchronized
    override suspend fun <D> wrapper(call: suspend () -> D): D {
        return try {
            call()
        } catch (exception: Exception) {
            throw exception
        }
    }
}
