package com.gildedrose

const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val FOO = "foo"
const val CONJURED = "Conjured"

private const val MAX_QUALITY = 50
private const val MIN_QUALITY = 0
private const val BACKSTAGE_INCREASE1 = 10
private const val BACKSTAGE_INCREASE2 = 5

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
        updateQuality(item)
        updateSellIn(item)
    }

    private fun updateQuality(item: Item) {
        if (increasesQualityByAging(item)) {
            increaseQuality(item)

            if (item.name == BACKSTAGE) {
                if (item.sellIn <= BACKSTAGE_INCREASE1) {
                    increaseQuality(item)
                }
                if (item.sellIn <= BACKSTAGE_INCREASE2) {
                    increaseQuality(item)
                }
            }
        } else {
            decreaseQuality(item)
        }
    }

    private fun updateSellIn(item: Item) {
        item.sellIn -= 1

        if (item.sellIn < 0) {
            when (item.name) {
                AGED_BRIE -> increaseQuality(item)
                BACKSTAGE -> item.quality = 0
                else -> decreaseQuality(item)
            }
        }
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1
        }
    }

    private fun decreaseQuality(item: Item) {
        if (item.quality > MIN_QUALITY) {
            item.quality -= 1
        }
    }

    private fun increasesQualityByAging(item: Item) = item.name in listOf(AGED_BRIE, BACKSTAGE)

}

