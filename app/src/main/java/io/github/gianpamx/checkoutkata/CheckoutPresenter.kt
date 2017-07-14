package io.github.gianpamx.checkoutkata

class CheckoutPresenter(val view: View, val checkout: Checkout) {
    fun scan(product: String) {
        checkout.scan(product)
        view.showCheck("", "Total: $${checkout.total}")
    }

    interface View {
        fun showCheck(products: String, total: String)
    }
}
