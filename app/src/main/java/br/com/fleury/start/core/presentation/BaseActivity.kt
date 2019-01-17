package br.com.fleury.start.core.presentation

import android.view.View
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.view_loader.*

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {

  override fun onAttachedToWindow() {
    AndroidInjection.inject(this)
    super.onAttachedToWindow()
  }

  override fun showLoader() {
    progressBar.visibility = View.VISIBLE
  }

  override fun hideLoader() {
    progressBar.visibility = View.GONE
  }

}