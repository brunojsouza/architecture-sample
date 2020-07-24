package br.com.souzabrunoj.data.util

sealed class Response<out T> {
    class Success<T>(val data: T) : Response<T>()
    class Error(val exception: Throwable) : Response<Nothing>()
}