package br.com.souzabrunoj.domain.extension

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberExtensionTest {

    @Test
    fun `toStringFormat MUST return a STRING with DECIMAL SEPARATORS`() {
        val result = 10000L.toStringFormat()
        assertEquals("10 000", result)
    }
}

