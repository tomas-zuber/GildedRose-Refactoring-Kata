package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `foo quality cannot be negative`() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("foo", item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo with quality 1`() {
        val items = listOf(Item("foo", 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("foo", item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo with quality 2`() {
        val items = listOf(Item("foo", 0, 2))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("foo", item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo sellIn can be negative`() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("foo", item.name)
        assertEquals(-1, item.sellIn)
    }

    @Test
    fun `Aged Brie with 0 sellIn 0 quality`() {
        val items = listOf(Item("Aged Brie", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("Aged Brie", item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(2, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }
}


