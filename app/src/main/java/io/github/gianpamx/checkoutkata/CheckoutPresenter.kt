package io.github.gianpamx.checkoutkata

class CheckoutPresenter(val view: View) {
    fun scan(product: String) {
        view.showCheck("", "")
    }

    interface View {
        fun showCheck(products: String, total: String)
    }
}
