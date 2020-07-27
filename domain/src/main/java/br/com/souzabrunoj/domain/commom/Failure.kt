package br.com.souzabrunoj.domain.commom

/**
 * Base Class for handling errorsLiveData/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object NotFound : Failure()
    object Unknown : Failure()

    /**
     * A standard error response from a service
     *
     *  @property message provides a error message obtained from a service
     *  @property httpCode provides a error code
     *  @property errorCode provides a alternative error code
     *
     */
    data class ServiceError(
        private val messageInternal: String? = null,
        val httpCode: Int? = null,
        val errorCode: String? = null
    ) : Failure() {
        override var message = messageInternal?.takeIf { it.isNotEmpty() } ?: "Aconteceu um erro por aqui. Já estamos trabalhando nisso. Tente novamente em breve."
    }

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

    open val message: String = ""
}