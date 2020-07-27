package br.com.souzabrunoj.data.service

import java.io.IOException

class NetworkingConnectionException(override val message: String) : IOException(message)
