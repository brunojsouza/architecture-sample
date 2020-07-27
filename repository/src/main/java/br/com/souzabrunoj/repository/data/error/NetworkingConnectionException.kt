package br.com.souzabrunoj.repository.data.error

import java.io.IOException

class NetworkingConnectionException(override val message: String) : IOException(message)
