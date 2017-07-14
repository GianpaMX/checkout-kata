package io.github.gianpamx.checkoutkata

class Checkout(val priceRules: Map<String, PriceRule>) {
    var total: Float = 0f

    private val items: HashMap<String, Int> = HashMap()

    fun scan(product: String) {
        if (priceRules.containsKey(product)) {
            items[product] = items[product]?.plus(1) ?: 1

            var priceRule = priceRules[product]!!
            total += priceRule.price
            total -= priceRule.discount(items[product]!!)
        }
    }
}
