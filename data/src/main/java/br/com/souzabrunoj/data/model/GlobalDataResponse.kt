package br.com.souzabrunoj.data.model

import com.google.gson.annotations.SerializedName

data class GlobalDataResponse(
    @SerializedName("NewConfirmed") val newConfirmed: Long? = null,
    @SerializedName("TotalConfirmed") val totalConfirmed: Long? = null,
    @SerializedName("NewDeaths") val newDeaths: Long? = null,
    @SerializedName("TotalDeaths") val totalDeaths: Long? = null,
    @SerializedName("NewRecovered") val newRecovered: Long? = null,
    @SerializedName("TotalRecovered") val totalRecovered: Long? = null
)