package br.com.souzabrunoj.data.service.core

import br.com.souzabrunoj.service.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

object WebServiceFactory {
    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String = BuildConfig.BASE_URL): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create()
    }

    fun createOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(1800, TimeUnit.SECONDS)
            .readTimeout(1800, TimeUnit.SECONDS)
            .writeTimeout(1800, TimeUnit.SECONDS)
            .build()


    object UnitConverterFactory : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type, annotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            return if (type == Unit::class.java) UnitConverter else null
        }

        private object UnitConverter : Converter<ResponseBody, Unit> {
            override fun convert(value: ResponseBody) {
                value.close()
            }
        }
    }
}