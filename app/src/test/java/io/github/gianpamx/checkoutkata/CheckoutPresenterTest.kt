package io.github.gianpamx.checkoutkata

import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

class CheckoutPresenterTest {
    val view: CheckoutPresenter.View = mock()

    lateinit var presenter: CheckoutPresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        presenter = CheckoutPresenter(view)
    }

    @Test
    @Throws(Exception::class)
    fun scan() {
        presenter.scan("")

        verify<CheckoutPresenter.View>(view).showCheck(anyString(), anyString())
    }
}
