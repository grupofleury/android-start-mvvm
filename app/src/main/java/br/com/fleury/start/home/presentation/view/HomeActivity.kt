package br.com.fleury.start.home.presentation.view

import android.os.Bundle
import br.com.fleury.start.R
import br.com.fleury.start.core.presentation.BaseActivity

class HomeActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.home_activity)
    showLoader()
  }

}