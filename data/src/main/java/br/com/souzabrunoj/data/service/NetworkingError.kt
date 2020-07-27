package br.com.souzabrunoj.data.service

data class NetworkingError(
    override val message: String?,
    val errorCode: String? = null,
    val httpCode: Int? = null,
    val errorDescription: String? = null,
    val httpErrorDescription: String? = null,
    val originalError: Throwable? = null
) : Throwable()