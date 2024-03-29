package br.com.souzabrunoj.repository.mappers

import br.com.souzabrunoj.domain.commom.Helper.EMPTY_LONG_NUMBER
import br.com.souzabrunoj.domain.model.GlobalData
import br.com.souzabrunoj.repository.data.GlobalDataResponse

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