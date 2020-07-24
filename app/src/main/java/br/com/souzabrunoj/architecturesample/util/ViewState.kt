package br.com.souzabrunoj.architecturesample.util

sealed class ViewState<T>()
data class Success<T>(val data: T) : ViewState<T>()
data class Failure<T>(val error: Throwable?) : ViewState<T>()
class Loading<T>() : ViewState<T>()