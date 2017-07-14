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

        presenter = CheckoutPresenter(this)

        scanButton.setOnClickListener(View.OnClickListener { view ->
            presenter.scan(inputEditText.text.toString())
        })
    }

    override fun showCheck(products: String, total: String) {
        productsTextView.text = products
        totalTextView.text = total
    }
}
