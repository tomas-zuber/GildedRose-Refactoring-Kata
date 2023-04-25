package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `quality of an item is never negative`() {
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
    fun `foo sellIn can be negative`() {
        val items = listOf(Item(FOO, 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(-1, item.sellIn)
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
    fun `Sulfuras, being a legendary item, never has to be sold or decreases in Quality`() {
        val items = listOf(Item(SULFURAS, 1, 2))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(SULFURAS, item.name)
        assertEquals(1, item.sellIn)
        assertEquals(2, item.quality)
    }

    @Test
    fun `Sulfuras, being a legendary item, its Quality is 80 and it never alters`() {
        val items = listOf(Item(SULFURAS, 1, 80))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(SULFURAS, item.name)
        assertEquals(1, item.sellIn)
        assertEquals(80, item.quality)
    }

    @Test
    fun `Sulfuras, being a legendary item, its Quality is 80 and it never alters 2`() {
        val items = listOf(Item(SULFURAS, -1, 80))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(SULFURAS, item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(80, item.quality)
    }

    @Test
    fun `Aged Brie increases in quality the older it gets`() {
        val items = listOf(Item(AGED_BRIE, -1, 6))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(AGED_BRIE, item.name)
        assertEquals(-2, item.sellIn)
        assertEquals(8, item.quality)
    }

    @Test
    fun `Once the sell by date has passed, Quality degrades twice as fast`() {
        val items = listOf(Item(FOO, -1, 6))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(-2, item.sellIn)
        assertEquals(4, item.quality)
    }

    @Test
    fun `Backstage passes increases in Quality by 2 when there are 10 days or less`() {
        val items = listOf(Item(BACKSTAGE, 10, 6))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(BACKSTAGE, item.name)
        assertEquals(9, item.sellIn)
        assertEquals(8, item.quality)
    }

    @Test
    fun `Backstage passes increases in Quality by 3 when there are 5 days or less`() {
        val items = listOf(Item(BACKSTAGE, 5, 6))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(BACKSTAGE, item.name)
        assertEquals(4, item.sellIn)
        assertEquals(9, item.quality)
    }

    @Test
    fun `Backstage passes Quality drops to 0 after the concert`() {
        val items = listOf(Item(BACKSTAGE, 0, 6))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(BACKSTAGE, item.name)
        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

//    Just for clarification, an item can never have its Quality increase above 50,

    @Test
    @Disabled // TODO Fix
    fun `The Quality of an item is never more than 50`() {
        val items = listOf(Item(FOO, 1, 60))
        val app = GildedRose(items)

        app.updateQuality()

        val item = app.items[0]
        assertEquals(FOO, item.name)
        assertEquals(0, item.sellIn)
        assertEquals(60, item.quality)
    }
}


