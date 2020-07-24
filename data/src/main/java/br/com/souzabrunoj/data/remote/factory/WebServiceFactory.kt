package br.com.souzabrunoj.data.remote.factory

import br.com.souzabrunoj.data.util.WebService.BASE_GLOBAL_COVID_SUMMARY_URL
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

object WebServiceFactory {
    inline fun <reified T> createWebService(
        okHttpClient: OkHttpClient,
        url: String = BASE_GLOBAL_COVID_SUMMARY_URL
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(UnitConverterFactory)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }

    fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
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