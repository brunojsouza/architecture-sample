package br.com.souzabrunoj.data.model.error

import java.io.IOException

class NetworkingConnectionException(override val message: String) : IOException(message)
