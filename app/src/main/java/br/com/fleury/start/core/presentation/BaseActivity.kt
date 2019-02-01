package br.com.fleury.start.core.presentation

import android.view.View
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.view_loader.*
import org.jetbrains.anko.toast

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

  override fun showToast(msg: String){
    toast(msg)
  }

}