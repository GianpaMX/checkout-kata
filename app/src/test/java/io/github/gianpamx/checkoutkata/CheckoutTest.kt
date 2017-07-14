package io.github.gianpamx.checkoutkata

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CheckoutTest {
    lateinit var checkout: Checkout

    @Before
    fun setUp() {
        val prices = HashMap<String, PriceRule>()

        prices.put("A", PriceRule(50f, { items -> if (items % 3 == 0) 20f else 0f }))
        prices.put("B", PriceRule(30f, { items -> if (items % 2 == 0) 15f else 0f }))
        prices.put("C", PriceRule(20f, { 0f }))
        prices.put("D", PriceRule(15f, { 0f }))

        checkout = Checkout(prices)
    }

    @Test
    fun emptyItems() {
        Assert.assertEquals(0f, checkout.total)
    }

    @Test
    fun oneItem() {
        checkout.scan("A")

        Assert.assertEquals(50f, checkout.total)
    }

    @Test
    fun twoDifferentItems() {
        scan("AB")

        Assert.assertEquals(80f, checkout.total)
    }


    @Test
    fun fourDifferentItems() {
        scan("DCBA")

        Assert.assertEquals(115f, checkout.total)
    }

    @Test
    fun threeAItems() {
        scan("AAA")

        Assert.assertEquals(130f, checkout.total)
    }

    @Test
    fun sixAItems() {
        scan("AAAAAA")

        Assert.assertEquals(260f, checkout.total)
    }

    @Test
    fun threeAand2BItems() {
        scan("AAABB")

        Assert.assertEquals(175f, checkout.total)
    }

    @Test
    fun threeAand2B1DscrableItems() {
        scan("DABABA")

        Assert.assertEquals(190f, checkout.total)
    }

    fun scan(products: String) {
        products.forEach { s ->
            checkout.scan(s.toString())
        }
    }
}
