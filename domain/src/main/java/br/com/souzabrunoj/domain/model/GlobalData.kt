package br.com.souzabrunoj.domain.model

import br.com.souzabrunoj.domain.extension.toStringFormat
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

data class GlobalData(val newConfirmed: Long,
                      val totalConfirmed: Long,
                      val newDeaths: Long,
                      val totalDeaths: Long,
                      val newRecovered: Long,
                      val totalRecovered: Long) {

    fun getNewConfirmedInStringFormat() = newConfirmed.toStringFormat()
}