package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `foo quality cannot be negative`() {
        val items = listOf(Item(FOO, 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo with quality 1`() {
        val items = listOf(Item(FOO, 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo with quality 2`() {
        val items = listOf(Item(FOO, 0, 2))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(0, item.quality)
    }

    @Test
    fun `foo sellIn can be negative`() {
        val items = listOf(Item(FOO, 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(-1, item.sellIn)
    }

    @Test
    fun `Aged Brie with 0 sellIn 0 quality`() {
        val items = listOf(Item(AGED_BRIE, 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(AGED_BRIE, item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(2, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert with 0 sellIn 0 quality`() {
        val items = listOf(Item(BACKSTAGE, 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(BACKSTAGE, item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

    @Test
    fun `Sulfuras, Hand of Ragnaros with 0 sellIn 1 quality`() {
        val items = listOf(Item(SULFURAS, 0, 2))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(SULFURAS, item.name)
        assertEquals(0, item.sellIn)
        assertEquals(2, item.quality)
    }
}


