package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("foo", item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

}


