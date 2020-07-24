package br.com.souzabrunoj.domain.extension

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

fun Long.toStringFormat(): String {
    val formatter: DecimalFormat = NumberFormat.getInstance(Locale.US) as DecimalFormat
    val symbols: DecimalFormatSymbols = formatter.decimalFormatSymbols

    symbols.groupingSeparator = ' '
    formatter.decimalFormatSymbols = symbols

    return formatter.format(this)
}