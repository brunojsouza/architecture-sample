package br.com.souzabrunoj.data.faker

import br.com.souzabrunoj.data.model.GlobalDataResponse
import br.com.souzabrunoj.data.randomLong

object GlobalDataResponseFaker {
    fun getRandomData(): GlobalDataResponse =
        GlobalDataResponse(
            newConfirmed = randomLong(),
            totalConfirmed = randomLong(),
            newDeaths = randomLong(),
            totalDeaths = randomLong(),
            newRecovered = randomLong(),
            totalRecovered = randomLong()
        )


    fun getEmptyData(): GlobalDataResponse = GlobalDataResponse()

}