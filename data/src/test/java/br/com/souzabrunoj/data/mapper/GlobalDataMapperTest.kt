package br.com.souzabrunoj.data.mapper

import br.com.souzabrunoj.data.faker.GlobalDataResponseFaker
import org.junit.Assert.assertEquals
import org.junit.Test

class GlobalDataMapperTest {

    @Test
    fun `WHEN response has data MUST return a GlobalData with the fields values`() {
        val response = GlobalDataResponseFaker.getRandomData()

        val result = response.toGlobalData()

        assertEquals(response.totalConfirmed, result.totalConfirmed)
        assertEquals(response.totalDeaths, result.totalDeaths)
        assertEquals(response.totalRecovered, result.totalRecovered)
        assertEquals(response.newConfirmed, result.newConfirmed)
        assertEquals(response.newDeaths, result.newDeaths)
        assertEquals(response.newRecovered, result.newRecovered)
    }

    @Test
    fun `WHEN response has NO data MUST return a GlobalData with ZERO on fields values`() {
        val response = GlobalDataResponseFaker.getEmptyData()

        val result = response.toGlobalData()

        assertEquals(0L, result.totalConfirmed)
        assertEquals(0L, result.totalDeaths)
        assertEquals(0L, result.totalRecovered)
        assertEquals(0L, result.newConfirmed)
        assertEquals(0L, result.newDeaths)
        assertEquals(0L, result.newRecovered)
    }
}
