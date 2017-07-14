package io.github.gianpamx.checkoutkata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity(), CheckoutPresenter.View {
    lateinit var presenter: CheckoutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val priceRules = HashMap<String, PriceRule>()
        priceRules.put("A", PriceRule(50f, { items -> if (items % 3 == 0) 20f else 0f }))
        priceRules.put("B", PriceRule(30f, { items -> if (items % 2 == 0) 15f else 0f }))
        priceRules.put("C", PriceRule(20f, { 0f }))
        priceRules.put("D", PriceRule(15f, { 0f }))

        presenter = CheckoutPresenter(this, Checkout(priceRules))

        scanButton.setOnClickListener(View.OnClickListener { view ->
            presenter.scan(inputEditText.text.toString())
        })
    }

    override fun showCheck(products: String, total: String) {
        productsTextView.text = products
        totalTextView.text = total
    }
}
