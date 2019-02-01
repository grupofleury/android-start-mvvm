package br.com.fleury.start.core.presentation

interface BaseView {

  fun showLoader()
  fun hideLoader()
  fun showToast(msg: String)
}