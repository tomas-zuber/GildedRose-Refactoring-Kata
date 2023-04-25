package com.gildedrose

import kotlin.math.max
import kotlin.math.min

const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val FOO = "foo"
const val CONJURED = "Conjured"

private const val MAX_QUALITY = 50
private const val MIN_QUALITY = 0

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            updateItemQuality(item)
        }
    }

    private fun updateItemQuality(item: Item) {
        if (item.name == SULFURAS) {
            return
        }
        if (!increasesQualityByAging(item)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1

                if (item.name == BACKSTAGE) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + 1
                        }
                    }
                }
            }
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {
            item.quality = when (item.name) {
                AGED_BRIE -> min(MAX_QUALITY, item.quality + 1)
                BACKSTAGE -> 0
                else -> max(MIN_QUALITY, item.quality - 1)
            }
        }
    }

    private fun increasesQualityByAging(item: Item) = item.name in listOf(AGED_BRIE, BACKSTAGE)

}

