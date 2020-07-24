package br.com.souzabrunoj.data.mapper

import br.com.souzabrunoj.data.model.GlobalDataResponse
import br.com.souzabrunoj.data.util.Helper.EMPTY_LONG_NUMBER
import br.com.souzabrunoj.domain.model.GlobalData

fun GlobalDataResponse.toGlobalData(): GlobalData {
    return GlobalData(
        this.newConfirmed ?: EMPTY_LONG_NUMBER,
        this.totalConfirmed ?: EMPTY_LONG_NUMBER,
        this.newDeaths ?: EMPTY_LONG_NUMBER,
        this.totalDeaths ?: EMPTY_LONG_NUMBER,
        this.newRecovered ?: EMPTY_LONG_NUMBER,
        this.totalRecovered ?: EMPTY_LONG_NUMBER
    )
}