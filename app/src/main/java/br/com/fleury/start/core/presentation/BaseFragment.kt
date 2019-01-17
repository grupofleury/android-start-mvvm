package br.com.fleury.start.core.presentation

import android.app.Activity
import android.content.Context
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

class BaseFragment : DaggerFragment(), BaseView {

  override fun onAttach(activity: Activity?) {
    AndroidSupportInjection.inject(this)
    super.onAttach(activity)
  }

  override fun onAttach(context: Context?) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun showLoader() {
  }

  override fun hideLoader() {
  }

}
